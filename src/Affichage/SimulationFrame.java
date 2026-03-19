package Affichage;
import Modelisation.Environnement;
import Modelisation.Agent;
/*
Sarah Ouknine 11/10/25
 */
import javax.swing.*;

public class SimulationFrame extends JFrame {

    Environnement env;
    SimulationPanel panel;

    public SimulationFrame(int scenario) {

        env = new Environnement(20, 15);

        env.generateRandomObstacles(20);
        env.generateRandomPlaces(5);

        Agent a1 = new Agent("Sarah", 1, 1, env);
        Agent a2 = new Agent("Chloe", 3, 4, env);
        Agent a3 = new Agent("B", 6, 2, env);

        env.addAgent(a1);
        env.addAgent(a2);
        env.addAgent(a3);

        if (scenario == 2)
            a1.etat = "malade";

        panel = new SimulationPanel(env);

        add(panel);

        setSize(1000, 700);
        setTitle("Simulation SMA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        for (Agent a : env.agents)
            a.start();

        Timer t = new Timer(40, e -> panel.repaint());
        t.start();
    }
}
