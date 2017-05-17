package logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class CprControlTest {

	@Test
	public void controlTest() {
		CprControl control = new CprControl("0703942881");
		assertTrue(control.getResult());
	}
	@Test
	public void testTooLong(){
		CprControl control = new CprControl("12345678910");
		assertFalse(control.getResult());
	}
	@Test
	public void testSymbols(){
		CprControl control = new CprControl("07039428!!");
		assertFalse(control.getResult());
	}
	@Test
	public void testLetters(){
		CprControl control = new CprControl("07039a288");
		assertFalse(control.getResult());
	}@Test
	public void testTooShort(){
		CprControl control = new CprControl("070394288");
		assertFalse(control.getResult());
	}
	@Test
	public void testWrongDay(){
		CprControl control = new CprControl("3203942881");
		assertFalse(control.getResult());
	}
	@Test
	public void testWrongMonth(){
		CprControl control = new CprControl("3013942881");
		assertFalse(control.getResult());
	}
	
}
