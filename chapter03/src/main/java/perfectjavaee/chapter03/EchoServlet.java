package perfectjavaee.chapter03;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/echo")
public class EchoServlet extends HttpServlet {

  @Inject
  RequestCounter counter;

  @Inject
  MessageService messageService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String name = req.getParameter("name");

    String message = messageService.create(name);

    req.setAttribute("title", message);

    counter.increment();

    req.getRequestDispatcher("/WEB-INF/echo.jsp").forward(req, res);
  }

}
