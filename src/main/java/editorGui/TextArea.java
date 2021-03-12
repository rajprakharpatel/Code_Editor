package editorGui;

import javax.swing.*;

@SuppressWarnings("serial")
public class TextArea extends JTextArea {
    public TextArea() {
        this.setLineWrap(true);
        this.setWrapStyleWord(true);

    }

}
