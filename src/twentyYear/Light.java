package twentyYear;

/*
2014年下半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某灯具厂商欲生产一个灯具遥控器，该遥控器具有 7 个可编程的插槽，每个插槽都有开
关按钮，对应着一个不同的灯。利用该遥控器能够统一控制房间中该厂商所有品牌灯具的开
关，现采用 Command（命令）模式实现该遥控器的软件部分。Command 模式的类图如图
6-1 所示
 */
class Light {
	public Light() {}
	public Light(String name) { /* 代码省略 */ }
	public void on() { /* 代码省略 */ } // 开灯
	public void off() { /* 代码省略 */ } // 关灯
// 其余代码省略
}
 // (1) {
interface Command {
public void execute();
}
class LightOnCommand implements Command { // 开灯命令
	Light light;
	public LightOnCommand(Light light) { this.light = light; }
	public void execute() {
		// (2) ;
		light.on();
	}
}
class LightOffCommand implements Command { // 关灯命令
	Light light;
	public LightOffCommand(Light light) { this.light = light; }
	public void execute() {
		// (3) ;
		light.off();
	}
}
class RemoteControl { // 遥控器
	Command[] onCommands = new Command[7];
	Command[] offCommands = new Command[7];
	public RemoteControl() { /* 代码省略 */ }
	public void setCommand(int slot, Command onCommand, Command offCommand)
	{
		// (4) = onCommand;
		onCommands[slot] = onCommand;
		// (5) = offCommand;
		offCommands[slot] = offCommand;
	}
	public void onButtonWasPushed(int slot) {
		// (6) ;
		onCommands[slot].execute();
	}
	public void offButtonWasPushed(int slot) {
		// (7) ;
		offCommands[slot].execute();
	}
}
class RemoteLoader {
	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("kitchen");
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
	}
}