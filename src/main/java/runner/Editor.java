package runner;
import javax.swing.*;

import editorGui.GuiFrame;

public class Editor {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception e) {
            System.err.println("Look and feel not set.");
        }
        GuiFrame guiFrame = new GuiFrame("Code Editor");
        guiFrame.setContentPane(guiFrame.mainPanel);
        guiFrame.setVisible(true);
    }
}
