package AbarrotesVictor;

import Views.Login;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            java.awt.EventQueue.invokeLater(() -> {
                new Login().setVisible(true);
            });
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println(e.toString());
        }
    }
    
}
