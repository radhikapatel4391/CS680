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
		assertThat(student.getName(),is(name));
		assertThat(student.getUsAddr(),is(usAddr));
		assertThat(student.getYrsInState(),is(yrsInState));
		assertThat(student.getStatus(), is(StudentStatus.INSTATE));
		assertNull(student.getForeignAddr());
	}

	@Test
	public void testCreateOutStateStudent() {
		Student student = StudentFactory.createOutStateStudent(name, usAddr, yrsInState);
		assertNotNull(student);
		assertThat(student.getName(),is(name));
		assertThat(student.getUsAddr(),is(usAddr));
		assertThat(student.getYrsInState(),is(yrsInState));
		assertThat(student.getStatus(),is(StudentStatus.OUTSTATE));
		assertNull(student.getForeignAddr());
	}

	@Test
	public void testCreateIntlStudent() {
		Student student = StudentFactory.createIntlStudent(name,i20num, usAddr, yrsInState,foreignAddr);
		assertNotNull(student);
		assertThat(student.getName(),is(name));
		assertThat(student.getI20num(),is(i20num));
		assertThat(student.getUsAddr(),is(usAddr));
		assertThat(student.getYrsInState(),is(yrsInState));
		assertThat(student.getForeignAddr(),is(foreignAddr));		
		assertThat(student.getStatus(),is(StudentStatus.INTL));
		
	}
}
