package perfectjavaee.chapter04.decorator.pointprocessor.sale;

import perfectjavaee.chapter04.decorator.pointprocessor.Point;
import perfectjavaee.chapter04.decorator.pointprocessor.PointProcessor;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public class SalePointDecorator implements PointProcessor {

  private static final int BONUS_RATE = 5;

  @Inject
  @Delegate
  private PointProcessor pointProcessor;

  @Override
  public Point process(int purchasePrice) {
    Point point = pointProcessor.process(purchasePrice);
    return new Point(point.getValue() * BONUS_RATE, point.getExpireDay());
  }

}
