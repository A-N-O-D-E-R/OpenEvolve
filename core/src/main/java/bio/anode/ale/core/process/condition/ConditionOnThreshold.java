package bio.anode.ale.core.process.condition;

import java.util.UUID;

import bio.anode.ale.core.usage.sensor.SensorUsage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConditionOnThreshold implements Condition {
    private UUID id;
    private double threshold;
	private int delayInMinutes = 0; 
	private boolean superior = false;
	private SensorUsage sensorUsage;
	private transient long delayCounter = 0;
	private transient String lastCheckContexte;

    public synchronized boolean conditionRemplie() throws IllegalStateException {
		SensorUsage sondeUsage = getSensorUsage();

		if (sondeUsage.getLastMeasure() == null || !sondeUsage.isAccessible()) {
			throw new IllegalStateException("Measure is not available");
		}

		double mesure = sondeUsage.getMeasure();

		boolean conditionSeuilRemplie = superior ? mesure >= threshold : mesure <= threshold;

		lastCheckContexte = "Trigger threshold is " + (conditionSeuilRemplie ? "" : "not ") + "reached" + " : measure ("
				+ mesure + ") is " + (superior ? "above" : "below") + " or equal to threshold (" + threshold + ")";

		if (delayInMinutes == 0) {
			return conditionSeuilRemplie;
		}

		if (delayCounter == 0) {

			if (conditionSeuilRemplie) {
				delayCounter = delayInMinutes + System.currentTimeMillis() / 60000;
			}

			return false;
		} else if ((System.currentTimeMillis() / 60000) >= delayCounter) {
			return true;
		} else {
			return false;
		}
	}

	public void restartConditionChecking() {
		delayCounter = 0;
	}

	public String getLastCheckContexte() {
		return lastCheckContexte;
	}
}
