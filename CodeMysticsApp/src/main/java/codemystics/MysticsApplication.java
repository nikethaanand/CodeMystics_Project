package codemystics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;

@WebServlet(name = "MysticApp", value = "/api")
public class MysticsApplication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.getWriter().write("no get method");
    }
}
