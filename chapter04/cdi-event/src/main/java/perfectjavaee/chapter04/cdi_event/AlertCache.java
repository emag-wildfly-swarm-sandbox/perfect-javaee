package perfectjavaee.chapter04.cdi_event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class AlertCache {

  private static final int MAX_CACHE = 1_000;

  private final Map<Long, Alert> fifo;

  public AlertCache() {
    Map<Long, Alert> cache = new LinkedHashMap<Long, Alert>(MAX_CACHE) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Long, Alert> entry) {
        return size() > MAX_CACHE;
      }
    };

    this.fifo = Collections.synchronizedMap(cache);
  }

  public Map<Long, Alert> getFifo() {
    return fifo;
  }

  public Alert get(long id) {
    return fifo.get(id);
  }

  public void putIfAbsent(@Observes Alert alert) {
    fifo.putIfAbsent(alert.getId(), alert);
  }

}
