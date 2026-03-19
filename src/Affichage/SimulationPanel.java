package Affichage;
import Modelisation.*;
/*
Sarah Ouknine 11/10/25
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;


public class SimulationPanel extends JPanel{

    Environnement env;
    BufferedImage map;

    int scale=50;

    public SimulationPanel(Environnement env){

        this.env=env;

        try {
            map = ImageIO.read(getClass().getResource("map.png"));
        } catch (Exception e) {
            System.out.println("Image non trouvée");
        }
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        if(map!=null)
            g.drawImage(map,0,0,getWidth(),getHeight(),null);

        for(Point2D o:env.obstacles){

            g.setColor(Color.BLACK);
            g.fillRect((int)(o.x*scale),(int)(o.y*scale),10,10);
        }

        for(Point2D p:env.places){

            g.setColor(Color.GREEN);
            g.fillOval((int)(p.x*scale),(int)(p.y*scale),12,12);
        }

        for(Agent a:env.agents){

            if(a.etat.equals("malade"))
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLUE);

            g.fillOval((int)(a.x*scale),(int)(a.y*scale),15,15);
        }
    }
}