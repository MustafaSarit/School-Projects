package shapes.model ;

public class Line {
	private Point p1 ;
	private Point p2 ;
	private String a ;
	
	public Point accesP1() {
		return p1 ;
	}
	public Point accesP2() {
		return p2 ;
	}
	
	public Line (Point p1, Point p2) {
		this.p1 = p1 ;
		this.p2 = p2 ;
		a = p1.toString() + ", " + p2.toString() ;
	}
	
	public String toString() {
		return a ;
	}
	
	
	public double length() {
		return p1.distanceFromPoint(p2) ;
	}
	
	
	
	
}