package calculation;

import calculation.handler.AddHandler;
import calculation.handler.DivideHandler;
import calculation.handler.MultiplyHandler;
import calculation.handler.SubtractHandler;

public class CalculatorHandlerCollection {
    private AddHandler addHandler;
    private SubtractHandler subtractHandler;
    private MultiplyHandler multiplyHandler;
    private DivideHandler divideHandler;

    public CalculatorHandlerCollection() {
        addHandler = new AddHandler();
        subtractHandler = new SubtractHandler();
        multiplyHandler = new MultiplyHandler();
        divideHandler = new DivideHandler();
    }

    public AddHandler getAddHandler() {
        return addHandler;
    }

    public SubtractHandler getSubtractHandler() {
        return subtractHandler;
    }

    public MultiplyHandler getMultiplyHandler() {
        return multiplyHandler;
    }

    public DivideHandler getDivideHandler() {
        return divideHandler;
    }
}
