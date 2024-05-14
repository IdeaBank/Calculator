package controller;

import calculation.CalculatorHandlerCollection;
import constant.CalculatorButtonType;
import constant.CalculatorState;
import constant.OperatorType;
import data.CalculatorData;
import util.DataValidation;
import view.CalculatorView;

import java.math.BigDecimal;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorHandlerCollection calculatorHandlerCollection;

    public CalculatorController() {
        this.calculatorView = new CalculatorView();
        this.calculatorHandlerCollection = new CalculatorHandlerCollection();
    }

    public void processNumberPressed(char ch) {
        if (!DataValidation.isNumber(ch))
            return;

        calculatorView.showResult(String.valueOf(ch));
    }

    public void processOperatorPressed(CalculatorButtonType buttonType) {
        if (CalculatorData.getInstance().getCalculatorState() == CalculatorState.OPERATOR_PRESSED) {
            changeOperator(buttonType);
        } else if (CalculatorData.getInstance().getCalculatorState() == CalculatorState.NUMBER_PRESSED) {
            processCalculation();
            changeOperator(buttonType);
        }

        CalculatorData.getInstance().setCalculatorState(CalculatorState.OPERATOR_PRESSED);
    }

    private void changeOperator(CalculatorButtonType buttonType) {
        switch (buttonType) {
            case ADD -> CalculatorData.getInstance().setOperator(OperatorType.ADD);
            case SUBTRACT -> CalculatorData.getInstance().setOperator(OperatorType.SUBTRACT);
            case MULTIPLY -> CalculatorData.getInstance().setOperator(OperatorType.MULTIPLY);
            case DIVIDE -> CalculatorData.getInstance().setOperator(OperatorType.DIVIDE);
        }
    }

    public void processSpecialKeyPressed(CalculatorButtonType buttonType) {
        if (buttonType == CalculatorButtonType.CE) {
            processClearEntry();
        } else if (buttonType == CalculatorButtonType.C) {
            processClear();
        } else if (buttonType == CalculatorButtonType.DEL) {
            processDelete();
        } else if (buttonType == CalculatorButtonType.PERIOD) {
            processPeriod();
        } else if (buttonType == CalculatorButtonType.NEGATE) {
            processNegate();
        } else if (buttonType == CalculatorButtonType.CALCULATE) {
            processCalculation();
        }
    }

    private void processCalculation() {
        if(CalculatorData.getInstance().getSecondOperand() == null) {
            CalculatorData.getInstance().setSecondOperand(CalculatorData.getInstance().getFirstOperand());
            CalculatorData.getInstance().getFirstOperand()
            return;
        }

        if (CalculatorData.getInstance().getCalculatorState() == CalculatorState.NUMBER_PRESSED || CalculatorData.getInstance().getCalculatorState() == CalculatorState.OPERATOR_PRESSED || CalculatorData.getInstance().getCalculatorState() == CalculatorState.CALCULATED) {
            try {
                switch (CalculatorData.getInstance().getOperator()) {
                    case ADD ->
                            CalculatorData.getInstance().setFirstOperand(calculatorHandlerCollection.getAddHandler().calculate(CalculatorData.getInstance().getFirstOperand(), CalculatorData.getInstance().getSecondOperand()));
                    case SUBTRACT ->
                            CalculatorData.getInstance().setFirstOperand(calculatorHandlerCollection.getSubtractHandler().calculate(CalculatorData.getInstance().getFirstOperand(), CalculatorData.getInstance().getSecondOperand()));
                    case MULTIPLY ->
                            CalculatorData.getInstance().setFirstOperand(calculatorHandlerCollection.getMultiplyHandler().calculate(CalculatorData.getInstance().getFirstOperand(), CalculatorData.getInstance().getSecondOperand()));
                    case DIVIDE ->
                            CalculatorData.getInstance().setFirstOperand(calculatorHandlerCollection.getDivideHandler().calculate(CalculatorData.getInstance().getFirstOperand(), CalculatorData.getInstance().getSecondOperand()));
                }
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException: " + e.getMessage());
            }
        }
    }

    private void processClearEntry() {
        CalculatorData.getInstance().clearEntry();
    }

    private void processClear() {
        CalculatorData.getInstance().initializeData();

    }

    private void processDelete() {

    }

    private void processPeriod() {

    }

    private void processNegate() {
        CalculatorState state = CalculatorData.getInstance().getCalculatorState();

        if (CalculatorData.getInstance().getFirstOperand().compareTo(BigDecimal.ZERO) == 0 && !CalculatorData.getInstance().isPeriodPressed()) {
            return;
        }

        if (state == CalculatorState.OPERATOR_PRESSED || state == CalculatorState.CALCULATED) {
            // TODO: Negate 중첩
        }

        CalculatorData.getInstance().setFirstOperand(CalculatorData.getInstance().getFirstOperand().negate());
    }
}
