package student;

public class student {
	private int rollNo;
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	private int grade;
	private String school;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo=rollNo;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "student [rollNo=" + rollNo + ", name=" + name + ", grade=" + grade + ", school=" + school + "]";
	}
	
	
}
