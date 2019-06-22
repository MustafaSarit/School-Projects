public class MyDateTime {
	int day ;
	int month ; 
	int year ;
	int hour ;
	int minute  ;
	
	public MyDateTime (MyDate date, MyTime time) {
		day = date.day ;
		month = date.month ;
		year = date.year ;
		hour = time.hour ;
		minute = time.minute ;
	}
	
	
	public void incrementMinute(int i) {
		if (i < 0) {
			decrementMinute(-i) ;
		}
		else {
			minute += i ;
			if (minute / 60 > 0) {
				incrementHour(minute / 60) ;
				minute = minute % 60 ;
			}
		}
	}
	
	public void incrementMinute() {
		incrementMinute(1) ;
	}
	
	public void incrementHour(int i) {
		if (i < 0) {
			decrementHour(-i) ;
		}
		else {
			hour += i ;
			if (hour / 24 > 0) {
				incrementDay(hour / 24) ;
				hour = hour % 24 ;
			}
		}
	}
	
	public void incrementHour() {
		incrementHour(1) ;
	}
	
	public void decrementMinute(int i) {
		if (i < 0) {
			incrementMinute(-i) ;
		}
		else {
			minute -= i ;
			if (minute < 0) {
				minute = minute * -1 ;
				decrementHour(minute / 60 + 1) ;
				minute = minute % 60 ; 
			}
		}
	}
	
	public void decrementMinute() {
		decrementMinute(1) ;
	}
	
	public void decrementHour(int i) {
		if (i < 0) {
			incrementHour(-i) ;
		}
		else {
			hour -= i ;
			if (hour < 0) {
				hour = hour * -1 ;
				decrementDay(hour / 24 + 1) ;
				hour = 24 - (hour % 24)  ; 
			}
		}
	}
	
	public void decrementHour() {
		decrementHour(1) ;
	}
	
	
	
	int[] maxDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	

	public void incrementDay() {
		int newDay = day+1;
		if (newDay > maxDays[month]){
			day =1;
			incrementMonth();
		}else if(month == 1 && newDay ==29 && !inLeapYear()){
			day =1;
			incrementMonth();	
		}else{
			day = newDay;
		}
		
	}


	public void decrementDay() {
		int newDay = day - 1;
		if (newDay == 0){
			day = 31;
			decrementMonth(); 
		}else{
			day = newDay;
		}
		
	}
	
	public void incrementDay(int i) {
		while (i > 0){
			incrementDay();
			i--;
		}
		
	}
	
	public void decrementDay(int i) {
		while (i > 0){
			decrementDay();
			i--;
		}
		
	}


	public void incrementMonth(int i) {
		int newMonth = (month + i) % 12;
		int yearChange = 0;
		
		if (newMonth < 0) {
			newMonth += 12;
			yearChange = -1;
		}
		
		yearChange += (month + i) / 12;
		month = newMonth;
		year += yearChange;
		if (day > maxDays[month]){
			day = maxDays[month];
			if(month ==1 && day ==29 && !inLeapYear()){
				day =28;
			}
		}
	}
	
	
	public void incrementMonth() {
		incrementMonth(1);
		
	}

	public void decrementMonth(int i) {
		incrementMonth(-i);
		
	}
	
	public void decrementMonth() {
		incrementMonth(-1);
		
	}
	
	public void incrementYear(int i) {
		year+=i;
		if (month ==1 && day ==29 && !inLeapYear()){
			day = 28;
		}
		
	}

	public void incrementYear() {
		incrementYear(1);
		
	}

	public void decrementYear() {
		incrementYear(-1);		
	}


	public void decrementYear(int i) {
		incrementYear(-i);
		
	}

	public boolean isBefore (MyDateTime anotherDateTime){
		long a = Long.valueOf(toString().replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "")) ;
		long b = Long.valueOf(anotherDateTime.toString().replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "")) ;
		return a < b ;
	}
	
	public boolean isAfter(MyDateTime anotherDateTime) {
		long a = Long.valueOf(toString().replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "")) ;
		long b = Long.valueOf(anotherDateTime.toString().replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "")) ;
		return a > b ;
	}
	
	public String dayTimeDifference(MyDateTime anotherDateTime) {
		int mindiff = 0 ;
		int houdiff = 0 ;
		int daydiff = 0 ;
		
		if (isBefore(anotherDateTime)) {
			MyDateTime consta = new MyDateTime(new MyDate(day, month+1, year), new MyTime(hour, minute)) ;
			while (consta.isBefore(anotherDateTime)){
				consta.incrementMinute() ;
				mindiff++ ;
			}
		}
		else if (isAfter(anotherDateTime)) {
			MyDateTime consta = new MyDateTime(new MyDate(day, month + 1, year), new MyTime(hour, minute)) ;
			while(consta.isAfter(anotherDateTime)) {
				consta.decrementMinute() ;
				mindiff++ ;
			}
		}
		
		if (mindiff > 59) {
			houdiff = mindiff / 60 ;
			mindiff = mindiff % 60 ;
			if (houdiff > 23) {
				daydiff = houdiff / 24 ;
				houdiff = houdiff % 24 ;
			}
		}
		
		if ((daydiff == 0) && (houdiff == 0) && (mindiff != 0)) {
			return (mindiff + " minute(s)") ;
		}
		else if ((daydiff == 0) && (houdiff != 0) && (mindiff != 0)) {
			return (houdiff + " hour(s) " + mindiff + " minute(s)") ;
		}
		else if ((daydiff == 0) && (mindiff == 0) && (houdiff != 0)) {
			return (houdiff + " hour(s)") ;
		}
		else if ((daydiff != 0) && (houdiff == 0) && (mindiff == 0)) {
			return (daydiff + " day(s)") ;
		}
		else if ((daydiff != 0) && (houdiff == 0) && (mindiff != 0)) {
			return (daydiff + " day(s) " + mindiff + " minute(s)") ;
		}
		else if ((daydiff != 0) && (houdiff != 0) && (mindiff == 0)) {
			return (daydiff + " day(s) " + houdiff + " hour(s)") ;
		}
		else if ((daydiff != 0) && (houdiff != 0) && (mindiff != 0)) {
			return (daydiff + " day(s) " + houdiff + " hour(s) " + mindiff + " minute(s)") ;
		}
		return "None" ;
	}

	public String toString() {
		String s_day = String.format("%02d", day) ;
		String s_minute = String.format("%02d", minute) ;
		String s_hour = String.format("%02d", hour) ;
		String s_month = String.format("%02d", month + 1) ;
		String s_year = Integer.toString(year) ;
		return (s_year + "-" + s_month + "-" + s_day + " " + s_hour + ":" + s_minute) ;
		
	}
	
	public boolean inLeapYear(){
		return year % 4 == 0 ? true : false;
	}
}