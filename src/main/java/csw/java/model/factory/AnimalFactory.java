package csw.java.model.factory;

public class AnimalFactory {

    private AnimalFactory() {
    }

    // public static Dog createDog() {
    // return new Dog();
    // }
    //
    // public static Pig createPig() {
    // return new Pig();
    // }
    public static Animal createAnimal(String type) {
        if ("pig".equals(type)) {
            return new Pig();
        }
        if ("dog".equals(type)) {
            return new Dog();
        }
        return null;
    }
}
