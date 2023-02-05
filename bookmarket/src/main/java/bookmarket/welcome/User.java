package bookmarket.welcome;

/**
 * 사용자 클래스 Person 상속을 받아
 * main 메소드에서 객체를 생성하여
 * 입력 받은 고객의 정보를 저장에 활용
 * 
 * @author "SeongHoon"
 *
 */
public class User extends Person {

	public User(String name, int phone, String address) {
		super(name, phone, address);

	}

	public User(String name, int phone) {
		super(name, phone);

	}
}
