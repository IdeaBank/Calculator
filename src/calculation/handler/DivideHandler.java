package calculation.handler;

import calculation.ICalculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DivideHandler implements ICalculation {
    @Override
    public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) throws ArithmeticException {
        checkDivisionByZero(firstOperand, secondOperand);

        return firstOperand.divide(secondOperand, 10000, RoundingMode.HALF_UP);
    }

    private void checkDivisionByZero(BigDecimal firstOperand, BigDecimal secondOperand) throws ArithmeticException {
        if (secondOperand.compareTo(BigDecimal.ZERO) == 0) {
            if (firstOperand.compareTo(BigDecimal.ZERO) == 0)
                throw new ArithmeticException("정의되지 않은 결과입니다");

            throw new ArithmeticException("0으로 나눌 수 없습니다!");
        }
    }
}
