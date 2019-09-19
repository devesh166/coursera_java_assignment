package demo;

import edu.duke.*;
import java.io.File;

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
    	int count =0;
    	for(Point p: s.getPoints()) {
    		count++;
    	}
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
    	double avgLenth= getPerimeter(s)/ getNumPoints(s) ;
    	
        return avgLenth;
    }

    public double getLargestSide(Shape s) {
        // Put code here
    	Point prevPt = s.getLastPoint();
    	double largestSide=0;
    	for(Point currPt : s.getPoints()) {
    		double sideLength=currPt.distance(prevPt);
    		if(sideLength>largestSide) {
    			largestSide=sideLength;
    		}
    		prevPt=currPt;
    	}
        return largestSide;
    }

    public double getLargestX(Shape s) {
    	   double largestX = 0;
           for(Point currpt : s.getPoints()){
               double currX = currpt.getX();
               if(currX>largestX) largestX=currX;
           }
           return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
    	DirectoryResource dr = new DirectoryResource();
    	double largestParameter=0;
    	for(File f: dr.selectedFiles()) {
    		FileResource fr = new FileResource();
    		Shape s = new Shape(fr);
    		double currParameter = getPerimeter(s);
    		if(currParameter>largestParameter)
    		 largestParameter=currParameter;
    		    		
    	}
        return largestParameter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
    	DirectoryResource dr = new DirectoryResource();
    	double largestParameter=0;
    	File large=null;
    	for(File f: dr.selectedFiles()) {
    		FileResource fr = new FileResource();
    		Shape s = new Shape(fr);
    		double currParameter = getPerimeter(s);
    		if(currParameter>largestParameter) {
    			largestParameter=currParameter;
    			large = f;
    		} 	 
    		  		
    	}
        return large.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("no. of points ="+getNumPoints(s));
        System.out.println("Average length ="+getAverageLength(s));
        System.out.println("Largest side ="+ getLargestSide(s));
        System.out.println("Largest x = "+ getLargestX(s));
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter is: " + largest);
    }

    public void testFileWithLargestPerimeter() {
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
