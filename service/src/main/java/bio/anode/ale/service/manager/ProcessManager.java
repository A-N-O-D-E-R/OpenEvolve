package bio.anode.ale.service.manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import bio.anode.ale.core.culture.Culture;
import bio.anode.ale.core.exception.ConnectorInstanciationException;
import bio.anode.ale.core.process.CultivationMode;
import bio.anode.ale.core.process.TriggerableWorkflow;
import bio.anode.ale.core.specifications.Operator;
import bio.anode.ale.core.specifications.Planning;
import bio.anode.ale.core.usage.fluidic.IntakeUsage;
import bio.anode.ale.service.MediaService;
import  bio.anode.ale.service.OperatorService;

public interface ProcessManager  extends OperatorService, MediaService {
    
    public Process getProcess();

	public void setProcess(Process process)
			throws IllegalStateException, CommunicationException, ConnectorInstanciationException, ParseException, MalformedAddressException, ProcesseurFluidiqueException;

	public void unsetProtocole() throws IllegalStateException;

	public void stop();

	public void startTache(TriggerableWorkflow tache, boolean steppingMode) throws IllegalStateException;

	public List<Planning> getPlanning(Date jusqua, TriggerableWorkflowFilter filter);

	public Date getProchainDeclenchement(TriggerableWorkflow tache);

	public ExecutionContexteView getExecutionContexte();

	public void validerEtapeEnCours() throws IllegalStateException;

	public void invaliderEtapeEnCours(String raison) throws IllegalStateException;

	public void annuleOperationEnCours() throws CommunicationException, IllegalStateException;

	public void activate(Culture culture) throws CommunicationException;

	public void deactivate(Culture culture) throws CommunicationException;

	public void deactivateCultures() throws CommunicationException;

	/**
	 * @return true if the culture has been updated
	 */
	public boolean updateCulture(Culture culture, CultivationMode courant, String protocoleParameters, String projectCode, String recipients, String comment, Operator origin) throws CommunicationException;

	public boolean updateCulture(Culture culture, CultivationMode courant, String protocoleParameters, String projectCode, String recipients, String comment, Operator origin, Boolean fullEventGeneration) throws CommunicationException;

	public void setReportingRecipients(Culture culture, String recipients) throws CommunicationException;

	/**
	 *
	 * @param source
	 * @param hoursBeforeEmpty
	 * @param consumptionPeriod as days
	 * @return
	 */
	public Refilling getNextRefilling(IntakeUsage source, int hoursBeforeEmpty, int consumptionPeriod) ;

	public Integer addStoryboard(String source, Boolean permanent) throws CommunicationException;

	public void updateStoryboard(Integer id, String source) throws CommunicationException;

	public void deleteNonPermanentTache(Integer id) throws CommunicationException;

	public void calibrateMediumFlowrate(IntakeUsage medium, String calibrationName) throws CalibrationException, CommunicationException, IOException;

	public void calibrateTransparency(Double initialOD) throws CalibrationException, CommunicationException, IOException;

	public void calibrateCultureVolume() throws CalibrationException, ConnectorInstanciationException, CommunicationException;

	public void stopCalibrating();

	public String getCalibratingStatus();

	public boolean isCalibrating();

	public String getCalibratingName();

	public void replaceMedium(String mediumPortName, String mediumCode, String preparatorCode, Date preparation, double volume, String comment, TriggerableWorkflow tache, Integer preparationIndex, Long calibrationId)
			throws IllegalStateException;
	
	public void removeMedium(String mediumPortName, String operatorCode, TriggerableWorkflow tache);

	public void updateCalibrationInUse(String mediumSourceName, Long calibrationId);
	
	public void changeInterpolatorIsValid(IntakeUsage mediaIntake, Long calibrationId) throws FileNotFoundException;
	
	public void inoculate(Culture culture, String strainCode, String preparatorCode, Date preparation, double volume, String comment, TriggerableWorkflow tache, Integer preparationIndex)
			throws IllegalStateException;

	@Override
	public List<Media> getMedia();

	@Override
	public void updateMediaFromStrings(List<String> mediaAsString);

	@Override
	public Medium getMedium(String code);

	@Override
	public List<Operator> getOperators();

	@Override
	public void updateOperatorsFromStrings(List<String> operatorAsString);

	@Override
	public Operator getOperator(String code);

}
