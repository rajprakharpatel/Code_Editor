package editorGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class GUIEditor extends JFrame implements ActionListener {

    TextPane textPane;
    JScrollPane scrollPane;
    JPanel panel;
    JTabbedPane tabPane;

    MenuBar menuBar;

    public GUIEditor() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ev) {
                // e.printStackTrace();
                System.err.println("Look and feel not set.");
            }
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Code Editor");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        // Creating text area
        textPane = new TextPane();

        // Panel to hold textPane and scrollBars
        panel = new JPanel(new BorderLayout());
        panel.add(textPane);

        // Adding vertical and horizontal scroll bar
        scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(500, 500));

        // Setting up menu bar
        menuBar = new MenuBar(textPane);

        // Setting up tabbed pane
        tabPane = new JTabbedPane();
        tabPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // TODO: implement highlight to call from here
                // textPane.highlight();
            }
        });
        tabPane.add(scrollPane);

        this.setJMenuBar(menuBar);
        this.add(tabPane);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
