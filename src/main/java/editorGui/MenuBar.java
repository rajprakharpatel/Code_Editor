package editorGui;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
    public MenuBar() {
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu buildMenu = new JMenu("Build");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");

        this.add(fileMenu);
        this.add(editMenu);
        this.add(viewMenu);
        this.add(buildMenu);

        fileMenu.add(openItem);
        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
    }

}
