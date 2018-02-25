package homework.hw2;

public class StudentFactory {

	private StudentFactory() {
	}

	public static Student createInStateStudent(String name, String usAddr, int yrsInState) {

		return new Student(name, Integer.MIN_VALUE, usAddr, yrsInState, null, StudentStatus.INSTATE);
	}

	public static Student createOutStateStudent(String name, String usAddr, int yrsInState) {
		return new Student(name, Integer.MIN_VALUE, usAddr, yrsInState, null, StudentStatus.OUTSTATE);
	}

	public static Student createIntlStudent(String name, int i20num, String usAddr, int yrsInState,
			String foreignAddr) {
		return new Student(name, i20num, usAddr, yrsInState, foreignAddr, StudentStatus.INTL);
	}

}
