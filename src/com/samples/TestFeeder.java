package com.samples;

//1.一个饲养员给动物喂食物的例子体现JAVA中的面向对象思想,接口（抽象类）的用处。
/*区别：抽象类是对事物的抽象，接口是对行为的抽象。例如：飞机和鸟都有一个共同的行为就是飞行，
那么可以把飞机设计成一个类Airplane, 鸟设计成一个类Bird，把飞行这个行为设计成一个接口Fly，包含方法fly()
*/

interface Animal {
  public void eat(Food food);
}

class Cat implements Animal {
  public void eat(Food food) {
      System.out.println("小猫吃" + food.getName());
  }
}

class Dog implements Animal {
  public void eat(Food food) {
      System.out.println("小狗啃" + food.getName());
  }
}

class Cock implements Animal{
	public void eat(Food food) {
		System.out.println("小鸡吃" + food.getName());
	}
}

abstract class Food {
  protected String name;
  public String getName() {
      return name;
  }
  public void setName(String name) {
      this.name = name;
  }
}

class Fish extends Food {
  public Fish(String name) {
      this.name = name;
  }
}

class Bone extends Food {
  public Bone(String name) {
      this.name = name;
  }
}

class Worm extends Food {
	public Worm(String name) {
		this.name = name;
	}
	
}

class Feeder {
 
  public void feed(Animal animal, Food food) {
      animal.eat(food);
  }
}

public class TestFeeder {
  public static void main(String[] args) {
      Feeder feeder = new Feeder();
      Animal animal = new Dog();
      Food food = new Bone("肉骨头");
      feeder.feed(animal, food); //给狗喂肉骨头
      
      animal = new Cat();
      food = new Fish("鱼");
      feeder.feed(animal, food); //给猫喂鱼
      
      animal = new Cock();
      food = new Worm("虫子");
      feeder.feed(animal, food);//小鸡吃虫子
  }
}


