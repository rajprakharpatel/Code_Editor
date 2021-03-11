package editorGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIEditor extends JFrame implements ActionListener {

    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu viewMenu;
    JMenu buildMenu;

    JMenuItem newItem;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem saveAsItem;

    public GUIEditor() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Code Editor");
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

// Creating text area
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
// Adding vertical scroll bar
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(480, 480));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

// Setting up menu bar

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");
        buildMenu = new JMenu("Build");

        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        saveAsItem = new JMenuItem("Save As");


        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(buildMenu);


        fileMenu.add(openItem);
        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
//


        this.setJMenuBar(menuBar);
        this.add(scrollPane);


        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
