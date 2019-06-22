package collections;

import java.util.Map;

public class Test {

	public static void main(String[] args) {
		//Create Course
		Course ceng1004 = new Course("CENG 1004", "Introduction to OOP"); 
		
		//Create students and register them to the course 
		Student student = new Student("Ali", "Dere", 1001);
		ceng1004.addStudent(student);
		
		student = new Student("Aysu", "Aral", 1002);
		ceng1004.addStudent(student);
		
		student = new Student("Ali", "Bora", 1004);
		ceng1004.addStudent(student);
		
		student = new Student("Demir", "Bora", 1003);
		ceng1004.addStudent(student);
		
		student = new Student("Ceren", "Aslan", 1005);
		ceng1004.addStudent(student);
		

		//TEST 1 : Print course
		System.out.println(ceng1004);
		//Output:
		//Course = CENG 1004 Introduction to OOP
				
		//TEST 2 : Print students in ascending order by Id number
		System.out.println();
		for (Student stu : ceng1004.listStudentsOrderById()){
			System.out.println(stu);
		}
		//Output:
		//id=1001, name=Ali, surname=Dere
		//id=1002, name=Aysu, surname=Aral
		//id=1003, name=Demir, surname=Bora
		//id=1004, name=Ali, surname=Bora
		//id=1005, name=Ceren, surname=Aslan		

		//TEST 3 : Print students in ascending order by name
		System.out.println();
		for (Student stu : ceng1004.listStudentsOrderByName()){
			System.out.println(stu);
		}
		//Output:
		//id=1001, name=Ali, surname=Dere
		//id=1004, name=Ali, surname=Bora
		//id=1002, name=Aysu, surname=Aral
		//id=1005, name=Ceren, surname=Aslan
		//id=1003, name=Demir, surname=Bora		
		
		//TEST 4 : Print students in ascending order by surname
		System.out.println();
		for (Student stu : ceng1004.listStudentsOrderBySurname()){
			System.out.println(stu);
		}
		//Output:
		//id=1002, name=Aysu, surname=Aral
		//id=1005, name=Ceren, surname=Aslan
		//id=1003, name=Demir, surname=Bora
		//id=1004, name=Ali, surname=Bora
		//id=1001, name=Ali, surname=Dere
						
		//assign grades to students
		student = ceng1004.getStudent(1001);
		ceng1004.setGrade(student, 75);
		
		student = ceng1004.getStudent(1002);
		ceng1004.setGrade(student, 80);

		student = ceng1004.getStudent(1003);
		ceng1004.setGrade(student, 85);
		
		student = ceng1004.getStudent(1004);
		ceng1004.setGrade(student, 80);

		student = ceng1004.getStudent(1005);
		ceng1004.setGrade(student, 85);
		
		//TEST 5 : Print students and grades in ascending order by id number
		System.out.println();
		Map<Student,Integer> map = ceng1004.listStudentGradesOrderbyId();		
		for (Student stu : map.keySet()){
			System.out.println(stu + " has grade " + map.get(stu));
		}
		//Output:
		//id=1001, name=Ali, surname=Dere has grade 75
		//id=1002, name=Aysu, surname=Aral has grade 80
		//id=1003, name=Demir, surname=Bora has grade 85
		//id=1004, name=Ali, surname=Bora has grade 80
		//id=1005, name=Ceren, surname=Aslan has grade 85		
		
		//TEST 6 : Print students and grades in ascending order by name
		System.out.println();
		map = ceng1004.listStudentGradesOrderbyName();		
		for (Student stu : map.keySet()){
			System.out.println(stu + " has grade " + map.get(stu));
		}
		//Output:
		//id=1001, name=Ali, surname=Dere has grade 75
		//id=1004, name=Ali, surname=Bora has grade 80
		//id=1002, name=Aysu, surname=Aral has grade 80
		//id=1005, name=Ceren, surname=Aslan has grade 85
		//id=1003, name=Demir, surname=Bora has grade 85		
		
		//TEST 7 : Print students and grades in descending order by grade
		System.out.println();
		map = ceng1004.listStudentGradesOrderbyGrade();		
		for (Student stu : map.keySet()){
			System.out.println(stu + " has grade " + map.get(stu));
		}	
		//Output:
		//id=1003, name=Demir, surname=Bora has grade 85
		//id=1005, name=Ceren, surname=Aslan has grade 85
		//id=1002, name=Aysu, surname=Aral has grade 80
		//id=1004, name=Ali, surname=Bora has grade 80
		//id=1001, name=Ali, surname=Dere has grade 75
	}

}