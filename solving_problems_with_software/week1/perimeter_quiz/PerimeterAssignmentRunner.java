
import java.io.File;
import edu.duke.*;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoint = 0;
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            numPoint++;
        }
        return numPoint;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double perimeter = getPerimeter (s);
        double averageLength = perimeter / (double)getNumPoints(s);
        return averageLength;
    }
    
    public double max(double arg1, double arg2){
        if(arg1 > arg2){
            return arg1;
        }
        else{
        return arg2;
        }
    }
    
    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double largestSide = 0.0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            largestSide = max(largestSide, currDist);
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        
        return largestSide;
    }

    public double getLargestX(Shape s) {
        
        // Put code here
         Point lastPoint = s.getLastPoint();
        int lastPointX = lastPoint.getX();
        double largestX = (double) lastPointX;
        
        for(Point p : s.getPoints()){
            int newX = p.getX();
            if((double)newX > largestX) {
                largestX = (double) newX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        FileResource largestFile = null;

        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if(perim > largestPerim) {
                largestPerim = perim;
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;

        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if(perim > largestPerim) {
                largestPerim = perim;
                largestFile = f;
            }
        }

        return largestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter is: " + largest);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is: " + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        
        pr.testPerimeter();
    }
}
