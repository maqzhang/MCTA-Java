public class Main {
	public static PrintStrategy getStrategy(TYPE type) {
		PrintStrategy st = null;
		switch (type) {
			case COMMA:
				st = new PrintIntervalsComma();
				break;
			case DOTS:
				st = new PrintIntervalsDots();
				break;
			case LINE:
				st = new PrintIntervalsLine();
				break;
		}
		return st;
	}

	public static void main(String[] args) {
		/*Interval a = new Interval(1.7, 2.1);
		a.printIntervals(getStrategy(TYPE.COMMA));
		a.printIntervals(getStrategy(TYPE.DOTS));
		a.printIntervals(getStrategy(TYPE.LINE));
*/
		Patient patient = new ConcretePatient("John Doe");
		Facade f = new Facade(patient);
		f.dispose();
	}
}
