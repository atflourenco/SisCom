package sistemacomercial;

import javax.swing.JFrame;
import view.ViewPrincipal;

public class Main {
    public static void main(String[] args) {
        ViewPrincipal viewPrincipal = new ViewPrincipal();
        viewPrincipal.setLocationRelativeTo(null);
        viewPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        viewPrincipal.setVisible(true);
    }
}
