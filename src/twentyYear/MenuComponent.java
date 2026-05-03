package twentyYear;
/*
2021年上半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
层叠菜单是窗口风格的软件系统中经常采用的一种系统功能组织方式。层叠菜单（如图 6-1
示例）中包含的可能是一个菜单项（直接对应某个功能），也可能是一个子菜单，现在采用
组合（composite）设计模式实现层叠菜单，得到如图 6-2 所示的类图
 */
import java.util.*;
abstract class MenuComponent { // 构成层叠菜单的元素
 // (1) String name; // 菜单项或子菜单名称
 	protected String name; // 菜单项或子菜单名称
	public void printName() { System.out.println(name); }
	// public (2) ;
	public abstract boolean addMenuElement(MenuComponent element);//	添加子菜单或菜单项
	public abstract boolean removeMenuElement(MenuComponent element);
	// public (3) ;
	public abstract List<MenuComponent> getElement(); //	 获取子菜单或菜单项列表
}
class MenuItem extends MenuComponent {
	public MenuItem(String name) { this.name=name; }
	public boolean addMenuElement(MenuComponent element){return false;}
	public boolean removeMenuElement(MenuComponent element) {
		return false;
	}
	public List<MenuComponent> getElement(){ return null; }
}
class Menu extends MenuComponent {
	// private (4) ;
	private List<MenuComponent> elementList; // 子菜单或菜单项列表
	public Menu(String name) {
		this.name = name;
		this.elementList = new ArrayList<MenuComponent>();
	}
	public boolean addMenuElement(MenuComponent element) {
		return elementList.add(element);
	}
	public boolean removeMenuElement(MenuComponent element) {
		return elementList.remove(element);
	}
	public List<MenuComponent> getElement() { return elementList; }
}
class CompositeTest {
	public static void main(String[] args) {
		MenuComponent mainMenu = new Menu("Insert");
		MenuComponent subMenu = new Menu("Chart");
		MenuComponent element = new MenuItem("On This Sheet");
		// (5) ;
		mainMenu.addMenuElement(subMenu);	//	将子菜单添加到主菜单
		subMenu.addMenuElement(element);
		printMenus(mainMenu);
	}
	public static void printMenus(MenuComponent ifile) {
		ifile.printName();
		List<MenuComponent> children = ifile.getElement();
		if (children == null) return;
		for(MenuComponent element : children) {
			printMenus(element);
		}
	}
}

class MenuDemo {
	public static void main(String[] args) {
		// 创建主菜单
		MenuComponent mainMenu = new Menu("File");
		
		// 创建子菜单
		MenuComponent editMenu = new Menu("Edit");
		MenuComponent viewMenu = new Menu("View");
		
		// 创建菜单项
		MenuComponent newItem = new MenuItem("New");
		MenuComponent openItem = new MenuItem("Open");
		MenuComponent saveItem = new MenuItem("Save");
		MenuComponent copyItem = new MenuItem("Copy");
		MenuComponent pasteItem = new MenuItem("Paste");
		
		// 构建菜单树
		mainMenu.addMenuElement(newItem);
		mainMenu.addMenuElement(openItem);
		mainMenu.addMenuElement(saveItem);
		mainMenu.addMenuElement(editMenu);
		mainMenu.addMenuElement(viewMenu);
		
		editMenu.addMenuElement(copyItem);
		editMenu.addMenuElement(pasteItem);
		
		// 打印菜单结构
		System.out.println("=== 菜单结构 ===");
		CompositeTest.printMenus(mainMenu);
	}
}
