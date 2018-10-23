package csw.java.health;

public class HealthScore {

  /**
   * 计算得分基本方法(线性)
   *
   * @param min  得分100分阈值
   * @param max  得分0分阈值
   * @param fact 实际值
   * @return
   */
  public static <T extends Number> double getScoreBase(T min, T max, T fact) {
    if (fact == null || fact.doubleValue() < min.doubleValue()) {
      return 100.0;
    }
    if (fact.doubleValue() > max.doubleValue()) {
      return 0.0;
    }
    return 100 * (max.doubleValue() - fact.doubleValue()) / (max.doubleValue() - min.doubleValue());
  }


  /**
   * 用户体验得分
   *
   * @param fact 实际值
   * @return 用户体验得分
   */
  public static Double getExperienceScore(Double fact) {
    Double min = 0.2;
    Double max = 8.0;
    /*
     * 中间可以动态改变
     */
    return getScoreBase(min, max, fact);
  }

  public static void main(String[] args) {
    System.out.println(getExperienceScore(6.0));
  }
}
