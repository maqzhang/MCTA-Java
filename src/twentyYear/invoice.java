package twentyYear;
/*
2016年下半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某发票（lnvoice）由抬头（Head）部分、正文部分和脚注（Foot）部分构成。现采用
装饰（Decorator）模式实现打印发票的功能，得到如图 6-1 所示的类图。
 */
class Invoice {
	public void printInvoice() {
		System.out.println("This is the content of the invoice!");
	}
}
class Decorator extends Invoice {
	protected Invoice ticket;
	public Decorator(Invoice t) {
		ticket = t;
	}
	public void printInvoice() {
		if (ticket != null)
			// (1) ;
			ticket.printInvoice();

	}
}
class HeadDecorator extends Decorator {
	public HeadDecorator(Invoice t) {
		super(t);
	}
	public void printInvoice () {
		System.out.println("This is the header of the invoice!");
		// (2) ;
		super.printInvoice();
	}
}
class FootDecorator extends Decorator {
	public FootDecorator(Invoice t) {
		super(t);
	}
	public void printInvoice() {
		// (3) ;
		super.printInvoice();
		System.out.println("This is the footnote of the invoice!");
	}
}
class TestDemo {
	public static void main(String[] args) {
		Invoice t = new Invoice();
		Invoice ticket;
		// ticket = (4) ;
		ticket = new FootDecorator(new HeadDecorator(t));
		ticket.printInvoice();
		System.out.println("--------------------");
		// ticket = (5) ;
		ticket = new FootDecorator(new Decorator(ticket));
		ticket.printInvoice();
	}
}
