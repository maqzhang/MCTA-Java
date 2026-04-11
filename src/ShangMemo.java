// 2022年上半年 软件设计师 下午试卷
/*
在软件系统中，通常都会给用户提供取消、不确定或者错误的操作，允许将系统回复到
原先的状态。现使用备忘录（Memento）模式实现该要求，得到如图 6-1 所示的类图。
Memento 包含了要被恢复的状态。Originator 创建并在 Memento 中存储状态。
CareTaker 负责从 Memento 中恢复状态。
 */
// 发起人类，负责创建备忘录和恢复状态
import java.util.*;
class Memento {
	private String state;
	public Memento(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
}
class Originator {
	private String state;
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public Memento saveStateToMemento() {
		// return (1) ;
		return new Memento(state);
	}
	public void getStateFromMemento(Memento Memento) {
		// state = (2) ;
		state = Memento.getState();
	}
}
class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();
	// public (3) {
	public void add(Memento state){
		mementoList.add(state);
	}
	// public (4) {
	public Memento get(int index) {
		return mementoList.get(index);
	}
}
class MementoPaneDemos {
	public static void main(String[] args) {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		originator.setState("State #1");
		originator.setState("State #2");
		// careTaker.add( (5) );
		careTaker.add( originator.saveStateToMemento());
		originator.setState("State #3");
		// careTaker.add( (6) );
		careTaker.add( originator.saveStateToMemento());
		originator.setState("State #4");
		System.out.println("Current State：" + originator.getState());
		originator.getStateFromMemento(careTaker.get(0));
		System.out.println("First saved State：" + originator.getState());
		originator.getStateFromMemento(careTaker.get(1));
		System.out.println("Second saved State：" + originator.getState());
	}
}