package csw.java.health;

/**
 * 健康度打分类型
 * <p>
 * 0:CUP <br>
 * 1:内存 <br>
 * 2:IO<br>
 * 3:硬盘<br>
 * 4:
 * 
 * code:编号 desc:描述 weight:权重
 *
 * @author chensw
 * @create 2018-1-11 9:44
 */

public enum LoadMetric {

  CPU(0, "CPU", 2),

  MEMORY(1, "memory", 2),

  IO(2, "IO", 1),

  DISK(3, "disk", 0)

  ;

  /**
   * 权重单位化
   */
  static {
    double total = 0.0;
    for (LoadMetric lm : values()) {
      total += lm.weight;
    }

    for (LoadMetric ht : values()) {
      ht.weight = ht.weight / total;
    }
  }

  private int code;
  private String desc;
  private double weight;

  private LoadMetric(int code, String desc, double weight) {
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
