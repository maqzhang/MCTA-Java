/*
2023年下半年
在某系统中，类 Interval 代表由下界（lower bound）和上界（upper bound）定义的区间。
要求采用不同的格式显示区间范围。如：
[lower bound,upper bound];[lower bound...upper bound];[lower bound upper bound]等。
现采用策略（Strategy）模式实现该要求，得到如图 5 1 所示的类图。
 */

/**
 * TYPE 枚举，定义区间输出的不同格式类型。
 */
enum TYPE {
	COMMA, // 逗号分隔格式，如 [1.0,2.0]
	DOTS,  // 省略号分隔格式，如 [1.0...2.0]
	LINE   // 空格分隔格式，如 [1.0 2.0]
}

/**
 * PrintStrategy 接口，策略模式的核心，定义区间输出行为。
 */
interface PrintStrategy {
	//(1)
	/**
	 * 以特定格式输出 Interval。
	 * @param val 需要输出的区间对象
	 */
	public void doPrint(Interval val);
}

/**
 * Interval 类，表示一个有上下界的区间。
 */
class Interval {
	// 区间下界
	private double lower;
	// 区间上界
	private double upper;

	/**
	 * 构造方法，初始化区间上下界。
	 * @param lower 下界
	 * @param upper 上界
	 */
	public Interval(double lower, double upper) {
		this.lower = lower;
		this.upper = upper;
	}

	/**
	 * 获取区间下界。
	 * @return 下界
	 */
	public double getLower() {
		return lower;
	}

	/**
	 * 获取区间上界。
	 * @return 上界
	 */
	public double getUpper() {
		return upper;
	}

	/**
	 * 使用指定的策略输出区间。
	 * @param ptr 输出策略
	 */
	public void printIntervals(PrintStrategy ptr) {
		//(2)
		ptr.doPrint(this);
	}
}

/**
 * PrintIntervalsComma 策略类，使用逗号分隔格式输出区间。
 */
class PrintIntervalsComma implements PrintStrategy {
	/**
	 * 以 [lower,upper] 格式输出区间。
	 */
	public void doPrint(Interval val) {
		System.out.println("[" + val.getLower() + "," + val.getUpper() + "]");
	}
}

/**
 * PrintIntervalsDots 策略类，使用省略号分隔格式输出区间。
 */
class PrintIntervalsDots implements PrintStrategy {
	/**
	 * 以 [lower...upper] 格式输出区间。
	 */
	public void doPrint(Interval val) {
		System.out.println("[" + val.getLower() + "..." + val.getUpper() + "]");
	}
}

/**
 * PrintIntervalsLine 策略类，使用空格分隔格式输出区间。
 */
class PrintIntervalsLine implements PrintStrategy {
	/**
	 * 以 [lower upper] 格式输出区间。
	 */
	public void doPrint(Interval val) {
		System.out.println("[" + val.getLower() + " " + val.getUpper() + "]");
	}
}
