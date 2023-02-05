package bookmarket.welcome;

/**
 * Item 추상 클래스를 상속받아
 * 도서 정보를 관리하는 클래스
 * 
 * @author "SeongHoon"
 *
 */
public class Book extends Item {
	
	private String author;
	private String descroption;
	private String category;
	private String releaseDate;

	public Book(String bookId, String name, int unitPrice) {
		super(bookId, name, unitPrice);
	}
	
	

	public Book(String bookId, String name, int unitPrice, String author, String descroption, String category,
			String releaseDate) {
		super(bookId, name, unitPrice);
		this.author = author;
		this.descroption = descroption;
		this.category = category;
		this.releaseDate = releaseDate;
	}


	@Override
	String getBookId() { return null; }

	@Override
	String getName() { return null; }

	@Override
	int getUnitPrice() { return 0; }

	@Override
	void setBookId(String bookId) {  }

	@Override
	void setName(String name) {	 }

	@Override
	void setUnitPrice(int unitPrice) {  }

	public String getAuthor() { return author; }

	public void setAuthor(String author) { this.author = author; }
	
	public String getDescroption() { return descroption; }

	public void setDescroption(String descroption) { this.descroption = descroption; }

	public String getCategory() { return category; }

	public void setCategory(String category) { this.category = category; }

	public String getReleaseDate() { return releaseDate; }

	public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }	
	
}
