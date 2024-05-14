package listener;

import constant.CalculatorButtonType;
import controller.CalculatorController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
    public CalculatorController calculatorController;

    public KeyboardListener() {
        this.calculatorController = new CalculatorController();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getExtendedKeyCode()) {
            case KeyEvent.VK_0:
            case KeyEvent.VK_1:
            case KeyEvent.VK_2:
            case KeyEvent.VK_3:
            case KeyEvent.VK_4:
            case KeyEvent.VK_5:
            case KeyEvent.VK_6:
            case KeyEvent.VK_7:
            case KeyEvent.VK_8:
            case KeyEvent.VK_9:
                calculatorController.processNumberPressed(e.getKeyChar());
                break;

            case KeyEvent.VK_PLUS:
                calculatorController.processOperatorPressed(CalculatorButtonType.ADD);
                break;
            case KeyEvent.VK_MINUS:
                calculatorController.processOperatorPressed(CalculatorButtonType.SUBTRACT);
                break;
            case KeyEvent.VK_MULTIPLY:
            case 151:
                calculatorController.processOperatorPressed(CalculatorButtonType.MULTIPLY);
                break;
            case KeyEvent.VK_DIVIDE:
            case 47:
                calculatorController.processOperatorPressed(CalculatorButtonType.DIVIDE);
                break;

            case KeyEvent.VK_ESCAPE:
                calculatorController.processSpecialKeyPressed(CalculatorButtonType.C);
                break;
            case KeyEvent.VK_DELETE:
                calculatorController.processSpecialKeyPressed(CalculatorButtonType.CE);
                break;
            case KeyEvent.VK_BACK_SPACE:
                calculatorController.processSpecialKeyPressed(CalculatorButtonType.DEL);
                break;
            case KeyEvent.VK_PERIOD:
                calculatorController.processSpecialKeyPressed(CalculatorButtonType.PERIOD);
                break;

            case KeyEvent.VK_EQUALS:
            case KeyEvent.VK_ENTER:
                calculatorController.processSpecialKeyPressed(CalculatorButtonType.CALCULATE);
                break;
        }
    }
}
