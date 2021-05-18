
package editorGui;

import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;

public class TextPane extends JTextArea {
    public TextPane() {

        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setBackground(Color.DARK_GRAY);
        this.setForeground(Color.WHITE);


        this.setSelectedTextColor(Color.cyan);


    }

}