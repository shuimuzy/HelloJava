package com.samples.pattern;

/**
 * 
 * @author shuimu.tian
 *
 * 主要解决：一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。
 *
 * 优点：装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。目的是增加新功能。
 * 
 * 例子：通过装饰模式为circle和rectangle添加red border
 *
 */

// 创建一个接口。
interface Shape {
	void draw();
}

// 创建实现接口的实体类。
class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape: Rectangle");
	}
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape: Circle");
	}
}

// 创建实现了 Shape 接口的抽象装饰类。
abstract class ShapeDecorator implements Shape {
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	public void draw() {
		decoratedShape.draw();
	}
}

// 创建扩展了 ShapeDecorator 类的实体装饰类。
class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color: Red");
	}
}

public class DecoratorPatternDemo {

	public static void main(String[] args) {

		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}

}
