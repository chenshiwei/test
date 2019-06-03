package csw.java.model.decorate2;

public abstract class PhoneDecorate implements Phone {

    private Phone phone;


    public PhoneDecorate(Phone phone) {
        super();
        this.phone = phone;
    }


    @Override
    public void call() {
        this.phone.call();

    }

}
