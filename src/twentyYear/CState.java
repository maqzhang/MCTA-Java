package twentyYear;
/*
2018年下半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某航空公司的会员积分系统将其会员划分为：普卡(Basic)、银卡(Silver)和金卡(Gold)
三个等级。非会员(NonMember)可以申请成为普卡会员。会员的等级根据其一年内累积的
里程数进行调整。描述会员等级调整的状态图如图 6-1 所示。现采用状态(State)模式实现
上述场景，得到如图 6-2 所示的类图。
 */
import java.util.*;
abstract class CState {
	public int flyMiles; // 里程数
	// public (1) ; // 根据累积里程数调整会员等级
	public abstract   double travel(int miles, CFrequentFlyer context); // 根据累积里程数调整会员等级
}
class CNoCustomer extends CState { // 非会员
	public double travel(int miles, CFrequentFlyer context) {
		System.out.println("Your travel will not account for points");
		return miles; // 不累积里程数
	}
}
class CBasic extends CState { // 普卡会员
	public double travel(int miles, CFrequentFlyer context) {
		if (context.flyMiles >= 25000 && context.flyMiles < 50000)
			// (2) ;
			context.setState(new CSilver()); //
		if (context.flyMiles >= 50000)
			// (3) ;
			context.setState(new CGold()); //
		return miles;
	}
}
class CGold extends CState { // 金卡会员
	public double travel(int miles, CFrequentFlyer context) {
		if (context.flyMiles >= 25000 && context.flyMiles < 50000)
			// (4) ;
			context.setState(new CSilver()); //
		if (context.flyMiles < 25000);
		// (5) ;
		context.setState(new CGold()); //
		return miles + 0.5 * miles; // 累积里程数
	}
}
class CSilver extends CState { // 银卡会员
	public double travel(int miles, CFrequentFlyer context) {
		if (context.flyMiles <= 25000)
			context.setState(new CBasic());
		if (context.flyMiles >= 50000)
			context.setState(new CGold());
		return (miles + 0.25 * miles); // 累积里程数
	}
}
class CFrequentFlyer {
	CState state;
	double flyMiles;
	public CFrequentFlyer() {
		state = new CNoCustomer();
		flyMiles = 0;
		setState(state);
	}
	public void setState(CState state) { this.state = state; }
	public void travel(int miles) {
		double bonusMiles = state.travel(miles, this);
		flyMiles = flyMiles + bonusMiles;
	}
}

 class CStateDemo {
	public static void main(String[] args) {
		CFrequentFlyer flyer = new CFrequentFlyer();
		
		System.out.println("=== 航空公司会员积分系统演示 ===");
		System.out.println("初始状态：非会员，里程数：" + flyer.flyMiles);
		
		// 升级为普卡
		flyer.setState(new CBasic());
		flyer.flyMiles = 10000;
		System.out.println("\n升级为普卡会员，里程数：" + flyer.flyMiles);
		
		// 旅行并积分
		System.out.println("旅行1000公里...");
		flyer.travel(1000);
		System.out.println("当前里程数：" + flyer.flyMiles);
		
		// 升级为银卡
		flyer.flyMiles = 30000;
		flyer.setState(new CSilver());
		System.out.println("\n升级为银卡会员，里程数：" + flyer.flyMiles);
		System.out.println("旅行2000公里...");
		flyer.travel(2000);
		System.out.println("当前里程数：" + flyer.flyMiles);
		
		// 升级为金卡
		flyer.flyMiles = 55000;
		flyer.setState(new CGold());
		System.out.println("\n升级为金卡会员，里程数：" + flyer.flyMiles);
		System.out.println("旅行3000公里...");
		flyer.travel(3000);
		System.out.println("当前里程数：" + flyer.flyMiles);
	}
}
