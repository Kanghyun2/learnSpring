
public class Main {
	public static void main(String[] args) {
		// DI (Dependency Injection)
		Pen monami = new Pen("모나미", 4000);
		Person person = new Person("길동", 33, monami);
		
		Person dooli = new Person();
		dooli.setPen(new Pencil());
	}
}
