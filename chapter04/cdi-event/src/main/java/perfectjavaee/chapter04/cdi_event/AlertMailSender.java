package perfectjavaee.chapter04.cdi_event;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.EventMetadata;

@Dependent
public class AlertMailSender {

  public void sendMail(@Observes @Serious Alert alert, EventMetadata data) {
    System.err.println("I sent a serious mail!: " + alert);
    System.out.println("----- print EventMetadata -----");
    System.out.println("data.getQualifiers(): " + data.getQualifiers());
    System.out.println("data.getInjectionPoint(): " + data.getInjectionPoint());
    System.out.println("data.getType(): " + data.getType());
  }

}
