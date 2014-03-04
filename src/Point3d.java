//To hold a point in three dimensional system graph.

public class Point3d {
	private double x;
	private double y;
	private double z;
	
	//constructor for (0,0,0) component
	public Point3d(){
		this(0, 0, 0);
	}
	
	//main constructor
	public Point3d(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//return x value
	public double x(){
		return trim(x);
	}
	
	//return y value
	public double y(){
		return trim(y);
	}
	
	//return the magnitude
	public double getMagnitude(){
		return trim( Math.sqrt((x*x) + (y*y) + (z*z)) );
	}
	
	
	//return z value
	public double z(){
		return trim(z);
	}
	
	//return, only keep 2 decimal places  
	public double trim(double num){
		return (int)(num * 100) / 100.0;
	}
	
	public String toString(){
		return "<" + x() + ", " + y() + ", " + z() + ">";
	}

	public double getDotProduct(Point3d p2) {
		return trim((x * p2.x) + (y * p2.y) + (z * p2.z));
		
	}

	public Point3d getCrossProduct(Point3d p2){
		return new Point3d( ((y*p2.z)-(p2.y*z)), -((x*p2.z)-(p2.x*z)), ((x*p2.y)-(p2.x*y)));
	}

	public Point3d getVector(Point3d p2) {
		return new Point3d((p2.x - x), (p2.y - y), (p2.z - z));
	}
	
	public double getAngleRadian(Point3d p2){
		return trim(Math.acos( (getDotProduct(p2) / getMagnitude() / p2.getMagnitude()) ) * 1);
	}
	
	public double getAngleDegree(Point3d p2){
		return trim(getAngleRadian(p2) * (180.0/3.14));
	}

	public double getAreaTriangle(Point3d p1, Point3d p2) {
		return trim(p1.getCrossProduct(p2).getMagnitude() * .5);
	}
	
	
}
