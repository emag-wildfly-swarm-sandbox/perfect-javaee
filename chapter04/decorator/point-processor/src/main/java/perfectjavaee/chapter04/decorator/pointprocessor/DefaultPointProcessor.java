package perfectjavaee.chapter04.decorator.pointprocessor;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@ApplicationScoped
public class DefaultPointProcessor implements PointProcessor {

  private static final int EXPIRE_DAY = 90;
  private static final BigDecimal RATE = new BigDecimal(0.01);

  @Override
  public Point process(int purchasePrice) {
    LocalDate expire = LocalDate.now().plusDays(EXPIRE_DAY);
    BigDecimal price = new BigDecimal(purchasePrice);
    BigDecimal point = price.multiply(RATE).setScale(0, RoundingMode.DOWN);
    return new Point(point.intValue(), expire);
  }

}
