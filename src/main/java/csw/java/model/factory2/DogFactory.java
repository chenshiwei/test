package csw.java.model.factory2;

public class DogFactory implements AnimalFactory {

	@Override
	public Animal createAnimal() {
		return new Dog();
	}

}
