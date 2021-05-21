package editorGui;

import editorMethods.LangFormatter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar implements ActionListener {

    private final TextPane textPane;
    public String extension;
    public String path;
    public String name;
    public String progDir;
    private String OSName;

    public MenuBar(TextPane tp, String osName) {

        OSName = osName;
        textPane = tp;
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu buildMenu = new JMenu("Build");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save as");
        JMenuItem exitItem = new JMenuItem("Exit");

        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JMenuItem findItem = new JMenuItem("Find");
        JMenuItem runItem = new JMenuItem("Run");
        JMenuItem stopItem = new JMenuItem("Stop");

        saveAsItem.addActionListener(this);
        saveItem.addActionListener(this);
        runItem.addActionListener(this);
        exitItem.addActionListener(this);
        openItem.addActionListener(this);
        stopItem.addActionListener(this);


        this.add(fileMenu);
        this.add(editMenu);
        this.add(buildMenu);


        fileMenu.add(openItem);
        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(exitItem);

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(findItem);


        buildMenu.add(runItem);
        buildMenu.add(stopItem);
    }

    public void compAndRun(String path, String name) {


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String d = e.getActionCommand();
        if (d.equals("Save as")) {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            int Response = fileChooser.showSaveDialog(null);

            if (Response == JFileChooser.APPROVE_OPTION) {
                File file;
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                path = file.getAbsolutePath();
                // System.out.println(path);
                name = file.getName();
                System.out.println(name);
                try (PrintWriter fileOut = new PrintWriter(file)) {
                    fileOut.println(textPane.getText());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        }
        if (d.equals("Run")) {
            progDir = path.replaceAll("\\\\", "/");

            int ij = progDir.lastIndexOf("/");
            progDir = progDir.substring(0, ij);


            int index = name.lastIndexOf('.');
            if (index > 0) {
                extension = name.substring(index + 1);
            }
            switch (extension) {
                    case "c":
                    try {
                        Runtime.getRuntime().exec("gcc " + progDir + "/" + name + " -o " + progDir + "/" + name.substring(0, index));
                        Thread.sleep(2000);
                        if (OSName.equals("Linux")) {
                            Runtime.getRuntime().exec("alacritty --hold -e " + progDir + "/" + name.substring(0, index));
                        } else {
                            Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + progDir + "/" + name.substring(0, index) + ".exe");
                        }
                    } catch(IOException | InterruptedException ioException){
                        ioException.printStackTrace();
                    }
                    break;
                case "cpp":
                    try {
                        // System.out.println("g++ " + progDir + "/" + name + " -o " + progDir + name.substring(0, index));
                        Runtime.getRuntime().exec("g++ " + progDir + "/" + name + " -o " + progDir + "/" + name.substring(0, index));
                        Thread.sleep(2000);
                        System.out.println("Compiled");
                        if (OSName.equals("Linux")) {
                            Runtime.getRuntime().exec("alacritty --hold -e " + progDir + "/" + name.substring(0, index));
                        } else {
                            Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + progDir + "/" + name.substring(0, index) + ".exe");
                        }
                    } catch (IOException | InterruptedException ioException) {
                        ioException.printStackTrace();
                    }
                    break;
                case "java":
                    try {

                        if (OSName.equals("Linux")) {
                            Runtime.getRuntime().exec("alacritty --hold -e ./src/main/resources/jlinux.sh " + progDir + " " + name.substring(0, index) + " 5");
                        } else {
                            Runtime.getRuntime().exec("cmd /c start ./src/main/resources/script.bat " + progDir + " " + name.substring(0, index));
                            System.out.println("Compiled");
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    break;
                case "py":
                    // System.out.println("Python file");
                    try {
                        if (OSName.equals("Linux")) {
                            Runtime.getRuntime().exec("alacritty --hold -e python " + progDir + "/" + name);
                        } else {
                            Runtime.getRuntime().exec("cmd /c start cmd.exe /K python " + progDir + "/" + name);
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    break;
            }
        }
        if(d.equals("Save")){
            progDir = path.replaceAll("\\\\", "/");

            int ij = progDir.lastIndexOf("/");
            progDir = progDir.substring(0, ij);


            int index = name.lastIndexOf('.');
            if (index > 0) {
                extension = name.substring(index + 1);
            }
            // System.out.println("Save called");
            File file = new File(path);
            try(PrintWriter fileOut = new PrintWriter(file)) {
                fileOut.println(textPane.getText());

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            LangFormatter langFormatter = new LangFormatter(extension, OSName);
            langFormatter.format(path);

        }


        if (d.equals("Exit")) {
            System.exit(0);
        }
        if (d.equals("Open")) {

            // System.out.println("Open button called");
            textPane.setText("");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                path = file.getAbsolutePath();
                System.out.println(path);
                name = file.getName();
                Scanner fileIn;

                try {
                    fileIn = new Scanner(file);
                    if (file.isFile()) {
                        while (fileIn.hasNextLine()) {
                            String line = fileIn.nextLine() + "\n";
                            textPane.append(line);
                        }
                    }

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }

            }

            progDir = path.replaceAll("\\\\", "/");

            int ij = progDir.lastIndexOf("/");
            progDir = progDir.substring(0, ij);


            int index = name.lastIndexOf('.');
            if (index > 0) {
                extension = name.substring(index + 1);
            }
        }

    }
}

