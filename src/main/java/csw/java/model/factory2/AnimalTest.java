package csw.java.model.factory2;

public class AnimalTest {

    public static void main(String[] args) {
        AnimalFactory animalFactory = new DogFactory();
        Animal animal = animalFactory.createAnimal();
        animal.eat();
        animalFactory = new CatFactory();
        animal = animalFactory.createAnimal();
        animal.eat();
    }

}
