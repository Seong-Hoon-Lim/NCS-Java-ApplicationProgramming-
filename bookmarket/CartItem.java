package bookmarket.welcome;

/**
 * 장바구니의 상품 항목을 관리할 수 있는 클래스
 * @author "SeongHoon"
 *
 */
public class CartItem {
	private String[] itemBook = new String[7];
	private String bookId;
	private int quantity;
	private int totalPrice;
	
	public CartItem() {
		
	}
	
	public CartItem(String[] book) {
		this.itemBook = itemBook;
		this.bookId = bookId;
		this.quantity = quantity;
		updateTotalPrice();
		
	}

	public String[] getItemBook() {
		return itemBook;
	}

	public void setItemBook(String[] itemBook) {
		this.itemBook = itemBook;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void updateTotalPrice() {
		totalPrice = Integer.parseInt(this.itemBook[2]) * this.quantity;
	}
	
	
}
