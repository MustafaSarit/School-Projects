package collections ;
import java.util.Comparator ;

public class NameComparator implements Comparator<Student> {
	
	public int compare(Student first, Student second) {
		return first.fname.compareTo(second.fname)  ;
	}
}