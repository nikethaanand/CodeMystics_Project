package codemystics;

import com.google.gson.Gson;

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.setContentType("application/json");
        String urlPath = request.getPathInfo();
        Gson gson = new Gson();
        // check for valid url
        if (urlPath == null || urlPath.isEmpty() || !isUrlValid(urlPath)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            SwipeResponse swipeResponse = new SwipeResponse();
            swipeResponse.setMessage("invalid url");
            response.getOutputStream().print(gson.toJson(swipeResponse));
            response.getOutputStream().flush();
            return;
        }
    }

}
