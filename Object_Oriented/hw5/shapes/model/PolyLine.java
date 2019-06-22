package shapes.model ;
import java.util.ArrayList ;


public class PolyLine {
	private ArrayList<Point> points = new ArrayList() ;
	private String str ;
	
	public ArrayList accesPoints() {
		return points ;
	}
	
	public PolyLine(){
		
	}
	
	public PolyLine(Line a) {
		addLine(a) ;
	}
	
	public PolyLine(PolyLine a) {
		addPolyLine(a) ;
	}
	
	public PolyLine(Point a) {
		addPoint(a) ;
	}
	
	public void addPoint(Point a) {
		points.add(a) ;
	}
	
	public void addPolyLine(PolyLine a) {
		for (int i = 0; i < a.points.size(); i++){
			points.add(a.points.get(i)) ;
		}
	}
	
	public void addLine(Line a) {
		addPoint(a.accesP1()) ;
		addPoint(a.accesP2()) ;
	}
	
	
	public double length(){
		double total = 0.0 ;
			
		for (int i = 0; i < points.size(); i++){
			if (i == points.size() - 1) {
				return total ;
			}
			else {
				total += points.get(i).distanceFromPoint(points.get(i + 1))  ;
			}
		}
		return total ;
	}
	
	public PolyLine reverse(){
		PolyLine revers = new PolyLine() ;
		
		for (int i = points.size() - 1; i >= 0 ; i--){
			revers.points.add(points.get(i)) ;
		}
		return revers ;
	}
	
	public String toString() {
		str = "[" ;
		for (int i = 0 ; i < points.size() - 1; i++) {
			str += points.get(i) + ", " ; 
		}
		
		str += points.get(points.size()-1) + "]" ; 
	
		return str ;
	}
	
}