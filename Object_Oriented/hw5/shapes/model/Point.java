package shapes.model ;

public class Point {
	private double X ;
	private double Y ;
	private String a ;
	
	public double accesX() {
		return X ;
	}
	public double accesY() {
		return Y ;
	}
	
	public Point(int x, int y) {
		X = x ;
		Y = y ;
		a = "(x = " + x + ", y = " + y + ")" ;
	}
	
	public String toString() {
		return a ;
	}
	
	
	public double distanceFromPoint(Point p2) {
		return Math.sqrt(Math.pow(X - p2.accesX(), 2) + Math.pow(Y - p2.accesY(), 2)) ;
	}
	
	
	
	
}