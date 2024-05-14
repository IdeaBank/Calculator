package data;

import constant.CalculatorState;
import constant.OperatorType;

import java.math.BigDecimal;

public class CalculatorData {
    private static CalculatorData _instance;

    private BigDecimal firstOperand;
    private BigDecimal secondOperand;
    private OperatorType operator;
    private CalculatorState calculatorState;
    private boolean periodPressed;

    private CalculatorData() {
        initializeData();
    }

    public static CalculatorData getInstance() {
        if (CalculatorData._instance == null)
            _instance = new CalculatorData();

        return _instance;
    }

    public BigDecimal getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(BigDecimal firstOperand) {
        this.firstOperand = firstOperand;
    }

    public BigDecimal getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(BigDecimal secondOperand) {
        this.secondOperand = secondOperand;
    }

    public OperatorType getOperator() {
        return operator;
    }

    public void setOperator(OperatorType operator) {
        this.operator = operator;
    }

    public CalculatorState getCalculatorState() {
        return calculatorState;
    }

    public void setCalculatorState(CalculatorState calculatorState) {
        this.calculatorState = calculatorState;
    }

    public boolean isPeriodPressed() {
        return this.periodPressed;
    }

    public void setPeriodPressed(boolean periodPressed) {
        this.periodPressed = periodPressed;
    }

    public void clearEntry() {
        this.secondOperand = new BigDecimal(0);
        this.calculatorState = CalculatorState.NUMBER_PRESSED;
    }

    public void initializeData() {
        this.firstOperand = null;
        this.secondOperand = null;
        this.operator = OperatorType.NONE;
        this.calculatorState = CalculatorState.NUMBER_PRESSED;

        this.periodPressed = false;
    }
}
