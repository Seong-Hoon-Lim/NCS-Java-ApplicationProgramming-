package bookmarket.welcome;

/**
 * 장바구니의 상품 항목을 관리할 수 있는 클래스
 * @author "SeongHoon"
 *
 */
public class CartItem {
//	private String[] itemBook = new String[7];
	private Book itemBook;
	private String bookId;
	private int quantity;	//책 수량
	private int totalPrice;
	
	public CartItem() {
		
	}
	
//	public CartItem(String[] book) {
//		this.itemBook = book;
//		this.bookId = book[0];
//		this.quantity = 1;
//		updateTotalPrice();
//		
//	}
//
//	public String[] getItemBook() {
//		return itemBook;
//	}
	
	public CartItem(Book bookList) {
		this.itemBook = bookList;
		this.bookId = bookList.getBookId();
		this.quantity = 1;
	}
	
	public Book getItemBook() {
		return itemBook;
	}

	public void setItemBook(Book itemBook) {
		this.itemBook = itemBook;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
		this.updateTotalPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void updateTotalPrice() {
//		totalPrice = Integer.parseInt(this.itemBook[2]) * this.quantity;	//문자열을 숫자로 변경해서 연산
		totalPrice = this.itemBook.getUnitPrice() * this.quantity;
		
	}	
}
