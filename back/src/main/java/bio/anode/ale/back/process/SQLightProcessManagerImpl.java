package bio.anode.ale.back.process;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import bio.anode.ale.core.culture.Culture;
import bio.anode.ale.core.exception.CalibrationException;
import bio.anode.ale.core.exception.CommunicationException;
import bio.anode.ale.core.exception.ConnectorInstanciationException;
import bio.anode.ale.core.exception.FluidicProcessorException;
import bio.anode.ale.core.exception.MalformedAddressException;
import bio.anode.ale.core.filter.process.TriggerableWorkflowFilter;
import bio.anode.ale.core.process.CultivationMode;
import bio.anode.ale.core.process.TriggerableWorkflow;
import bio.anode.ale.core.specifications.Media;
import bio.anode.ale.core.specifications.Operator;
import bio.anode.ale.core.specifications.Planning;
import bio.anode.ale.core.usage.fluidic.IntakeUsage;
import bio.anode.ale.core.view.ExecutionContexteView;
import bio.anode.ale.core.view.Refilling;
import bio.anode.ale.service.manager.ProcessManager;

public class SQLightProcessManagerImpl implements ProcessManager {

    @Override
    public List<String> exportOperatorsToCSV(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportOperatorsToCSV'");
    }

    @Override
    public List<String> exportMediaToCSV(String var1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportMediaToCSV'");
    }

    @Override
    public Process getProcess() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProcess'");
    }

    @Override
    public void setProcess(Process process) throws IllegalStateException, CommunicationException,
            ConnectorInstanciationException, ParseException, MalformedAddressException, FluidicProcessorException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setProcess'");
    }

    @Override
    public void unsetProtocole() throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unsetProtocole'");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }

    @Override
    public void startTache(TriggerableWorkflow tache, boolean steppingMode) throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startTache'");
    }

    @Override
    public List<Planning> getPlanning(Date jusqua, TriggerableWorkflowFilter filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlanning'");
    }

    @Override
    public Date getProchainDeclenchement(TriggerableWorkflow tache) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProchainDeclenchement'");
    }

    @Override
    public ExecutionContexteView getExecutionContexte() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExecutionContexte'");
    }

    @Override
    public void validerEtapeEnCours() throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validerEtapeEnCours'");
    }

    @Override
    public void invaliderEtapeEnCours(String raison) throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'invaliderEtapeEnCours'");
    }

    @Override
    public void annuleOperationEnCours() throws CommunicationException, IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'annuleOperationEnCours'");
    }

    @Override
    public void activate(Culture culture) throws CommunicationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'activate'");
    }

    @Override
    public void deactivate(Culture culture) throws CommunicationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deactivate'");
    }

    @Override
    public void deactivateCultures() throws CommunicationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deactivateCultures'");
    }

    @Override
    public boolean updateCulture(Culture culture, CultivationMode courant, String protocoleParameters,
            String projectCode, String recipients, String comment, Operator origin) throws CommunicationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCulture'");
    }

    @Override
    public boolean updateCulture(Culture culture, CultivationMode courant, String protocoleParameters,
            String projectCode, String recipients, String comment, Operator origin, Boolean fullEventGeneration)
            throws CommunicationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCulture'");
    }

    @Override
    public void setReportingRecipients(Culture culture, String recipients) throws CommunicationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setReportingRecipients'");
    }

    @Override
    public Refilling getNextRefilling(IntakeUsage source, int hoursBeforeEmpty, int consumptionPeriod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNextRefilling'");
    }

    @Override
    public Integer addStoryboard(String source, Boolean permanent) throws CommunicationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addStoryboard'");
    }

    @Override
    public void updateStoryboard(Integer id, String source) throws CommunicationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStoryboard'");
    }

    @Override
    public void deleteNonPermanentTache(Integer id) throws CommunicationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteNonPermanentTache'");
    }

    @Override
    public void calibrateMediumFlowrate(IntakeUsage medium, String calibrationName)
            throws CalibrationException, CommunicationException, IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calibrateMediumFlowrate'");
    }

    @Override
    public void calibrateTransparency(Double initialOD)
            throws CalibrationException, CommunicationException, IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calibrateTransparency'");
    }

    @Override
    public void calibrateCultureVolume()
            throws CalibrationException, ConnectorInstanciationException, CommunicationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calibrateCultureVolume'");
    }

    @Override
    public void stopCalibrating() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stopCalibrating'");
    }

    @Override
    public String getCalibratingStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCalibratingStatus'");
    }

    @Override
    public boolean isCalibrating() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCalibrating'");
    }

    @Override
    public String getCalibratingName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCalibratingName'");
    }

    @Override
    public void replaceMedium(String mediumPortName, String mediumCode, String preparatorCode, Date preparation,
            double volume, String comment, TriggerableWorkflow tache, Integer preparationIndex, Long calibrationId)
            throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replaceMedium'");
    }

    @Override
    public void removeMedium(String mediumPortName, String operatorCode, TriggerableWorkflow tache) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMedium'");
    }

    @Override
    public void updateCalibrationInUse(String mediumSourceName, Long calibrationId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCalibrationInUse'");
    }

    @Override
    public void changeInterpolatorIsValid(IntakeUsage mediaIntake, Long calibrationId) throws FileNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeInterpolatorIsValid'");
    }

    @Override
    public void inoculate(Culture culture, String strainCode, String preparatorCode, Date preparation, double volume,
            String comment, TriggerableWorkflow tache, Integer preparationIndex) throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inoculate'");
    }

    @Override
    public List<Media> getMedia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMedia'");
    }

    @Override
    public void updateMediaFromStrings(List<String> mediaAsString) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateMediaFromStrings'");
    }

    @Override
    public Media getMedium(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMedium'");
    }

    @Override
    public List<Operator> getOperators() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOperators'");
    }

    @Override
    public void updateOperatorsFromStrings(List<String> operatorAsString) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOperatorsFromStrings'");
    }

    @Override
    public Operator getOperator(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOperator'");
    }
    
}
