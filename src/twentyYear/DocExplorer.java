package twentyYear;
/*
2019年下半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某文件管理系统中定义了类 OfficeDoc 和 DocExplorer。当类 OfficeDoc 发生变化时，
类 DocExplorer 的所有对象都要更新其自身的状态。现采用观察者（Observer）设计模式来
实现该需求，所设计的类图如图 6-1 所示。
 */
import java.util.*;
interface Observer {
	// public (1) ;
	public void update();	//
}
interface Subject {
	public void Attach(Observer obs);
	public void Detach(Observer obs);
	public void Notify();
	public void setStatus(int status);
	public int getStatus();
}
class OfficeDoc implements Subject {
// private List< (2) > myObs;
private List< Observer > myObs;
	private String mySubjectName;
	private int m_status;
	public OfficeDoc(String name) {
		mySubjectName = name;
		this.myObs = new ArrayList<Observer>();
		m_status = 0;
	}
	public void Attach(Observer obs) { this.myObs.add(obs); }
	public void Detach(Observer obs) { this.myObs.remove(obs); }
	public void Notify() {
		// for (Observer obs : this.myObs) { (3) ; }
		for (Observer obs : this.myObs) { obs.update(); }
	}
	public void setStatus(int status) {
		m_status = status;
		System.out.println("SetStatus subject[" + mySubjectName +
				"]status:" + status);
	}
	public int getStatus() { return m_status; }
}
class DocExplorer implements Observer {
	private String myObsName;
	public DocExplorer(String name, Subject sub) { // 空格4
		myObsName = name;
		// sub. (5) ;
		sub.Attach(this); //
	}
	public void update() {
		System.out.println("update observer[" + myObsName + "]");
	}
}
class ObserverTest {
	public static void main(String[] args) {
		Subject subjectA = new OfficeDoc("subject A");
		Observer observerA = new DocExplorer("observer A", subjectA);
		subjectA.setStatus(1);
		subjectA.Notify();
	}
}