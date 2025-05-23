package main;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        System.setProperty("awt.useSystemAAFontSettings", "on");

        JFrame window = new JFrame("GOLOM CHESS");

        window.setIconImage(new ImageIcon(Objects.requireNonNull(Main.class.getResource("/golom.png"))).getImage());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.setResizable(false);

        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        window.setFocusable(true);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.launchGame();
    }
}
