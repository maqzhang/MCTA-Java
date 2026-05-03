package twentyYear;
/*
2017年上半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某快餐厅主要制作并出售儿童套餐，一般包括主餐（各类比萨）、饮料和玩具，其餐品
种类可能不同，但其制作过程相同。前台服务员（Waiter）调度厨师制作套餐。现采用生成
器（Builder）模式实现制作过程，得到如图 6-1 所示的类图。
 */
class Pizza {
	private String parts;
	public void setParts(String parts) { this.parts = parts; }
	public String toString() { return this.parts; }
}
abstract class PizzaBuilder {
	protected Pizza pizza;
	public Pizza getPizza() { return pizza; }
	public void createNewPizza() { pizza = new Pizza(); }
	// public (1) ;
	public abstract void buildParts();
}
class HawaiianPizzaBuilder extends PizzaBuilder {
	public void buildParts(){
		pizza.setParts("cross + mild + ham&pineapp1e");
	}
}
class SpicyPizzaBuilder extends PizzaBuilder {
	public void buildParts() {
		pizza.setParts("panbaked + hot + pepperoni&salami");
	}
}
class Waiter {
	private PizzaBuilder pizzaBuilder;
	public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {/*设置构建器*/
		// (2) ;
		this.pizzaBuilder = pizzaBuilder ;
	}
	public Pizza getPizza() { return pizzaBuilder.getPizza(); }
	public void construct() { /* 构建 */
		pizzaBuilder.createNewPizza();
		// (3) ;
		pizzaBuilder.buildParts();
	}
}
class FastFoodOrdering {
	public static void main(String[]args) {
		Waiter waiter = new Waiter();
		PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();
		// (4) ;
		waiter.setPizzaBuilder(hawaiian_pizzabuilder);
		// (5) ;
		waiter.construct();
		System.out.println("pizza：" + waiter.getPizza());
	}
}