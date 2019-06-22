package shapes.demo;

import shapes.model.Line;
import shapes.model.Point;
import shapes.model.PolyLine;

public class Test {

	public static void main(String[] args) {
		Point p1 = new Point(2,2);
		System.out.println(p1);
		//Expected output: (x = 2, y = 2)
		
		Point p2 = new Point(5,6);
		
		System.out.println(p1.distanceFromPoint(p2));
		//Expected output: 5.0
		
		Line line1 = new Line(p1,p2);
		System.out.println(line1);
		//Expected output: (x = 2, y = 2), (x = 5, y = 6)
		
		System.out.println(line1.length());
		//Expected output: 5.0
		
 
		PolyLine polyLine1 = new PolyLine();
		polyLine1.addPoint(new Point(-3,-10));
		System.out.println(polyLine1);
		//Expected output: [(x = -3, y = -10)]
		
		System.out.println(polyLine1.length());
		//Expected output: 0.0
		
		polyLine1.addLine(line1);
		System.out.println(polyLine1);
		//Expected output: [(x = -3, y = -10), (x = 2, y = 2), (x = 5, y = 6)]
		
		System.out.println(polyLine1.length());
		//Expected output: 18.0
		
		PolyLine polyLine2 = new PolyLine(new Line(new Point(8, 0), new Point(0, -6)));
		System.out.println(polyLine2);
		//Expected output: [(x = 8, y = 0), (x = 0, y = -6)]
		
		System.out.println(polyLine2.length());
		//Expected output: 10.0
		
		
		polyLine2.addPolyLine(polyLine1);
		System.out.println(polyLine2);
		//Expected output: [(x = 8, y = 0), (x = 0, y = -6), (x = -3, y = -10), (x = 2, y = 2), (x = 5, y = 6)]
		
		System.out.println(polyLine2.length());
		//Expected output: 33.0
		
		PolyLine polyLine3 = polyLine2.reverse(); 
		System.out.println(polyLine3);
		//Expected output: [(x = 5, y = 6), (x = 2, y = 2), (x = -3, y = -10), (x = 0, y = -6), (x = 8, y = 0)]
		
	}

}