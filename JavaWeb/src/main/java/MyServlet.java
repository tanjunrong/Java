import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-16");
        resp.setCharacterEncoding("utf-16");

        PrintWriter out  = resp.getWriter();

        Cookie[] cookies = req.getCookies();

        if(cookies != null){
            out.write("您上一次访问时间为：");
            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("lastLoginTime")){
                    long lastLoginDate = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginDate);
                    out.write(date.toString());
                }
            }
        }else {
            out.write("这是第一次访问！");
        }

        Cookie cookie = new Cookie("lastLoginTime",System.currentTimeMillis()+"");
        cookie.setMaxAge(2);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
