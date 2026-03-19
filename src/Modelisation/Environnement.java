package Modelisation;
/*
Chloé Ribault 03/10/25
 */
import java.util.*;

public class Environnement {

    public int width;
    public int height;

    public List<Agent> agents=new ArrayList<>();
    public List<Point2D> obstacles=new ArrayList<>();
    public List<Point2D> places=new ArrayList<>();

    Random rand=new Random();

    public Environnement(int w,int h){
        width=w;
        height=h;
    }

    public void generateRandomObstacles(int n){

        for(int i=0;i<n;i++){
            obstacles.add(
                    new Point2D(rand.nextDouble()*width,
                            rand.nextDouble()*height)
            );
        }
    }

    public void generateRandomPlaces(int n){

        for(int i=0;i<n;i++){
            places.add(
                    new Point2D(rand.nextDouble()*width,
                            rand.nextDouble()*height)
            );
        }
    }

    public void addAgent(Agent a){
        agents.add(a);
    }
}