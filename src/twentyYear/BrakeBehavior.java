package twentyYear;
/*
2019年上半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某软件公司欲开发一款汽车竞速类游戏，需要模拟长轮胎和短轮胎急刹车时在路面上留
下的不同痕迹，并考虑后续能模拟更多种轮胎急刹车时的痕迹。现采用策略（Strategy）设
计模式来实现该需求，所设计的类图如图 6-1 所示
 */
import java.util.*;
interface BrakeBehavior {
	// public (1) ;
	public void stop();
	/* 其余代码省略 */
}
class LongWheelBrake implements BrakeBehavior {
	public void stop() { System.out.println("模拟长轮胎刹车痕迹！"); }
	/* 其余代码省略 */
}
class ShortWheelBrake implements BrakeBehavior {
	public void stop() { System.out.println("模拟短轮胎刹车痕迹！"); }
	/* 其余代码省略 */
}
abstract class Car {
	// protected (2) wheel;
	protected BrakeBehavior wheel;
	// public void brake() { (3) ; }
	public void brake() { wheel.stop(); }
	/* 其余代码省略 */
}
class ShortWheelCar extends Car {
	public ShortWheelCar(BrakeBehavior behavior) {
		// (4) ;
		wheel = behavior;
	}
	/* 其余代码省略 */
}
class StrategyTest {
	public static void main(String[] args) {
		BrakeBehavior brake = new ShortWheelBrake();
		ShortWheelCar car1 = new ShortWheelCar(brake);
		// car1. (5) ;
		car1.brake(); //	模拟短轮胎刹车痕迹！
	}
}