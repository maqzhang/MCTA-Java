package twentyYear;

/*
2015年上半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某图书管理系统中管理着两种类型的文献：图书和论文。现在要求统计所有馆藏文献的
总页码（假设图书馆中有一本 540 页的图书和两篇各 25 页的论文，那么馆藏文献的总页码
就是 590 页）。采用 Visitor（访问者）模式实现该要求，得到如图 6-1 所示的类图。
 */
import java.util.*;
interface LibraryVisitor {
 // (1) ;
	void visit(Book p_book) ;
 // (2) ;
 void visit(Article p_article) ;
	void printSum();
}
class LibrarySumPrintVisitor implements LibraryVisitor { // 打印总页数
	private int sum = 0;
	public void visit(Book p_book) {
		sum = sum + p_book.getNumberOfPages();
	}
	public void visit(Article p_article) {
		sum = sum + p_article.getNumberOfPages();
	}
	public void printSum() {
		System.out.println("SUM = " + sum);
	}
}
interface LibraryItemInterface {
 // (3) ;
	void accept(LibraryVisitor visitor);
}
class Article implements LibraryItemInterface {
	private String m_title; // 论文名
	private String m_author; // 论文作者
	private int m_start_page;
	private int m_end_page;
	public Article(String p_author, String p_title, int p_start_page, int p_end_page) {
		m_title = p_title;
		m_author = p_author;
		m_start_page = p_start_page;
		m_end_page = p_end_page;
	}
	public int getNumberOfPages() {
		return m_end_page - m_start_page;
	}
	public void accept(LibraryVisitor visitor) {
		// (4) ;
		visitor.visit(this);
	}
}
class Book implements LibraryItemInterface {
	private String m_title; // 书名
	private String m_author; // 书作者
	private int m_pages; // 页教
	public Book(String p_author, String p_title,int p_pages) {
		m_title = p_title;
		m_author = p_author;
		m_pages = p_pages;
	}
	public int getNumberOfPages() {
		return m_pages;
	}
	public void accept(LibraryVisitor visitor) {
		// (5) ;
		visitor.visit(this);
	}
}

class LibraryVisitorDemo {
	public static void main(String[] args) {
		// 创建文献集合
		List<LibraryItemInterface> library = new ArrayList<>();
		
		// 添加图书和论文
		library.add(new Book("Author1", "Java Programming", 540));
		library.add(new Article("Author2", "Article1", 1, 26));
		library.add(new Article("Author3", "Article2", 1, 26));
		
		// 创建访问者
		LibrarySumPrintVisitor visitor = new LibrarySumPrintVisitor();
		
		// 遍历集合，接受访问者访问
		for (LibraryItemInterface item : library) {
			item.accept(visitor);
		}
		
		// 打印统计结果
		visitor.printSum();
	}
}
