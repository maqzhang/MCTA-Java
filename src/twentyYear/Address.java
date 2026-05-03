package twentyYear;

/*
2016年上半年 软件设计师 下午试卷
试题六（共 15 分）
阅读下列说明和 Java 代码，将应填入 （n） 处的字句写在答题纸的对应栏内。
【说明】
某软件系统中，已设计并实现了用于显示地址信息的类 Address（如图 6-1 所示），现
要求提供基于 Dutch 语言的地址信息显示接口。为了实现该要求并考虑到以后可能还会出
现新的语言的接口，决定采用适配器（Adapter）模式实现该要求，得到如图 6-1 所示的类
图。
 */
import java.util.*;
class Address {
	public void street() { // 实现代码省略
		}
		public void zip() { // 实现代码省略
			 }
			public void city() { // 实现代码省略
			 }
// 其他成员省略
}
class DutchAddress {
	public void straat() { // 实现代码省略
	}

	public void postcode() {
		// 实现代码省略 }
	}

	public void plaats() {
		// 实现代码省略
	}
}
class DutchAddressAdapter extends DutchAddress {
	// private (1) ;
	private Address address;//
	public DutchAddressAdapter (Address addr) {
		address = addr;
	}
	public void straat() {
		// (2) ;
		address.street();
	}
	public void postcode() {
		//(3)
		address.zip();
	}
	public void plaats() {
		// (4);
		address.city();
	}
// 其他成员省略
}
class TestDutchAddress {
	public static void main(String[] args) {
		Address addr = new Address();
		// (5) ;
		DutchAddress addrAdapter = new DutchAddressAdapter (addr);
		System.out.println("\n The DutchAddress\n");
		testDutch(addrAdapter);
	}
	static void testDutch(DutchAddress addr) {
		addr.straat();
		addr.postcode();
		addr.plaats();
	}
}
// 其他成员省略