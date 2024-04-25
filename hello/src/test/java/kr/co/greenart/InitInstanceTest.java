package kr.co.greenart;

import static org.junit.Assert.*;

import org.junit.Test;

public class InitInstanceTest {

	@Test
	public void test() {
		MyBean b = new MyBean();
		
		assertNotNull(b);
	}

	@Test
	public void test2() {
		MyBean b1 = new MyBean();
		MyBean b2 = new MyBean();
		
		assertNotNull(b1);
		assertNotNull(b2);
		assertNotSame(b1, b2);
	}
	
	@Test
	public void test3() {
		MyBean b1 = new MyBean();
		MyBean b2 = b1;
		
		assertSame(b1, b2);
	}
}


