package twentyYear;
/*
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
享元（FlyWeight）模式主要用于减少创建对象的数量，以降低内存占用，提高性能。
先要开发一个网络围棋程序，允许多个玩家联机下棋。由于只有一台服务器，为节省内存空
间，采用享元模式实现该程序，得到如图 6-1 所示的类图
 */
import java.util.*;
enum PieceColor { BLACK, WHITE } // 棋子颜色
class PiecePos { // 棋子位置
	private int x;
	private int y;
	public PiecePos(int a, int b) { x = a; y = b; }
	public int getX() { return x; }
	public int getY() { return y; }
}
abstract class Piece { // 棋子定义
	protected PieceColor m_color; // 颜色
	protected PiecePos m_pos; // 位置
	public Piece(PieceColor color, PiecePos pos) {
		m_color = color;
		m_pos = pos;
	}
 // (1) ;
 // (1) ;
public abstract void draw(); // 绘制棋子
}
class BlackPiece extends Piece {
	public BlackPiece(PieceColor color, PiecePos pos) {
		super(color, pos);
	}
	public void draw() { System.out.println("draw a blackpiece"); }
}
class WhitePiece extends Piece {
	public WhitePiece(PieceColor color, PiecePos pos) {
		super(color, pos);
	}
	public void draw() { System.out.println("white a blackpiece"); }
}
class PieceBoard { // 棋盘上已有的棋子
// private static final ArrayList<(2)> m_arrayPiece = new ArrayList
private static final ArrayList<Piece> m_arrayPiece = new ArrayList<Piece>(); // 棋盘上已有的棋子
	private String m_blackName; // 黑方名称
	private String m_whiteName; // 白方名称
	public PieceBoard(String black, String white) {
		m_blackName = black;
		m_whiteName = white;
	}
// 一步棋，在棋盘上放一颗棋子
public void SetPiece(PieceColor color, PiecePos pos) {
	// (3) piece = null;
	Piece piece = null;
	if (color == PieceColor.BLACK) { // 放黑子
		piece = new BlackPiece(color, pos); // 获取一颗黑子
		System.out.println(m_blackName + "在位置(" + pos.getX() + ","
				+ pos.getY() + ")");
		// (4) ;
		piece.draw();	//
	} else { // 放白子
		piece = new WhitePiece(color, pos); // 获取一颗白子
		System.out.println(m_whiteName + "在位置(" + pos.getX() + ","
				+ pos.getY() + ")");
		// (5) ;
		piece.draw();	//	绘制棋子
	}
	m_arrayPiece.add(piece);
}
}
class MDemo{
	public static void main(String[] args) {
		// 创建棋盘，黑方为"张三"，白方为"李四"
		PieceBoard board = new PieceBoard("张三", "李四");
		
		// 放置黑子在位置(3,4)
		board.SetPiece(PieceColor.BLACK, new PiecePos(3, 4));
		
		// 放置白子在位置(4,3)
		board.SetPiece(PieceColor.WHITE, new PiecePos(4, 3));
		
		// 放置黑子在位置(5,5)
		board.SetPiece(PieceColor.BLACK, new PiecePos(5, 5));
	}
}