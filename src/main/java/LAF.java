//Script for listing installed Look and feels
import javax.swing.UIManager;

public class LAF {
    public static void main(String[] a) {
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
        }
    }
}

