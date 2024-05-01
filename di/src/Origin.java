class Proxy {
	private Origin origin;

	public Proxy(String name) {
		origin = new Origin(name);
	}

	public void printProxy() {
		System.out.println("내이름은");
		origin.print();
		System.out.println("입니다");
	}
}

public class Origin {
	private String name;

	public Origin(String name) {
		super();
		this.name = name;
	}

	public void print() {
		System.out.println(name);
	}
}
