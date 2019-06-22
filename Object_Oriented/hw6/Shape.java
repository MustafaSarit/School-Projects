public class Shape {
	
	private String color ;
	private boolean filled ;
	
	public Shape() {
		this.color = "Red" ;
		this.filled = true ;
	}
	
	public Shape(String color, boolean filled) {
		this.color = color ;
		this.filled = filled ;
	}
	
	public String isColor() {
		return this.color ;
	}
	
	public boolean isFilled() {
		return this.filled ;
	}
	
	public void setColor(String color){
		this.color = color ;
	}
	
	public void setFilled(boolean filled){
		this.filled = filled ;
	}
	
	
	public double getArea() {
		return 0.0 ;
	}
	
	public double getPerimeter() {
		return 0.0 ;
	}
	
	public String toString(){
		if (this.filled == true){
			return "A shape with color of " + this.color + " and filled" ;
		}
		return "A shape with color of " + this.color + " and not filled" ;
	}
	
}