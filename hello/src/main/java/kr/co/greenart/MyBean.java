package kr.co.greenart;

public class MyBean {
	private String strValue;
	private int intValue;
	
	public MyBean() {}
	public MyBean(String strValue, int intValue) {
		super();
		this.strValue = strValue;
		this.intValue = intValue;
	}
	public String getStrValue() {
		return strValue;
	}
	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}
	public int getIntValue() {
		return intValue;
	}
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	@Override
	public String toString() {
		return "MyBean [strValue=" + strValue + ", intValue=" + intValue + "]";
	}
}
