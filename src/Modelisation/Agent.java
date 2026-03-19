package Modelisation;
import java.util.*;
/*
Chloé Ribault 03/10/25
 */

public class Agent extends Thread{

    public String name;
    public double x;
    public double y;

    public String etat="sain";
    public String humeur="neutre";

    public Point2D destination=null;
    public List<Point2D> path=new ArrayList<>();

    public boolean running=true;

    Environnement env;
    Random rand=new Random();

    public Agent(String name,double x,double y,Environnement env){

        this.name=name;
        this.x=x;
        this.y=y;
        this.env=env;
    }

    void choisirDestination(){

        if(env.places.isEmpty()) return;

        destination=env.places.get(
                rand.nextInt(env.places.size())
        );

        path=AStar.astar(
                new Point2D(x,y),
                destination,
                env.obstacles,
                0.5,
                0.8
        );
    }

    void avancer(){

        if(!path.isEmpty()){

            Point2D p=path.remove(0);
            x=p.x;
            y=p.y;
        }
    }

    void verifierInteractions(){

        for(Agent a:env.agents){

            if(a==this) continue;

            if(Math.abs(x-a.x)<0.5 && Math.abs(y-a.y)<0.5){

                if(etat.equals("malade") && a.etat.equals("sain")){

                    if(rand.nextDouble()<0.6)
                        a.etat="malade";
                }
            }
        }
    }

    public void run(){

        while(running){

            if(destination==null || path.isEmpty())
                choisirDestination();

            avancer();
            verifierInteractions();

            try{
                Thread.sleep(200);
            }catch(Exception e){}
        }
    }
}