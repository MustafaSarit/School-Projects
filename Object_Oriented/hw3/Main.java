public class Main {
	
	public static void main(String[] args) {
		
		MyDate date = new MyDate(28,2,2017);
		
		String strRep = date.toString();
		System.out.println(strRep);
		//Expected output: 2017-02-28
		
		date.incrementDay();
		System.out.println(date.toString());
		//Expected output: 2017-03-01
				
		date.incrementYear(3);
		System.out.println(date.toString());
		//Expected output: 2020-03-01		
		
		date.decrementDay();
		System.out.println(date.toString());
		//Expected output: 2020-02-29
		
		date.decrementYear();
		System.out.println(date.toString());
		//Expected output: 2019-02-28
		
		date.decrementMonth();
		System.out.println(date.toString());
		//Expected output: 2019-01-28
		
		date.incrementDay(3);
		System.out.println(date.toString());
		//Expected output: 2019-01-31
		
		
	}
}