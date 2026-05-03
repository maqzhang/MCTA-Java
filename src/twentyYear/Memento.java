package twentyYear;

import java.util.ArrayList;
import java.util.List;

/**
 *试题六（共 15 分）
 * 阅读下列说明和 C++代码，将应填入- - （n）- - 处的字句写在答题纸的对应栏内。
 * 【说明】
 * Facade（外观）模式是一种通过为多个复杂子系统提供一个一致的接口，而使这些子
 * 系统更加容易被访问的模式，以医院为例，就医时患者需要与医院不同的职能部门交互，完
 * 成挂号、门诊、取药等操作。为简化就医流程，设置了一个接待员的职位，代患者完成上述
 * 就医步骤，患者则只需与接待员交互即可。如图 6-1 给出了以外观模式实现该场景的类图。
 * 备忘录类 - 用于保存原发器的状态快照
 */
public class Memento {
	private String state;
	
	/**
	 * 构造函数 - 创建备忘录实例并保存状态
	 * @param state 要保存的状态值
	 */
	public Memento(String state) {
		this.state = state;
	}
	
	/**
	 * 获取保存的状态
	 * @return 返回备忘录中保存的状态字符串
	 */
	public String getState() {
		return state;
	}
}

/**
 * 原发器类 - 创建备忘录并恢复状态
 */
 class Originator {
	private String state;
	
	/**
	 * 设置原发器的当前状态
	 * @param state 新的状态值
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * 获取原发器的当前状态
	 * @return 返回当前状态
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * 保存当前状态到备忘录对象
	 * @return 返回包含当前状态的Memento对象
	 */
	public Memento saveStateToMemento() {
		return new Memento(state) ;
	}
	
	/**
	 * 从备忘录对象恢复状态
	 * @param Memento 包含要恢复状态的备忘录对象
	 */
	public void getStateFromMemento(Memento Memento) {
		state = Memento.getState() ;
	}
}

/**
 * 看护者类 - 管理备忘录集合，负责保存和获取历史状态
 */
 class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();
	
	/**
	 * 添加备忘录到集合中
	 * @param state 要添加的Memento对象
	 */
	public void add(Memento state){
		mementoList.add(state);
	}
	
	/**
	 * 从集合中获取指定索引的备忘录
	 * @param index 备忘录在集合中的索引位置
	 * @return 返回对应索引的Memento对象
	 */
	public Memento get(int index) {
		return mementoList.get(index);
	}
}

/**
 * 备忘录模式演示类 - 展示如何使用备忘录模式保存和恢复对象状态
 */
class MementoPaneDemos {
	
	/**
	 * 主方法 - 演示备忘录模式的使用流程
	 * @param args 命令行参数
	 */
	public static void main(String[] args) {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		originator.setState("State #1");
		originator.setState("State #2");
		// careTaker.add( (5) );
		careTaker.add( originator.saveStateToMemento() );
		originator.setState("State #3");
		// careTaker.add( (6) );
		careTaker.add( originator.saveStateToMemento() );
		originator.setState("State #4");
		System.out.println("Current State：" + originator.getState());
		originator.getStateFromMemento(careTaker.get(0));
		System.out.println("First saved State：" + originator.getState());
		originator.getStateFromMemento(careTaker.get(1));
		System.out.println("Second saved State：" + originator.getState());
	}
}
