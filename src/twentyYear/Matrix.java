package twentyYear;

/*
2017年下半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某图像预览程序要求能够查看 BMP、JPEG 和 GIF 三种格式的文件，且能够在 Windows
和 Linux 两种操作系统上运行。程序需具有较好的扩展性以支持新的文件格式和操作系统。
为满足上述需求并减少所需生成的子类数目，现采用桥接（Bridge）模式进行设计，得到如
图 6-1 所示的类图。
 */
import java.util.*;
class Matrix { // 各种格式的文件最终都被转化为像素矩阵
// 此处代码省略
}
abstract class Implementor {
	// public (1) ; // 显示像素矩阵 m
	public  abstract void  doPaint(Matrix m);
}
class WinImp extends Implementor {
	public void doPaint(Matrix m) { // 调用 Windows 系统的绘制函数绘制像素矩阵
// 此处代码省略
	}
}
class LinuxImp extends Implementor {
	public void doPaint(Matrix m) { // 调用 Linux 系统的绘制函数绘制像素矩阵
// 此处代码省略
	}
}
abstract class Image {
	public void setImp(Implementor imp) { this.imp = imp; }
	public abstract void parseFile(String fileName);
	protected Implementor imp;
}
class BMPImage extends Image {
	@Override
	public void parseFile(String fileName) {

	}
// 此处代码省略
}
class GIFImage extends Image {
	public void parseFile(String fileName) {
		// 此处解析 BMP ���件并获得一个像素矩阵对象 m
		Matrix m = new Matrix();
		// (2) ; // 显示像素矩阵 m
		imp.doPaint(m);
	}
}
class JPEGImage extends Image {
	@Override
	public void parseFile(String fileName) {

	}
// 此处代码省略
}
class Main {
	public static void main(String[]args) {
// 在 Linux 操作系统上查看 demo.gif 图像文件
// 		Image image = (3) ;
// 		Implementor imageImp = (4) ;
// 		(5) ;
		Image image = new GIFImage();
		Implementor imageImp = new LinuxImp();
		image.setImp(imageImp);
		image.parseFile("demo.gif");
	}
}