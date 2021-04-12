package editorGui;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;

import jsitter.api.*;

public class TextPane extends JTextPane {

    public TextPane() {
        System.out.println("Starting Traversing...");
        this.setText("Starting Traversing...");
        try {
            visiting();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) {
        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    NodeType sourceFile = new NodeType("source_file");

    public Language<NodeType> javaLang() throws ClassNotFoundException {
        Language<NodeType> lang = Language.load(sourceFile, "go", "tree_sitter_go", "tsgo.dll",
                Class.forName("jsitter.api.Language").getClassLoader());
        lang.register(sourceFile);
        System.out.println("Returning lang");
        return lang;
    }


    public void visiting() throws ClassNotFoundException {
        Language<NodeType> lang = javaLang();
        Parser<NodeType> parser = lang.parser();
        Tree<NodeType> tree = parser.parse(new StringText(readFile("test.go")), null);
        Zipper<?> zipper = tree.getRoot().zipper();
        StringBuilder sourceCode = new StringBuilder();
        while (zipper != null) {
            String NodeTypeStr = "NodeTypeStr: " + zipper.getNode().getType();
            String byteSize = "";
            byteSize = "AliasStr: " + zipper.getByteSize() + "\n";
            sourceCode.append(NodeTypeStr).append("::").append(byteSize).append("\n");
            zipper = zipper.next();
        }
        this.setText(sourceCode.toString());
    }
}
