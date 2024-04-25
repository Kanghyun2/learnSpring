class Pencil implements Writeable {
	@Override
	public void write(String word) {
		System.out.println("연필로 작성: " + word);
	}
}

public class Pen implements Writeable {
	private String model;
	private int price;
	
	public Pen() {}
	public Pen(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	
	public void write(String word) {
		System.out.println("펜으로 작성: " + word);
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
