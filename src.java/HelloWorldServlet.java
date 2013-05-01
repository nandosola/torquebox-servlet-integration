package cc.abstra.playground;
 
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
 
public class HelloWorldServlet extends HttpServlet {

  private static final Logger LOG = Logger.getLogger(HelloWorldServlet.class.getName());
  private ServletContext context;

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    LOG.info("I'm ready!");
  }
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    LOG.info("I've been called!");
    ServletOutputStream out = res.getOutputStream();
    res.setContentType("text/html");
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello from the innards of a Servlet!</h1>");
		out.println("</body>");
		out.println("</html>");	
	}
  public void destroy() {
    LOG.info("Goodbye, cruel world!");
  }
}
