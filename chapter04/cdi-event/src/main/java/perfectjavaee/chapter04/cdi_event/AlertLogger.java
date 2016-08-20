package perfectjavaee.chapter04.cdi_event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;

@Dependent
public class AlertLogger {

  private static final Logger LOG = LoggerFactory.getLogger(AlertLogger.class);

  public void log(@Observes Alert alert) {
    LOG.info(alert.toString());
  }

}
