package Affichage;
/*
Chloé Ribault 11/10/25
 */
import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {

    public MenuFrame() {

        setTitle("Simulation SMA");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // couleurs
        Color roseFond = new Color(255, 192, 203);
        Color matcha = new Color(139, 190, 135);

        getContentPane().setBackground(roseFond);

        // panel principal
        JPanel panel = new JPanel();
        panel.setBackground(roseFond);
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        Font fontTitre = new Font("Segoe UI", Font.BOLD, 42);
        Font fontBouton = new Font("Segoe UI", Font.BOLD, 22);


        JLabel titre = new JLabel("Simulation SMA");
        titre.setForeground(matcha);
        titre.setFont(fontTitre);
        titre.setHorizontalAlignment(SwingConstants.CENTER);

        // boutons
        JButton start = new JButton("Démarrer");
        JButton quit = new JButton("Quitter");

        start.setFont(fontBouton);
        quit.setFont(fontBouton);

        start.setBackground(matcha);
        quit.setBackground(matcha);

        start.setForeground(Color.WHITE);
        quit.setForeground(Color.WHITE);

        start.setFocusPainted(false);
        quit.setFocusPainted(false);


        start.addActionListener(e -> choisirScenario());
        quit.addActionListener(e -> System.exit(0));


        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(titre, gbc);

        gbc.gridy = 1;
        panel.add(start, gbc);

        gbc.gridy = 2;
        panel.add(quit, gbc);

        add(panel);
        setVisible(true);
    }

    private void choisirScenario() {

        String[] options = {
                "Déplacement simple",
                "Propagation maladie",
                "Propagation rumeur"
        };

        Color rose = new Color(255, 192, 203);
        Color matcha = new Color(107, 163, 104);

        UIManager.put("OptionPane.background", rose);
        UIManager.put("Panel.background", rose);

        UIManager.put("OptionPane.messageForeground", matcha);

        UIManager.put("Button.background", matcha);
        UIManager.put("Button.foreground", Color.WHITE);

        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 18));
        UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 16));

        int choix = JOptionPane.showOptionDialog(
                this,
                "Choisissez un scénario",
                "Scénario",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choix >= 0) {
            new SimulationFrame(choix + 1);
            dispose();
        }
    }
}