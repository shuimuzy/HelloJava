package com.samples.pattern;

/**
 * 
 * @author shuimu.tian
 * 
 * 主要解决：在直接访问对象时带来的问题，比如说：要访问的对象在远程的机器上。
 * 何时使用：想在访问一个类时做一些控制。如何解决：增加中间层。关键代码：实现与被代理类组合。
 * 
 * 注意事项： 1、和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。
 * 2、和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制。
 *
 */

interface Image {
	void display();
}

class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	@Override
	public void display() {
		System.out.println("Displaying " + fileName);
	}

	private void loadFromDisk(String fileName) {
		System.out.println("Loading " + fileName);
	}
}

class ProxyImage implements Image {

	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}

public class ProxyPatternDemo {

	public static void main(String[] args) {

		Image imageReal = new RealImage("test_disk.jpg");// load from disk
		Image imageProxy = new ProxyImage("test_proxy.jpg");// load from proxy

		// 图像将从磁盘加载
		imageReal.display();
		System.out.println("");
		// 图像将无法从磁盘加载
		imageProxy.display();
	}

}
