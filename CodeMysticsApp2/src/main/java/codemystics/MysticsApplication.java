package codemystics;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MysticsServlet", value = "/api")
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
        String urlPath = request.getPathInfo();
        System.out.println(urlPath);
        Gson gson = new Gson();
        // check for valid url
        if (urlPath == null || urlPath.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getOutputStream().print(gson.toJson("Invalid Url"));
            response.getOutputStream().flush();
            return;
        }
        if (urlPath.equals("/user/save")){
            StringBuilder sb = new StringBuilder();
            String s;
            while((s = request.getReader().readLine()) != null) {
                sb.append(s);
            }
            User user = (User) gson.fromJson(sb.toString(), User.class);
            UserInformation userController = new UserInformation();
            try {
                userController.saveUser(user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        if (urlPath.equals("/userhouseinfo/save")){
            StringBuilder sb = new StringBuilder();
            String s;
            while((s = request.getReader().readLine()) != null) {
                sb.append(s);
            }
            User user = (User) gson.fromJson(sb.toString(), User.class);
            UserInformation userController = new UserInformation();
            try {
                userController.saveUserHouseholdBill(user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.getOutputStream().print(gson.toJson("Data Saved"));
        response.getOutputStream().flush();
    }

}
