
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
        this.setFont(new Font(this.getFont().getFamily(), Font.PLAIN,24));
        this.setCaretColor(Color.WHITE);



        this.setSelectedTextColor(Color.BLUE);


    }

}