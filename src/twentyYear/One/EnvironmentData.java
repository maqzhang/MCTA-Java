package twentyYear.One;
/*
2014年上半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某实验室欲建立一个实验室环境监测系统，能够显示实验室的温度、湿度以及洁净度等
环境数据。当获取到最新的环境测量数据时，显示的环境数据能够更新。
现在采用观察者（Observer）模式来开发该系统。观察者模式的类图如图 6-1 所示。
 */
import java.util.*;
interface Observer {
	public void update(float temp, float humidity, float cleanness);
}
interface Subject {
	public void registerObserver(Observer o); // 注册对主题感兴趣的观察者
	public void removeObserver(Observer o); // 删除观察者
	public void notifyObservers(); // 当主题发生变化时通知观察者
}
class EnvironmentData implements Subject //(1)
		{
private ArrayList observers;
		private float temperature, humidity, cleanness;
public EnvironmentData() { observers = new ArrayList(); }
public void registerObserver(Observer o) { observers.add(o); }
public void removeObserver(Observer o) { /* 代码省略 */ }
public void notifyObservers() {
	for (int i = 0; i < observers.size(); i ++ ) {
		Observer observer = (Observer) observers.get(i);
		// (2) ;
		observer.update(temperature, humidity, cleanness);
	}
}
public void measurementsChanged() {
	// (3) ;
	notifyObservers();
}
public void setMeasurements(float temperature, float humidity, float
		cleanness) {
	this.temperature = temperature;
	this.humidity = humidity;
	this.cleanness = cleanness;
	// (4) ;
	measurementsChanged();
}
}
class CurrentConditionsDisplay implements Observer //(5)
		{
private float temperature;
private float humidity;
private float cleanness;
private Subject envData;
public CurrentConditionsDisplay(Subject envData) {
	this.envData = envData;
	// (6) ;
	envData.registerObserver(this);
}
public void update(float temperature, float humidity, float cleanness)
{
	this.temperature = temperature;
	this.humidity = humidity;
	this.cleanness = cleanness;
	display();
}
public void display() { /* 代码省略 */ }
}
class EnvironmentMonitor {
	public static void main(String[] args) {
		EnvironmentData envData = new EnvironmentData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(envData);
		envData.setMeasurements(80, 65, 30.4f);
	}
}