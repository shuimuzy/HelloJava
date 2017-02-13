package com.samples.pattern;

//1、定义一个接口自行车，Bike。
interface Bike {
	
	void ride();

}

//2、定义实现类山地自行车，MBike

class MBike implements Bike{ 
    @Override 
    public void ride() { 
           System.out.println("MBike Rides... "); 
    }
}

//3、定义实现类公路自行车，RBike

class RBike implements Bike{ 
    @Override 
    public void ride() { 
           System.out.println("RBike Rides... "); 
    }
}

//4、工厂类，负责创建对象
class BikeFactory {
   //使用 getShape 方法获取形状类型的对象
   public Bike getBike(String bikeType){

      if(bikeType == null){
         return null;
      }        

      if(bikeType.equalsIgnoreCase("MBike")){
         return new MBike();
      }else if(bikeType.equalsIgnoreCase("RBike")){
         return new RBike();
      }

      return null;
   }
}

//5、子类决定实例化哪一个类

public class FactoryPatternDemo {
   public static void main(String[] args) {

      BikeFactory bikeFactory = new BikeFactory();

      Bike bike1 = bikeFactory.getBike("MBike");
      bike1.ride();

      Bike bike2= bikeFactory.getBike("RBike");
      bike2.ride();
   }
}