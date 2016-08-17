package perfectjavaee.chapter03;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@Named
@SessionScoped
public class RequestCounter implements Serializable {

  private final AtomicLong count = new AtomicLong();

  public void increment() {
    count.incrementAndGet();
  }

  public long now() {
    return count.get();
  }

}
