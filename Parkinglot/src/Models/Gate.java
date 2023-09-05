package Models;

public class Gate extends BaseEntity {
    private GateType gateType;
    private Operator operator;

    public GateType getGateType() {
        return this.gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return this.operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    
}
