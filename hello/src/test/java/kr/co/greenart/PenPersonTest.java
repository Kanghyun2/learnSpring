package kr.co.greenart;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/pen-person.xml")
public class PenPersonTest {
	@Autowired
	private Pen monamiPen;
	
	@Autowired
	private Person kildong;
	
	@Test
	public void test() {
		// 인스턴스 참조 구성 테스트
		assertNotNull(monamiPen);
		// 필드값 기대값과 같은지
		assertEquals("모나미펜", monamiPen.getModel());
		assertEquals(3000, monamiPen.getPrice());
	}

	@Test
	public void test2() {
		assertEquals("길동", kildong.getName());
		assertEquals(33, kildong.getAge());
		assertSame(monamiPen, kildong.getPen());
	}
}





