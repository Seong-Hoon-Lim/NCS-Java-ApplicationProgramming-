package bookmarket.welcome;

/**
 * 장바구니 처리 클래스
 * CartService 구현
 * 
 * @author "SeongHoon"
 *
 */
public class Cart implements CartService {
	
	static final int NUM_BOOK = 3;	//도서의 개수에 대한 상수
	CartItem[] mCartItem = new CartItem[NUM_BOOK];
	static int mCartCount = 0;
	
	public Cart() {
		
	}

	@Override
	public void printBookList(Book[] bookList) {
		for (int i = 0; i < bookList.length; i++) {
			System.out.println(bookList[i].getBookId() + " | ");
			System.out.println(bookList[i].getName() + " | ");
			System.out.println(bookList[i].getUnitPrice() + " | ");
			System.out.println(bookList[i].getAuthor() + " | ");
			System.out.println(bookList[i].getDescroption() + " | ");
			System.out.println(bookList[i].getCategory() + " | ");
			System.out.println(bookList[i].getReleaseDate() + " | ");
			System.out.println("");
		}
		
	}		

	@Override
	public boolean isCartInBook(String bookId) {
		boolean flag = false;
		
		for (int i = 0; i < mCartCount; i++) {
			if (bookId == mCartItem[i].getBookId()) {
				mCartItem[i].setQuantity(mCartItem[i].getQuantity()+1);
				flag = true;
			}
		}
		
		return flag;
	}

	@Override
	public void insertBook(Book book) {
		mCartItem[mCartCount++] = new CartItem(book);
		
	}

	@Override
	public void removeCart(int numId) {
		CartItem[] cartItem = new CartItem[NUM_BOOK];
		int num = 0;
		
		for (int i = 0; i < mCartCount; i++) {
			if (numId != i) {
				cartItem[num++] = mCartItem[i];
			}
			
		mCartCount = num;
		mCartItem = cartItem;
		}		
	}

	@Override
	public void deleteBook() {
		mCartItem = new CartItem[NUM_BOOK];
		mCartCount = 0;
		
	}
	
	public void printCart() {
		System.out.println("2. 장바구니 상품 목록 보기: ");
		System.out.println("********************************************");
		System.out.println("   도서ID \t|   수량\t|    합계");
		for (int i = 0; i < mCartCount; i++) {
			System.out.print("   " + mCartItem[i].getBookId() + " \t| ");
			System.out.print("   " + mCartItem[i].getQuantity() + " \t| ");
			System.out.print("   " + mCartItem[i].getTotalPrice() + " \t| ");
			System.out.println(" ");
		}
		System.out.println("********************************************");
	}

}
