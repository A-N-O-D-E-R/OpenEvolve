package bio.anode.ale.core.view;

import java.util.Date;

import bio.anode.ale.core.hardware.Hardware;
import bio.anode.ale.core.usage.fluidic.IntakeUsage;

public class Refilling {
    private Date estimatedRefillingDate;
    private Hardware hardware;
    private IntakeUsage intake;
    private int hoursBeforeEmpty;
    private double consumptionVolume;
    private double consumptionPeriod;
    private double estimatedConsumptionVolume;
}
