package exercise.ex3;

public class Student {
	private String Name;
	private StudentStatus status;
	public Student(StudentStatus status,String Name) {
		this.Name = Name;
		this.status = status;
	}
	public float getTuition() {
		return status.getTuition();
	}
	public String getName() {
		return Name;
	}
	public void setStatus(StudentStatus s) {
		this.status = s;
	}
}
