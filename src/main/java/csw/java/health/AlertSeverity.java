package csw.java.health;

/**
 * 类型
 * <p>
 * 0:Severity=1 警告 <br>
 * 1:Severity=2 错误 <br>
 * 2:Severity=3 紧急 <br>
 * <p>
 * code:编号 desc:描述 weight:权重
 * *
 *
 * @author chensw
 * @create 2018-1-11 9:44
 */

public enum AlertSeverity {

    WARNING(0, "WARNING", 1),

    ERROR(1, "ERROR", 2),

    CRITICAL(2, "CRITICAL", 3),;

    private int code;
    private String desc;
    private double weight;

    private AlertSeverity(int code, String desc, double weight) {
        this.desc = desc;
        this.code = code;
        this.weight = weight;
    }

    public int code() {
        return this.code;
    }

    public String desc() {
        return this.desc;
    }

    public double weight() {
        return this.weight;
    }
}
