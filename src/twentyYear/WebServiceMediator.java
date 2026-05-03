package twentyYear;
/*
2020年下半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
在线支付是电子商务的一个重要环节，不同的电子商务平台提供了不同的支付接口。现
在需要整合不同电子商务平台的支付接口，使得客户在不同平台上购物时，不需要关心具体
的支付接口。拟采用中介者（Mediator）设计模式来实现该需求，所设计的类图如图 6-1 所
示。
 */
import java.util.*;
interface WebServiceMediator {
	// public (1) ;
	public void buy(double money, WebService service) ;//	购买服务
	public void SetAmazon(WebService amazon);
	public void SetEbay(WebService ebay);
}
abstract class WebService {
	// protected (2) mediator;
	protected WebServiceMediator mediator;
	public abstract void SetMediator(WebServiceMediator mediator);
	// public (3) ;
	public abstract void buyService(double money) ;//	购买服务
	public abstract void search(double money);
}
class ConcreteServiceMediator implements WebServiceMediator {
	private WebService amazon;
	private WebService ebay;
	public ConcreteServiceMediator() {
		amazon = null;
		ebay = null;
	}
	public void SetAmazon(WebService amazon) {
		this.amazon = amazon;
	}
	public void SetEbay(WebService ebay) {
		this.ebay = ebay;
	}
	public void buy(double money, WebService service) {
		if (service == amazon)
			amazon.search(money);
		else
			ebay.search(money);
	}
}
class Amazon extends WebService {
	public void SetMediator(WebServiceMediator mediator) {
		this.mediator = mediator;
	}
	public void buyService(double money) {
		// (4) ;
		mediator.buy(money,this);//	通过中介者购买服务
	}
	public void search(double money) {
		System.out.println("Amazon receive：" + money);
	}
}
class Ebay extends WebService {
	public void SetMediator(WebServiceMediator mediator) {
		this.mediator = mediator;
	}
	public void buyService(double money) {
		// (5) ;
		mediator.buy(money,this);//	通过中介者购买服务
	}
	public void search(double money) {
		System.out.println("Ebay receive：" + money);
	}
}

class WebServiceTest {
	public static void main(String[] args) {
		// 创建中介者
		ConcreteServiceMediator mediator = new ConcreteServiceMediator();
		
		// 创建具体服务
		WebService amazon = new Amazon();
		WebService ebay = new Ebay();
		
		// 将服务注册到中介者
		mediator.SetAmazon(amazon);
		mediator.SetEbay(ebay);
		
		// 为服务设置中介者
		amazon.SetMediator(mediator);
		ebay.SetMediator(mediator);
		
		// 通过中介者购买服务
		System.out.println("=== Amazon购买服务 ===");
		amazon.buyService(100.0);
		
		System.out.println("\n=== Ebay购买服务 ===");
		ebay.buyService(200.0);
	}
}
