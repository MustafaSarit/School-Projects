package collections ;
import java.util.* ;

public class Student {
	
	public String fname ;
	public String lname ;
	public int    numbr ;
	public int    grade ;
	
	public Student(String fname, String lname, int numbr) {
		this.fname = fname ;
		this.lname = lname ;
		this.numbr = numbr ;
		
	}
	
	public String toString(){
		return "id=" + this.numbr + " name=" + this.fname + " surname=" + this.lname ;
	}
	
}