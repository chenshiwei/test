package csw.java.model.decorate;

public class ColorPhone extends Phone {

    @Override
    public void call() {
        System.out.println("彩铃");
        super.call();
    }
}
