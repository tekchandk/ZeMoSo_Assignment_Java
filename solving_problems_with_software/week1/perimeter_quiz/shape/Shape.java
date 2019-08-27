package perimeter_quiz.shape;
import java.io.File;
import perimeter_quiz.fileresource;
import perimeter_quiz.point;
public class Shape{

    public Shape(){};
    public Shape(Fileresource file){
        for(String line : file.lines()){
            s.addPoint(line);
            System.out.println(line);
        }
        for (Point p : s.getPoints()) {
            System.out.println(p);
        }

    }
    public void addPoint(Point p){
        Shape s = new Shape();
        s.add(p);
    }
    public Point  getLastPoint(){
        return p;
    }

    public Iterable<Point> getPoints(){


    }
}
