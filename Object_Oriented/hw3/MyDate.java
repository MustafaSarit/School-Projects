public class MyDate {
	int day ;
	int month ;
	int year ;

	public MyDate(int d, int m, int y){
		day = d ;
		month = m ;
		year = y ;
		
	}
	
	public String toString() {
		String sday = String.format("%02d", day) ;
		String smonth = String.format("%02d", month) ;
		String syear = Integer.toString(year) ;
		return (syear + "-" + smonth + "-" + sday) ;
		
	}
	
	public void incrementDay (int a) {
		if (year % 4 == 0) {
			if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)) {
				if (day + a > 31) {
					day = day + a - 31 ;
					month++ ;
				}
				else {
					day = day + a ;
				}

			}
			else if (month == 2) {
				if (day + a > 29 ) {
					day = day + a - 29 ;
					month++ ;
				}
				else {
					day = day + a ;
				}
			}
			else if (month == 12) {
				if (day + a > 31) {
					day = day + a - 31 ;
					month = 1 ;
					year++ ;
				}
				else{
					day = day + a ;
				}
			}
			else{
				if (day + a > 30) {
					day = day + a - 30 ;
					month++ ;
				}
				else {
					day = day + a ;
				}
			}
			
		}
		else {
			if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)) {
				if (day + a > 31) {
					day = day + a - 31 ;
					month++ ;
				}
				else {
					day = day + a ;
				}

			}
			else if (month == 2) {
				if (day + a > 28 ) {
					day = day + a - 28 ;
					month++ ;
				}
				else {
					day = day + a ;
				}
			}
			else if (month == 12) {
				if (day + a > 31) {
					day = day + a - 31 ;
					month = 1 ;
					year++ ;
				}
				else{
					day = day + a ;
				}
			}
			else{
				if (day + a == 30) {
					day = day + a - 30 ;
					month++ ;
				}
				else {
					day = day + a ;
				}
			}
			
		}
		
	
	}
	
	public int incrementYear(int a) {
		year = year + a ;
		return year ;
	}
	
	public void decrementDay() {
		if (year % 4 == 0) {
			if (month == 1){
				if (day == 1){
					day = 31 ;
					month = 12 ;
					year-- ;
				}
				else {
					day-- ;
				}
			}
			else if (month == 3) {
				if (day == 1) {
					day = 29 ;
					month-- ;
				}
				else {
					day-- ;
				}
			}
			else if ((month == 2) || (month == 4) || (month == 6) || (month == 8) || (month == 9) || (month == 11)) {
				if (day == 1) {
					day = 31 ;
					month-- ;
				}
				else {
					day-- ;
				}
			}
			else{
				if (day == 1) {
					day = 30 ;
					month-- ;
				}
			}
		}
		else {
			if (month == 1){
				if (day == 1){
					day = 31 ;
					month = 12 ;
					year-- ;
				}
				else {
					day-- ;
				}
			}
			else if (month == 3) {
				if (day == 1) {
					day = 28 ;
					month-- ;
				}
				else {
					day-- ;
				}
			}
			else if ((month == 2) || (month == 4) || (month == 6) || (month == 8) || (month == 9) || (month == 11)) {
				if (day == 1) {
					day = 31 ;
					month-- ;
				}
				else {
					day-- ;
				}
			}
			else{
				if (day == 1) {
					day = 30 ;
					month-- ;
				}
				else {
					day-- ;
				}
			}
		}
	}
	public int decrementYear() {
		if ((year % 4 == 0) && (month == 2) && (day == 29)) {
			year-- ;
			day = 28 ;
		}
		else {
			year-- ;
		}
		return year ;
	}
	
	public int decrementMonth() {
		if (month == 1){
			month = 12 ;
			year-- ;
		}
		else {
			month-- ;
		}
		return month ;
	}
	
	public void incrementDay () {
		if (year % 4 == 0) {
			if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)) {
				if (day == 31) {
					day = 1 ;
					month++ ;
				}
				else {
					day++  ;
				}

			}
			else if (month == 2) {
				if (day == 29 ) {
					day = 1 ;
					month++ ;
				}
				else {
					day++ ;
				}
			}
			else if (month == 12) {
				if (day == 31) {
					day = 1 ;
					month = 1 ;
					year++ ;
				}
				else{
					day++ ;
				}
			}
			else{
				if (day == 30) {
					day = 1 ;
					month++ ;
				}
				else {
					day++ ;
				}
			}
			
		}
		else {
			if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)) {
				if (day == 31) {
					day = 1 ;
					month++ ;
				}
				else {
					day++ ;
				}

			}
			else if (month == 2) {
				if (day == 28 ) {
					day = 1 ;
					month++ ;
				}
				else {
					day++ ;
				}
			}
			else if (month == 12) {
				if (day == 31) {
					day = 1 ;
					month = 1 ;
					year++ ;
				}
				else{
					day++ ;
				}
			}
			else{
				if (day == 30) {
					day = 1 ;
					month++ ;
				}
				else {
					day++ ;
				}
			}
			
		}
		
	
	}
}