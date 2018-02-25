package homework.hw2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class StudentFactoryTest {

	private final String name = "Student One";
	private final String usAddr = "US Address One";
	private final String foreignAddr = "Home Address One";
	private final int yrsInState = 5;
	private final int i20num = 50000;

	@Test
	public void testCreateInStateStudent() {
		Student student = StudentFactory.createInStateStudent(name, usAddr, yrsInState);
		assertNotNull(student);
		assertEquals(name, student.getName());
		assertEquals(usAddr, student.getUsAddr());
		assertEquals(yrsInState, student.getYrsInState());
		assertEquals(StudentStatus.INSTATE, student.getStatus());
		assertNull(student.getForeignAddr());
	}

	@Test
	public void testCreateOutStateStudent() {
		Student student = StudentFactory.createOutStateStudent(name, usAddr, yrsInState);
		assertNotNull(student);
		assertEquals(name, student.getName());
		assertEquals(usAddr, student.getUsAddr());
		assertEquals(yrsInState, student.getYrsInState());
		assertEquals(StudentStatus.OUTSTATE, student.getStatus());
		assertNull(student.getForeignAddr());
	}

	@Test
	public void testCreateIntlStudent() {
		Student student = StudentFactory.createIntlStudent(name,i20num, usAddr, yrsInState,foreignAddr);
		assertNotNull(student);
		assertEquals(name, student.getName());
		assertEquals(i20num, student.getI20num());
		assertEquals(usAddr, student.getUsAddr());
		assertEquals(yrsInState, student.getYrsInState());
		assertEquals(foreignAddr, student.getForeignAddr());		
		assertEquals(StudentStatus.INTL, student.getStatus());
		
	}
}
