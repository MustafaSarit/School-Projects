public class BinaryConverter {
	public static void main(String[] list) {
		String operator = list[0];
		int number = Integer.parseInt(list[1]);
		
		if (operator.equals("i2b")) {
			if (number == 0) {
				System.out.print("0");
			}
			else if (number < 0) {
				System.out.print("For now this program can't work for negative numbers may be later");
			}
			else {
				String value = "" ;
				System.out.print(int_to_bin(number, value));
				}
		}

		else if (operator.equals("b2i")) {
			
			int total_send = 0 ;
			int counter_send = 0 ;
			if (bin_to_int(number, total_send, counter_send) == -1) {
				System.out.print("This number can't be a binary number");
			}
			else if (bin_to_int(number, total_send, counter_send) == -2) {
				System.out.print("For now this program can't work for negative numbers may be later");
			}
			else {
				System.out.print(bin_to_int(number, total_send, counter_send)) ;
			}
		}
		
		else {
			System.out.println("There is no such a operator for this program !!");
		}
		
	}
	
	public static String int_to_bin(int decimal, String result) {
		if (decimal > 0) {
			result = int_to_bin(decimal / 2, result);
			result = result + Integer.toString(decimal % 2);
		}
		return result ;
	}
	
	public static int bin_to_int(int integer, int total, int counter) {
		int divisor = 0 ;
		if (integer > 0) {
			divisor = integer % 10 ;
		
			if (divisor > 1) {
				return -1;
			}
			
			int power = 1 ;
			int contr = 0 ;
			while (counter > contr) {
				power = power * 2 ;
				contr++;
			}
		
			total = total + (divisor * power) ;
			counter++  ;
			total = bin_to_int(integer / 10, total, counter) ;
			}
		
		else if (integer == 0) {
			return total;
		}
		
		else {
			return -2 ;
		}
		return total ;
	}
	
}