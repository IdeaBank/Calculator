package data;

import constant.CalculatorState;

import java.math.BigDecimal;

public class CalculatorData {
    private static CalculatorData _instance;

    private final BigDecimal firstOperand;
    private final BigDecimal secondOperand;
    private final CalculatorState calculatorState;

    private CalculatorData() {
        this.firstOperand = new BigDecimal(0);
        this.secondOperand = new BigDecimal(0);
        this.calculatorState = CalculatorState.START;
    }

    public static CalculatorData getInstance() {
        if (CalculatorData._instance == null)
            _instance = new CalculatorData();

        return _instance;
    }
}
