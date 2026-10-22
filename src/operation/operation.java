package operation;

import java.io.Serializable;

public class operation implements Serializable {

    private double operande1;
    private String operateur;
    private double operande2;

    public operation(double operande1, String operateur, double operande2) {
        this.operande1 = operande1;
        this.operateur = operateur;
        this.operande2 = operande2;
    }

    public double getOperande1() {
        return operande1;
    }

    public String getOperateur() {
        return operateur;
    }

    public double getOperande2() {
        return operande2;
    }
}