package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {
	@Autowired
	private MyDAO dao;

	public MyService(MyDAO dao) {
		super();
		this.dao = dao;
	}
	
	public void setDao(MyDAO dao) {
		this.dao = dao;
	}

	public void insert(String data) {
		System.out.println("서비스 메소드 호출됨");
		
		dao.insert(data);
	}
}
