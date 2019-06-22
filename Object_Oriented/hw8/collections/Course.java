package collections;
import java.util.* ;

public class Course {
	
	private String cours ;
	private String infor ;
	private List<Student> list = new ArrayList<>();
	
	public Course(String cours, String infor) {
		this.cours = cours ;
		this.infor = infor ;
	}
	
	public void addStudent(Student persn) {
		list.add(persn) ;
	}
	
	public String toString() {
		return "Course = " + cours + " " + infor ;
	}
	
	public List<Student> listStudentsOrderById() {
		Collections.sort(list, new IdComparator());
		return list ;
	}
	
	public Map<Student, Integer> listStudentGradesOrderbyId() {
		Map<Student, Integer> map = new TreeMap<>(new IdComparator()) ;
		for (Student persn : list) {
			map.put(persn, persn.grade);
		}
		return map ;
	}
	
	public List<Student> listStudentsOrderByName() {
		Collections.sort(list, new NameComparator());
		return list ;
	}
	
	public Map<Student, Integer> listStudentGradesOrderbyName() {
		Map<Student, Integer> map = new LinkedHashMap<>() ;
		Collections.sort(list, new NameComparator());
		for (Student persn : list) {
			map.put(persn, persn.grade);
		}
		return map ;
	}
	
	public Map<Student, Integer> listStudentGradesOrderbyGrade() {
		Map<Student, Integer> map = new LinkedHashMap<Student, Integer>() ;
		Collections.sort(list, new GradeComparator());
		for (Student persn : list) {
			map.put(persn, persn.grade);
		}
		return map ;
	}
	
	public List<Student> listStudentsOrderBySurname() {
		Collections.sort(list, new SurnameComparator());
		return list ;
	}
	
	public Student getStudent(int numbr){
		for (Student persn : list) {
			if (persn.numbr == numbr)
				return persn ;
		}
		return null ;
	}
	public void setGrade(Student persn, int grade){
		persn.grade = grade ;
	}
}