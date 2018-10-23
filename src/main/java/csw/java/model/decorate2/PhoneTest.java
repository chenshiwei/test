package csw.java.model.decorate2;

public class PhoneTest {
	public static void main(String[] args) {
		Phone phone = new PhoneImpl();
		phone.call();
		System.out.println("------------");
		PhoneDecorate pd = new ColorPhoneDecorate(phone);
		pd.call();
		System.out.println("------------");
		pd = new MusicPhoneDecorate(phone);
		pd.call();
		System.out.println("------------");
		pd = new MusicPhoneDecorate(new ColorPhoneDecorate(phone));
		pd.call();
		
	}
}
