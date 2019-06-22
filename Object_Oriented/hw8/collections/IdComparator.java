package collections ;
import java.util.Comparator ;

public class IdComparator implements Comparator<Student> {
	
	public int compare(Student first, Student second) {
		return first.numbr - second.numbr ;
	}
}