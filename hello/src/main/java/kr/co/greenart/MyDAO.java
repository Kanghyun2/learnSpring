package kr.co.greenart;

import org.springframework.stereotype.Component;

@Component
public class MyDAO {

	public void insert(String data) {
		System.out.println(data + " 삽입");
	}
}
