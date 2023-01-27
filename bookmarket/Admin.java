package bookmarket.welcome;

/**
 * 관리자 정보 관리 클래스
 * @author "SeongHoon"
 *
 */
public class Admin extends Person{
	private String id = "Admin";
	private String password = "Admin1234";
	
	public Admin(String name, int phone) {
		super(name, phone);
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}	
}
