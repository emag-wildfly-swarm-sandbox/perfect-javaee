package perfectjavaee.chapter04.decorator.pointprocessor;

public class PointResponse {

  private final int value;
  private final String expireDay;

  public PointResponse(int value, String expireDay) {
    this.value = value;
    this.expireDay = expireDay;
  }

  public int getValue() {
    return value;
  }

  public String getExpireDay() {
    return expireDay;
  }

}
