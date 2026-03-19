package Modelisation;
import java.util.*;
/*
Sarah Ouknine 04/10/25
 */
class AStar {

    public static List<Point2D> astar(Point2D start, Point2D goal,
                                      List<Point2D> obstacles,
                                      double step,
                                      double obstacleRadius){

        PriorityQueue<Node> open = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();

        open.add(new Node(start,0,distance(start,goal),null));

        while(!open.isEmpty()){

            Node current = open.poll();

            if(distance(current.position,goal)<step){
                return buildPath(current,goal);
            }

            String key = key(current.position);

            if(visited.contains(key))
                continue;

            visited.add(key);

            for(double dx=-step;dx<=step;dx+=step){
                for(double dy=-step;dy<=step;dy+=step){

                    if(dx==0 && dy==0) continue;

                    double nx=current.position.x+dx;
                    double ny=current.position.y+dy;

                    if(!positionValide(nx,ny,obstacles,obstacleRadius))
                        continue;

                    Point2D np = new Point2D(nx,ny);

                    double cost=current.cost+step;
                    double h=distance(np,goal);

                    open.add(new Node(np,cost,h,current));
                }
            }
        }

        return new ArrayList<>();
    }

    static boolean positionValide(double x,double y,List<Point2D> obs,double r){

        for(Point2D o:obs){
            if(distance(new Point2D(x,y),o)<r)
                return false;
        }
        return true;
    }

    static double distance(Point2D a,Point2D b){
        return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
    }

    static String key(Point2D p){
        return ((int)(p.x*10))+"-"+((int)(p.y*10));
    }

    static List<Point2D> buildPath(Node node,Point2D goal){

        List<Point2D> path=new ArrayList<>();

        while(node!=null){
            path.add(0,node.position);
            node=node.parent;
        }

        path.add(goal);
        return path;
    }
}