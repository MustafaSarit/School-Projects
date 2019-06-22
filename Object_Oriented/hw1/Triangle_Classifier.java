public class Triangle_Classifier {
	
	public static void main(String[] args) {
		
		double side1 = Integer.parseInt(args[0]);
		double side2 = Integer.parseInt(args[1]);
		double side3 = Integer.parseInt(args[2]);
		
		double squareside1 = Math.pow(side1, 2);
		double squareside2 = Math.pow(side2, 2);
		double squareside3 = Math.pow(side3, 2);
		
		if ((side1 <= 0) || (side2 <= 0) || (side3 <= 0)) {
			System.out.println("A side of triangle can not be zero or negative numbers !!");
		} 
		else {
			
			if ((side1 + side2 > side3) && (Math.abs(side1 - side2) < side3)){
				if ((side1 == side2) && (side1 == side3)) {
					System.out.println("Equilateral Triangle !!");
				}
				else if ((side1 == side2) || (side1 == side3) || (side2 == side3)) {
					System.out.println("Isosceles Triangle");
				}
				else if ((squareside1 + squareside2 == squareside3) ||
				(squareside3 + squareside2 == squareside1) ||
				(squareside1 + squareside3 == squareside2)) {
				
					System.out.println("Right Triangle !!");
				}
				else {
					System.out.println("Scalene Triangle !!");
				}
			
			}
			else {
				System.out.println("Not a triangle !!");
			}
		}
	}
}