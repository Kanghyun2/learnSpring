package kr.co.greenart;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/bean-config.xml")
public class SpringBeanTest {
	// 기본은 Type 주입, 필요시 이름 주입 설정
	@Autowired
	@Qualifier("firstBean")
	private MyBean mybean;
	
	@Autowired
	@Qualifier("firstBean")
	private MyBean anotherRef;
	
	@Autowired
	@Qualifier("secondBean")
	private MyBean secondBean;
	
	@Autowired
	@Qualifier("thirdBean")
	public MyBean thirdBean;
	
	@Test
	public void test() {
		assertNotNull(mybean);
	}

	@Test
	public void test2() {
		assertNotNull(anotherRef);
		assertSame(mybean, anotherRef);
	}
	
	@Test
	public void test3() {
		assertEquals(0, mybean.getIntValue());
		assertNull(mybean.getStrValue());
	}
	
	@Test
	public void test4() {
		assertNotSame(mybean, secondBean);
	}
	
	@Test
	public void test5() {
		assertEquals("문자열", secondBean.getStrValue());
		assertEquals(44, secondBean.getIntValue());
	}
	
	@Test
	public void test6() {
		assertEquals("TestValue", thirdBean.getStrValue());
		assertEquals(77, thirdBean.getIntValue());
	}
}






