package com.samples.pattern;

/**
 * 
 * @author shuimu.tian
 *
 * 适配器模式中主要有三个部分，Adaptee -> Adapter -> Target
 * 用途：当原接口不合适，需要改变接口以适应场合。
 * 例如，现在有个手机充电电压是5v，而插座电压是220v，这时我们可以把充电器看成是Adapter，它将电压由5v转成220v。
 *
 */

// Target 目标接口
interface Volt5 {
	public int getVolt();
}

// Adaptee 需要被转换的对象
class Volt220 {
	public int getVolt() {
		return 220;
	}
}

class VoltAdapter implements Volt5 {
	
	private Volt220 vt220 = new Volt220();

	@Override
	public int getVolt() {
		return vt220.getVolt();
	}
	
}

public class AdapterPatternDemo {

	public static void main(String[] args) {
		
		Volt5 vt5 = new VoltAdapter();
		vt5.getVolt();

	}

}