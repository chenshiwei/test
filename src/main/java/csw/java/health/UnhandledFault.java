package csw.java.health;

public class UnhandledFault {

  private double criticalWeight = 3.0;
  private int criticalNumber;
  private double errorWeight = 2.0;
  private int errorNumber;
  private double warningWeight = 1.0;
  private int warningNumber;
  private double scaleCoefficient = 1.0;

  public UnhandledFault(double criticalWeight, int criticalNumber, double errorWeight, int errorNumber,
      double warningWeight, int warningNumber, double scaleCoefficient) {
    super();
    this.criticalWeight = criticalWeight;
    this.criticalNumber = criticalNumber;
    this.errorWeight = errorWeight;
    this.errorNumber = errorNumber;
    this.warningWeight = warningWeight;
    this.warningNumber = warningNumber;
    this.scaleCoefficient = scaleCoefficient;
  }

  public UnhandledFault(int criticalNumber, int errorNumber, int warningNumber, double scaleCoefficient) {
    super();
    this.criticalNumber = criticalNumber;
    this.errorNumber = errorNumber;
    this.warningNumber = warningNumber;
    this.scaleCoefficient = scaleCoefficient;
  }

  public UnhandledFault(int criticalNumber, int errorNumber, int warningNumber) {
    super();
    this.criticalNumber = criticalNumber;
    this.errorNumber = errorNumber;
    this.warningNumber = warningNumber;
  }

  public double getUnhandledFault() {
    return (criticalNumber * criticalWeight + errorNumber * errorWeight + warningNumber * warningWeight)
        / scaleCoefficient;
  }

}
