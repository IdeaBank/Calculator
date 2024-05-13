package calculation;

import java.math.BigDecimal;
import java.math.MathContext;

public class MultiplyHandler implements ICalculation {
    @Override
    public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
        checkDivisionByZero(firstOperand, secondOperand);

        return firstOperand.multiply(secondOperand, MathContext.UNLIMITED);
    }
}
