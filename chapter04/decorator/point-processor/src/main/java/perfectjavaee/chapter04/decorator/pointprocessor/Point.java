package perfectjavaee.chapter04.decorator.pointprocessor;

import java.time.LocalDate;

public class Point {

  private final int value;
  private final LocalDate expireDay;

  public Point(int value, LocalDate expireDay) {
    this.value = value;
    this.expireDay = expireDay;
  }

  public int getValue() {
    return value;
  }

  public LocalDate getExpireDay() {
    return expireDay;
  }

}
