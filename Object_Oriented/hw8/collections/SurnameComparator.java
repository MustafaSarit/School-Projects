package collections ;
import java.util.Comparator ;

public class SurnameComparator implements Comparator<Student> {
	
	public int compare(Student first, Student second) {
		return first.lname.compareTo(second.lname)  ;
	}
}