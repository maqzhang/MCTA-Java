import java.util.*;
/*
2022年下午试题五
Facade（外观）模式是一种通过为多个复杂子系统提供一个一致的接口，而使这些子
系统更加容易被访问的模式，以医院为例，就医时患者需要与医院不同的职能部门交互，完
成挂号、门诊、取药等操作。为简化就医流程，设置了一个接待员的职位，代患者完成上述
就医步骤，患者则只需与接待员交互即可。如图 5-1 给出了以外观模式实现该场景的类图。
 */
// 病人接口，定义获取病人姓名的方法
interface Patient {
 // （1）获取病人姓名
	public String getName();
}

// 处理者接口，定义处理病人的方法
interface Disposer {
 // （2）处理病人
	public void dispose(Patient patient);
}

// 挂号类，实现Disposer接口，负责挂号操作
class Registry implements Disposer { // 挂号
	public void dispose(Patient patient) {
		System.out.println("I am registering..." + patient.getName());
	}
}

// 医生门诊类，实现Disposer接口，负责诊断操作
class Doctor implements Disposer { // 医生门诊
	public void dispose(Patient patient) {
		System.out.println("I am diagnosing..." + patient.getName());
	}
}

// 药房类，实现Disposer接口，负责发药操作
class Pharmacy implements Disposer { // 取药
	public void dispose(Patient patient) {
		System.out.println("I am giving medicine... " + patient.getName());
	}
}

// 外观类，封装挂号、诊断、取药的流程
class Facade {
	private Patient patient;
	// 构造方法，传入病人对象
	public Facade(Patient patient) {
		this.patient = patient;
	}
	// 统一处理流程：挂号、诊断、取药
	void dispose() {
		Registry registry = new Registry();
		Doctor doctor = new Doctor();
		Pharmacy pharmacy = new Pharmacy();
		registry.dispose(patient);
		doctor.dispose(patient);
		pharmacy.dispose(patient);
	}
}

// 具体病人类，实现Patient接口
class ConcretePatient implements Patient {
	private String name;
	// 构造方法，传入病人姓名
	public ConcretePatient(String name) {
		this.name = name;
	}
	// 获取病人姓名
	public String getName() {
		return name;
	}
}

/*
	// 主方法，演示外观模式的使用
	public static void main(String[] args) {
	// 	Patient patient = （3）创建具体病人对象 ;
 // （4） Facade f = （5）创建外观对象 ;
 // （6） f.dispose()调用统一处理流程 ;
		Patient patient = new ConcretePatient("John Doe");
		Facade f = new Facade(patient);
		f.dispose();
	}
 */