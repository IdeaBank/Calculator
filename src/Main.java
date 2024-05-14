import listener.KeyboardListener;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setVisible(true);

        frame.addKeyListener(new KeyboardListener());
    }
}