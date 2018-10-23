package design.pattern.flyweight;

public class FlyweightMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight flyweight;
		
		flyweight = factory.getFlyweight("A");
		System.out.println(flyweight);
		
		flyweight = factory.getFlyweight("A");
		System.out.println(flyweight);
		
		flyweight = factory.getFlyweight("A");
		System.out.println(flyweight);
		
		flyweight = factory.getFlyweight("B");
		System.out.println(flyweight);
		
		flyweight = factory.getFlyweight("B");
		System.out.println(flyweight);
	}

}
