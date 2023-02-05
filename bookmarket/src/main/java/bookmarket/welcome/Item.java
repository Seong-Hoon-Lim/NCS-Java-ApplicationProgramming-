package bookmarket.welcome;

/**
 * 장바구니의 항목을 관리하기 위한 추상 클래스를 생성
 * 기존의 장바구니 항목 관리 클래스를 상속하도록 함
 * 
 * 주요 도서정보를 관리하는 추상클래스
 * 
 * @author "SeongHoon"
 *
 */
public abstract class Item {
	protected String bookId;
	protected String name;
	protected int unitPrice;
	
	public Item(String bookId, String name, int unitPrice) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	abstract String getBookId();
	
	abstract String getName();
	
	abstract int getUnitPrice();
	
	abstract void setBookId(String bookId);
	
	abstract void setName(String name);
	
	abstract void setUnitPrice(int unitPrice);
	
}
