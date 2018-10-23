package csw.java.model.decorate2;

public class ColorPhoneDecorate extends PhoneDecorate {

	public ColorPhoneDecorate(Phone phone) {
		super(phone);
	}

	@Override
	public void call() {
		System.out.println("播放彩铃");
		super.call();
	}
}
