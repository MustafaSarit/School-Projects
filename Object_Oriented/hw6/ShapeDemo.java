public class ShapeDemo {
	public static void main(String[] list) {
		
		Shape circle  = new Circle() ;
		Shape circle1 = new Circle(7.0) ;
		Shape circle2 = new Circle(4.0, "Navy Blue", true) ;
		Shape circle3 = new Circle(6.0, "Yellow", false) ;
		
		Shape rect  = new Rectangle() ;
		Shape rect1 = new Rectangle(5.0, 7.0) ;
		Shape rect2 = new Rectangle(3.0, 6.0, "Black", false) ;
		Shape rect3 = new Rectangle(12.0, 10.0, "Green", true) ;
		
		Shape square  = new Square() ;
		Shape square1 = new Square(5.0) ;
		Shape square2 = new Square(20, "Gray", true) ;
		Shape square3 = new Square(15, "Orange", false) ;
		
		System.out.println(circle) ;
		System.out.println("Perimeter of circle = " + circle.getPerimeter()) ;
		System.out.println("Area of circle = " + circle.getArea()) ;
		
		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(circle1) ;
		System.out.println("Perimeter of circle = " + circle1.getPerimeter()) ;
		System.out.println("Area of circle = " + circle1.getArea()) ;

		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(circle2) ;
		System.out.println("Perimeter of circle = " + circle2.getPerimeter()) ;
		System.out.println("Area of circle = " + circle2.getArea()) ;
		
		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(circle3) ;
		System.out.println("Perimeter of circle = " + circle3.getPerimeter()) ;
		System.out.println("Area of circle = " + circle3.getArea()) ;
		
		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(rect) ;
		System.out.println("Perimeter of rectangle = " + rect.getPerimeter()) ;
		System.out.println("Area of rectangle = " + rect1.getArea()) ;
		
		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(rect1) ;
		System.out.println("Perimeter of rectangle = " + rect1.getPerimeter()) ;
		System.out.println("Area of rectangle = " + rect1.getArea()) ;
		
		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(rect2) ;
		System.out.println("Perimeter of rectangle = " + rect2.getPerimeter()) ;
		System.out.println("Area of rectangle = " + rect2.getArea()) ;
		
		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(rect3) ;
		System.out.println("Perimeter of rectangle = " + rect3.getPerimeter()) ;
		System.out.println("Area of rectangle = " + rect3.getArea()) ;
		
		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(square) ;
		System.out.println("Perimeter of square = " + square.getPerimeter()) ;
		System.out.println("Area of square = " + square.getArea()) ;
		
		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(square1) ;
		System.out.println("Perimeter of square = " + square1.getPerimeter()) ;
		System.out.println("Area of square = " + square1.getArea()) ;
		
		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(square2) ;
		System.out.println("Perimeter of square = " + square2.getPerimeter()) ;
		System.out.println("Area of square = " + square2.getArea()) ;
		
		System.out.println("----------------------------------------------------------") ;
		
		System.out.println(square3) ;
		System.out.println("Perimeter of square = " + square3.getPerimeter()) ;
		System.out.println("Area of square = " + square3.getArea()) ;
		
	}
}