package Modelisation;
import java.util.*;

/*
Sarah Ouknine 04/10/25
 */

public class Node implements Comparable<Node>{

    public Point2D position;
    public double cost;
    public double heuristic;
    public Node parent;

    public Node(Point2D p,double cost,double h,Node parent){
        this.position=p;
        this.cost=cost;
        this.heuristic=h;
        this.parent=parent;
    }

    public double score(){
        return cost+heuristic;
    }

    @Override
    public int compareTo(Node o){
        return Double.compare(score(),o.score());
    }
}