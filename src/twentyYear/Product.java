package twentyYear;
/*
2018年上半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
生成器（Builder）模式的意图是将一个复杂对象的构建与它的表示分离，使得同样的构
建过程可以创建不同的表示。图 6-1 所示为其类图。
 */
import java.util.*;
class Product {
	private String partA;
	private String partB;
	public Product() {}
	public void setPartA(String s) { partA = s; }
	public void setPartB(String s) { partB = s; }
}
interface Builder {
	// public (1) ;
	public void buildPartA();
	public void buildPartB();
	// public (2) ;
	public Product getResult();
}
class ConcreteBuilder1 implements Builder {
	private Product product;
	public ConcreteBuilder1() { product = new Product(); }
	// public void buildPartA() { (3) ("Component A"); }
	public void buildPartA() {  product.setPartA("Component A"); }
	// public void buildPartB() { (4) ("Component B"); }
	public void buildPartB() { product.setPartB("Component B"); }
	public Product getResult() { return product;}
}
class ConcreteBuilder2 implements Builder {
	@Override
	public void buildPartA() {

	}

	@Override
	public void buildPartB() {

	}

	@Override
	public Product getResult() {
		return null;
	}
// 代码省略
}
class Director {
	private Builder builder;
	public Director(Builder builder) { this.builder = builder; }
	public void construct() {
		// (5) ;
// 代码省略
	}
}
class Test {
	public static void main(String[] args) {
		Director director1 = new Director(new ConcreteBuilder1());
		director1.construct();
	}
}
