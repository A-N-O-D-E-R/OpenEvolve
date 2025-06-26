package bio.anode.ale.back;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

import bio.anode.ale.back.server.LabEvolveSilaServer;
import lombok.extern.slf4j.Slf4j;
import sila_java.library.server_base.utils.ArgumentHelper;

@Slf4j
public class Application {

	private static final String THREAD_NAME = "MAIN THREAD";
	private static final String APPLICATION_NAME = "backend";
	private static final Path ARCHIVE_DIR = Path.of("/tmp/backup");
	private static Application instance = new Application();

	private LabEvolveSilaServer server;

	private static boolean started = false;


	public static Application getInstance() {
		return instance;
	}


    public static void main(String[] args) {
        Thread.currentThread().setName(THREAD_NAME);
        log.info(APPLICATION_NAME+" - version : " + getVersion());
		storePid(ARCHIVE_DIR.resolve(APPLICATION_NAME+".pid"));
		 
		configure();
		installShutdownHook();
		getInstance().startEngine(new ArgumentHelper(args, LabEvolveSilaServer.class.getSimpleName()));
    }
    


	private static void configure() {
		
	}


	public final synchronized void startEngine(ArgumentHelper args) {
		if (started){
			log.warn(APPLICATION_NAME+", is already start, ignore command");
		}else{
			try{
				log.info("starting system ...");
				
				startManagers();

				server =new LabEvolveSilaServer(args);
				log.info("system started");
			} catch (Throwable throwable) {
				log.error("Failed to initialize : stopped.", throwable);
				Runtime.getRuntime().halt(1);
			}
		}
	}

	private void startManagers() throws IllegalStateException, ProcesseurFluidiqueException {
		try {
			EventManagerSingleton.getInstance().start();
		} catch (Throwable e) {
			log.warn("While starting event manager  : ", e);
		}

		try {
			RobotManagerSingleton.getInstance().start();
		} catch (ProcesseurFluidiqueException e) {
			log.error("While starting robot manager  : ", e);
			throw e ;
		} catch (Throwable e) {
			log.warn("While starting robot manager  : ", e);
		}

		try {
			ProtocoleManagerSingleton.getInstance().start();
		} catch (ProcesseurFluidiqueException e) {
			log.error("While starting protocole manager  : ", e);
			throw e ;	
		} catch (Throwable e) {
			log.warn("While starting protocole manager  : ", e);
		}

		EventHistorySingleton.start(EventManagerSingleton.getInstance());
		
		FailoverSynchronizer.synchronize();

	}


	public final synchronized void stopEngine(String cmd){
		server.close();
	}

	private static void installShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				Application.getInstance().stopEngine(null);
			}
		});
	}


    public static String getVersion() {
		try{
			Properties pomProperties = new Properties();
			InputStream stream = Application.class.getClassLoader().getResourceAsStream("META-INF/maven/bio.anode.ale/back/pom.properties");
			if(stream==null){
				return "0.0.0";
			}
			pomProperties.load(stream);
			return pomProperties.getProperty("version", "0.0.0");
		}catch(IOException e){
			log.error("Failed to load version of controler", e);
			return "unknown" ;
		}
	}

	public static void storePid(Path pidFile) {
		  try {
				// Check and create parent directory if it does not exist
				Path parentDir = pidFile.getParent();
				if (parentDir != null && !Files.exists(parentDir)) {
					Files.createDirectories(parentDir);
				}

				// Check and create the file if it does not exist
				if (!Files.exists(pidFile)) {
					Files.createFile(pidFile);
				}

				// Write the PID to the file
				try (BufferedWriter writer = Files.newBufferedWriter(pidFile, StandardOpenOption.WRITE)) {
					writer.write(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
				}
			} catch (IOException e) {
				log.warn("Cannot store pid:", e);
			}
		}
}
