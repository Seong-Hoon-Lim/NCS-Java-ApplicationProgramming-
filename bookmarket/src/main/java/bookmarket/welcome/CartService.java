package bookmarket.welcome;

/**
 * 장바구니 처리를 위한 메서드 정의
 * 
 * @author "SeongHoon"
 *
 */
public interface CartService {
	
	/**
	 * 전체 도서 정보 목록을 출력하는 메소드
	 * @param p
	 */
	void printBookList(Book[] p);

	/**
	 * 장바구니에 담긴 도서의 ID와 장바구니에 담을 도서의 ID를 비교하는 메소드
	ID가 일치하면 장바구니에 담긴 도서의 개수를 1만큼 증가시키고 true 를 반환
	그렇지 않으면 false 를 반환
	 * @param id
	 * @return
	 */
	boolean isCartInBook(String id);

	/**
	 * 장바구니 항목 관리 클래스 CartItem 에 도서정보를 등록하는 메소드
	 * @param p
	 */
	void insertBook(Book p);
	
	/**
	 * 장바구니 순번 numId의 항목을 삭제하는 메소드
	 * @param numId
	 */
	void removeCart(int numId);
	
	/**
	 * 장바구니의 모든 항목을 삭제하는 메소드
	 */
	void deleteBook();
	
}
