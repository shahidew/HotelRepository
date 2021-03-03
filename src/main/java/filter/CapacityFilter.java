package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "CapacityFilter")
public class CapacityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><body>");
        String capacity;
        capacity = request.getParameter("capacity");

        Pattern pattern = Pattern.compile("[1-4]{1}");
        Matcher matcher = pattern.matcher(capacity);
        if(matcher.matches()){
            chain.doFilter(request, response);
        }
        else{
            writer.println("Error Capacity is not valid");
            request.getRequestDispatcher("roomReservationSystem.html").include(request,response);
        }
        writer.print("</html></body>");
        writer.close();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
