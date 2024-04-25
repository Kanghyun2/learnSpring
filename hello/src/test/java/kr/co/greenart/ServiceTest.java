package kr.co.greenart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class)
public class ServiceTest {
	@Autowired
	private MyService service;
	
	@Test
	public void methodCall() {
		service.insert("하이루");
	}
}
