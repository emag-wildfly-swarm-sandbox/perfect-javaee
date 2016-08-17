package wildflyswarm;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jgroups.JGroupsFraction;
import org.wildfly.swarm.undertow.WARArchive;

public class App {

  public static void main(String[] args) throws Exception {
    Container container = new Container(args);

    WARArchive archive = ShrinkWrap.create(WARArchive.class);
    archive.addPackage("perfectjavaee.chapter03");
    archive.staticContent();
    archive.addAsWebResource(new ClassLoaderAsset("WEB-INF/echo.jsp", App.class.getClassLoader()), "WEB-INF/echo.jsp");
    archive.addAsWebInfResource(new ClassLoaderAsset("WEB-INF/web.xml", App.class.getClassLoader()), "web.xml");
    archive.setContextRoot("/firstcdi");

    container.fraction(JGroupsFraction.defaultFraction());
    container.start().deploy(archive);
  }

}
