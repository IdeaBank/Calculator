package calculation.handler;

import calculation.ICalculation;

import java.math.BigDecimal;

public class AddHandler implements ICalculation {
    @Override
    public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.add(secondOperand);
    }
}
