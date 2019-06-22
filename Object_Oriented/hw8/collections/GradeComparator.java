package collections ;
import java.util.Comparator ;


public class GradeComparator implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		return s2.grade - s1.grade ;
	}
	

}