import Affichage.MenuFrame;

import javax.swing.*;
/*
Chloé Ribault 05/10/25
 */
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new MenuFrame();
        });

    }
}