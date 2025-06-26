package bio.anode.ale.core.event.operators;

import bio.anode.ale.core.event.hardware.HardwareEvent;
import bio.anode.ale.core.specifications.Operator;

public abstract class OperatorEvent extends HardwareEvent{
    private Operator operator;
    private String comment;
}
