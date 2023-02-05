package bookmarket.welcome;

/**
 * 고객 정보를 관리하는 클래스
 * @author "SeongHoon"
 *
 */
public class Person {
	private String name;
	private int phone;
	private String address;
	
	public Person(String name, int phone) {
		this.name = name;
		this.phone = phone;
	}

	public Person(String name, int phone, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		
	}
}
