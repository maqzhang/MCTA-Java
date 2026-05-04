package twentyYear;

/*
2013年下半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
欲开发一个绘图软件，要求使用不同的绘图程序绘制不同的图形。以绘制直线和圆形为
例，对应的绘图程序如表 6-1
所示
 */
// (1)
interface Drawing {
	// (2) ;
	public void drawLine(double x1, double y1, double x2 ,double y2);
	// (3) ;
	public void drawCircle (double x, double y, double r);
}
class DP1 {
	static public void drawLine(double x1, double y1, double x2, double
			y2) { /* 代码省略 */ }
	static public void draw_a_circle(double x, double y, double r)
	{ /* 代码省略 */ }
}
class DP2 {
	static public void drawLine(double x1, double y1, double x2 ,double y2) { /* 代码省略 */ }
	static public void drawcircle (double x, double y, double r)
	{ /* 代码省略 */ }
}
class V1Drawing implements Drawing {
	public void drawLine(double x1, double y1, double x2 ,double y2)
	{ /* 代码省略 */ }
	public void drawCircle(double x, double y, double r) {
		// (4) ;
		DP1.draw_a_circle(x,y,r);
	}
}
class V2Drawing implements Drawing {
	public void drawLine(double x1, double y1, double x2 ,double y2)
	{ /* 代码省略 */ }
	public void drawCircle (double x, double y, double r) {
		// (5) ;
		DP2.drawcircle(x,y,r);
	}
}
abstract class Shape {
	private Drawing _dp;
 // (6) ;
	public abstract void draw();
	Shape(Drawing dp) { _dp = dp; }
	public void drawLine(double x1, double y1, double x2 ,double y2)
	{ _dp.drawLine(x1, y1, x2, y2); }
	public void drawCircle (double x, double y, double r)
	{ _dp.drawCircle(x, y, r); }
}
class Rectangle extends Shape {
	private double _x1, _x2, _y1, _y2;
	public Rectangle(Drawing dp, double x1, double y1, double x2, double y2) { /* 代码省略 */
	super(dp);
	}
	public void draw() { /* 代码省略 */ }
}
class Circle extends Shape {
	private double _x, _y, _r;
	public Circle(Drawing dp, double x, double y, double r)
	{ /* 代码省略 */
	super(dp);
	}
	public void draw() { drawCircle(_x, _y, _r); }
}

class DrawingDemo {
	public static void main(String[] args) {
		// 使用 DP1 绘图程序
		Drawing dp1 = new V1Drawing();
		Shape circle1 = new Circle(dp1, 100, 100, 50);
		circle1.draw();
		
		Shape rect1 = new Rectangle(dp1, 10, 10, 100, 100);
		rect1.drawLine(10, 10, 100, 100);
		
		// 使用 DP2 绘图程序
		Drawing dp2 = new V2Drawing();
		Shape circle2 = new Circle(dp2, 200, 200, 75);
		circle2.draw();
		
		Shape rect2 = new Rectangle(dp2, 50, 50, 150, 150);
		rect2.drawLine(50, 50, 150, 150);
	}
}
