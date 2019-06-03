package csw.java.model.decorate;

public class PhoneTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.call();
        System.out.println("------------");
        phone = new ColorPhone();
        phone.call();
        System.out.println("------------");
        phone = new MusicColorPhone();
        phone.call();
    }
}
