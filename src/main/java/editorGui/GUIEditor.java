package editorGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIEditor extends JFrame implements ActionListener {

    TextArea textArea;
    JScrollPane scrollPane;

    MenuBar menuBar;

    public GUIEditor() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Code Editor");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        // Creating text area
        textArea = new TextArea();

        // Adding vertical scroll bar
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(480, 480));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Setting up menu bar
        menuBar = new MenuBar();

        this.setJMenuBar(menuBar);
        this.add(scrollPane);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
