package homework.hw2;

public class Student {

	private float tuition;
	private String name;
	private int i20num;
	private String usAddr;
	private int yrsInState;
	private String foreignAddr;
	private StudentStatus status;

	protected Student(String name, int i20num, String usAddr, int yrsInState, String foreignAddr,
			StudentStatus status) {
		this.name = name;
		this.usAddr = usAddr;
		this.foreignAddr = foreignAddr;
		this.status = status;

		if (i20num != Integer.MIN_VALUE) {
			this.i20num = i20num;
		}

		if (yrsInState != Integer.MIN_VALUE) {
			this.yrsInState = yrsInState;
		}
	}

	public float getTuition() {
		return tuition;
	}

	public String getName() {
		return name;
	}

	public int getI20num() {
		return i20num;
	}

	public String getUsAddr() {
		return usAddr;
	}

	public int getYrsInState() {
		return yrsInState;
	}

	public String getForeignAddr() {
		return foreignAddr;
	}

	public StudentStatus getStatus() {
		return status;
	}

}
