package csw.java.model.decorate;

public class MusicColorPhone extends ColorPhone {
@Override
public void call() {

	super.call();
	System.out.println("听音乐");
}
}
