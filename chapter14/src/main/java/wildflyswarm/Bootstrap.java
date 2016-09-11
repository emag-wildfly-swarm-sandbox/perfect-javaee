package wildflyswarm;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Bootstrap {

  public static void main(String[] args) throws Exception {
    Swarm swarm = new Swarm(args);

    JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class);
    archive.addPackage("perfectjavaee.chapter14");

    archive.addAsWebInfResource(
      new ClassLoaderAsset("META-INF/persistence.xml", Bootstrap.class.getClassLoader()), "classes/META-INF/persistence.xml");

    swarm.start().deploy(archive);
  }

}
