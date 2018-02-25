package homework.hw1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void multiply3By4(){
		
		Calculator cut = new Calculator();
		float actual = cut.multiply(3,4);
		float expected = 12;
		assertThat(actual, is(expected));
	}
	@Test
	public void Multiple2_5By5_5() {
		Calculator cut = new Calculator();
		float actual = cut.multiply(2.5f,5.5f);
		float expected = 13.75f;
		assertThat(actual, is(expected));
	}
	@Test
	public void divide3By2() {
		Calculator cut = new Calculator();
		float actual = cut.divide(3, 2);
		float expected = 1.5f;
		assertThat(actual, is(expected));
	}
	@Test
	public void divide3_5By2_1() {
		Calculator cut = new Calculator();
		float actual = cut.divide(3.5f, 2.1f);
		float expected = 1.6666667f;
		assertThat(actual, is(expected));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divide5By0() {
		Calculator cut = new Calculator();
		cut.divide(5, 0);
	}
	
}