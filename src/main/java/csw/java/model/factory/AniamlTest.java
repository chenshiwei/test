package csw.java.model.factory;

public class AniamlTest {

	public static void main(String[] args) {
		Animal pig =AnimalFactory.createAnimal("pig");
		pig.eat();
//		Dog dog = AnimalFactory.createDog();
		Animal dog = AnimalFactory.createAnimal("dog");
		dog.eat();

	}

}
