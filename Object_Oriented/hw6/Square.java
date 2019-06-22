public class Square extends Rectangle {
	public Square(){}
	
	public Square(double side) {
		super(side, side) ;
	}
	
	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled) ;
	}
	
	public double getSide() {
		return super.getWidth() ;
	}
	
	public void setSide(double side) {
		super.setWidth(side) ;
		super.setLength(side) ;
	}
	
	public double getArea() {
		return super.getArea() ;
	}
	
	public double getPerimeter() {
		return super.getPerimeter() ;
	}
	
	public String toString() {
		return "A Square with side = " + super.getWidth() + ", which is a subclass of " + super.toString() ;
	}
}