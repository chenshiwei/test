package csw.java.health;

import java.util.*;

/**
 * 健康度打分类型
 * <p>
 * 0:用户体验 <br>
 * 1:应用负载 <br>
 * 2:未处理故障<br>
 * 
 * code:编号 desc:描述 weight:权重
 *
 * @author chensw
 * @create 2018-1-11 9:44
 */
public enum HealthType {

  USER_EXPERIENCE(0, "USER EXPERIENCE", 5),

  APPLICATION_LOAD(1, "APPLICATION LOAD", 2),

  UNHANDLED_FAULT(2, "UNHANDLED FAULT", 3),

  ;

  private static Map<Integer, HealthType> map = new HashMap<>();
  

  public static HealthType getHealthTypeByCode(Integer code) {
    return map.get(code);
  }

  /**
   * 权重单位化
   */
  static {
    double total = 0.0;
    for (HealthType ht : values()) {
      total += ht.weight;
    }
    for (HealthType ht : values()) {
      ht.weight = ht.weight / total;
      map.put(ht.code(), ht);
    }
  }

  private int code;
  private String desc;
  private double weight;

  private HealthType(int code, String desc, double weight) {
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
