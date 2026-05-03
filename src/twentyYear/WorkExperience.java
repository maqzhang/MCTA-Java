package twentyYear;

/*
2013年上半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
现要求实现一个能够自动生成求职简历的程序，简历的基本内容包括求职者的姓名、性
别、年龄及工作经历。希望每份简历中的工作经历有所不同，并尽量减少程序中的重复代码。
现采用原型模式（Prototype）来实现上述要求，得到如图 6-1 所示的类图。
 */
// class WorkExperience (1) Cloneable { // 工作经历
class WorkExperience implements Cloneable { // 工作经历
	private String workDate;
	private String company;
	public Object Clone() {
		// (2) ;
		WorkExperience obj = new WorkExperience();
		obj.workDate= this.workDate;
		obj.company = this.company;
		return obj;
	}
// 其余代码省略
}
// (3)
class Resume implements Cloneable { // 简历
	private String name;
	private String sex;
	private String age;
	private WorkExperience work;
	public Resume(String name) {
		this.name = name;
		work = new WorkExperience();
	}
	private Resume(WorkExperience work) {
		// this.work = (4) ;
		this.work = (WorkExperience) work.Clone();
	}
	public void SetPersonInfo(String sex, String age) { /* 代码略 */ }
	public void SetWorkExperience(String workDate, String company) {
		/* 代码略 */
	}
	public Object Clone() {
		// Resume obj = (5) ;
		Resume obj = new Resume(this.work);
// 其余代码省略
		return obj;
	}
}
class WorkResume {
	public static void main(String[] args) {
		Resume a = new Resume("张三");
		a.SetPersonInfo("男", "29");
		a.SetWorkExperience("1998〜2000", "XXX 公司");
		// Resume b = (6) ;
		Resume b = (Resume) a.Clone();
		b.SetWorkExperience("2001〜2006", "YYY 公司");
	}
}