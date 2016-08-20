package wildflyswarm;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class App {

  public static void main(String[] args) throws Exception {
    Swarm swarm = new Swarm(args);

    JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class);
    archive.addPackages(true, "perfectjavaee.chapter04.cdi_event");

    swarm.start().deploy(archive);
  }

}
