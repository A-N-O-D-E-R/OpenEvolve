package bio.anode.ale.back.server;

import java.io.IOException;
import java.io.InputStream;

import bio.anode.ale.back.Application;
import lombok.extern.slf4j.Slf4j;
import sila_java.library.server_base.SiLAServer;
import sila_java.library.server_base.identification.ServerInformation;
import sila_java.library.server_base.utils.ArgumentHelper;
import sila_java.library.sila_base.EmptyClass;
import static sila_java.library.core.utils.FileUtils.getFileContent;

@Slf4j
public class LabEvolveSilaServer  implements AutoCloseable {
    public static final ServerInformation SERVER_INFORMATION = new ServerInformation(
        LabEvolveSilaServer.class.getSimpleName(),
        "Server for test purposes",
        "https://www.sila-standard.org",
        Application.getVersion()
    );
    private final SiLAServer server;

    public LabEvolveSilaServer(final ArgumentHelper args){
        try {
            SiLAServer.Builder builder= SiLAServer.Builder.newBuilder(SERVER_INFORMATION)
                .withPersistentConfig(args.getConfigFile().isPresent())
                .withPersistentTLS(
                    args.getPrivateKeyFile(),
                    args.getCertificateFile(),
                    args.getCertificatePassword()
                );
                args.getConfigFile().ifPresent(builder::withPersistentConfigFile);
                if (args.useUnsafeCommunication()) {
                    builder.withUnsafeCommunication(true);
                }
                
                args.getHost().ifPresent(builder::withHost);
                args.getPort().ifPresent(builder::withPort);
                args.getInterface().ifPresent(builder::withNetworkInterface);
                builder.withDiscovery(args.hasNetworkDiscovery());

                InputStream is = LabEvolveSilaServer.class.getClassLoader().getResourceAsStream("GreetingProvider-v1_0.sila.xml");
                log.info(is.toString());
                builder.addFeature(
                        getFileContent(is),
                        new SayHelloCommand()
                );

                this.server = builder.start();
        } catch (IOException e) {
            log.error("Something went wrong when building / starting server", e);
            throw new RuntimeException(e);
        }
    }


    public void close(){
        this.server.close();
    }
}
