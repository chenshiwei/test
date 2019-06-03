package csw.java.model.decorate2;

public class MusicPhoneDecorate extends PhoneDecorate {

    public MusicPhoneDecorate(Phone phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("听音乐");
    }
}
