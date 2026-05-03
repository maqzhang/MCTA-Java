package twentyYear;

/*
2015年下半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某大型购物中心欲开发一套收银软件，要求其能够支持购物中心在不同时期推出的各种
促销活动，如打折、返利（例如，满 300 返 100）等等。现采用策略（Strategy）模式实现
该要求，得到如图 6-1 所示的类图。
 */
import java.util.*;
enum TYPE { NORMAL, CASH_DISCOUNT, CASH_RETURN};
interface CashSuper {
	// public (1) ;
	public double acceptCash(double cash);
}
class CashNormal implements CashSuper { // 正常收费子类
	public double acceptCash(double money) {
		return money;
	}
}
class CashDiscount implements CashSuper {
	private double moneyDiscount; // 折扣率
	public CashDiscount(double moneyDiscount) {
		this.moneyDiscount = moneyDiscount;
	}
	public double acceptCash(double money) {
		return money* moneyDiscount;
	}
}
class CashReturn implements CashSuper { // 满额返利
	private double moneyCondition;
	private double moneyReturn;
	public CashReturn(double moneyCondition, double moneyReturn) {
		this.moneyCondition = moneyCondition; // 满额数额
		this.moneyReturn = moneyReturn; // 返利数额
	}
	public double acceptCash(double money) {
		double result = money;
		if(money >= moneyCondition )
			result = money - Math.floor(money / moneyCondition) * moneyReturn;
		return result;
	}
}
class CashContext {
	private CashSuper cs;
	private TYPE t;
	public CashContext(TYPE t) {
		switch(t) {
			case NORMAL: // 正常收费
				// (2) ;
				cs = new CashNormal();
				break;
			case CASH_DISCOUNT: // 打 8 折
				// (3) ;
				cs = new CashDiscount(0.5);
				break;
			case CASH_RETURN: // 满 300 返 100
				// (4) ;
				cs =	 new CashReturn(300, 100);
				break;
		}
	}
	public double GetResult(double money) {
		// (5) ;
		return cs.acceptCash(money);
	}
	
	public static void main(String[] args) {
		double originalMoney = 500;
		
		// 测试正常收费
		CashContext ctx1 = new CashContext(TYPE.NORMAL);
		System.out.println("原价: " + originalMoney + "元，正常收费: " + ctx1.GetResult(originalMoney) + "元");
		
		// 测试打折
		CashContext ctx2 = new CashContext(TYPE.CASH_DISCOUNT);
		System.out.println("原价: " + originalMoney + "元，打折后: " + ctx2.GetResult(originalMoney) + "元");
		
		// 测试满额返利
		CashContext ctx3 = new CashContext(TYPE.CASH_RETURN);
		System.out.println("原价: " + originalMoney + "元，满300返100后: " + ctx3.GetResult(originalMoney) + "元");
	}
}