package student;

public class clientprogram {
	public static void main(String args[]) {
		student stu = new student();
		stu.setRollNo(10);
		stu.setName("shreya");
		stu.setGrade(10);
		stu.setSchool("abc school");
		System.out.println(stu.getRollNo());
        System.out.println(stu.getName());
        System.out.println(stu.getGrade());
        System.out.println(stu.getSchool());
        System.out.println(stu);
	}
	
	
	
}
