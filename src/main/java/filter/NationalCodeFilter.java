package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "NationalCodeFilter")
public class NationalCodeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><body>");
        String nationalCode, national_code, nationalNumber, national_number;
        nationalCode = request.getParameter("nationalCode");
        national_code = request.getParameter("national_code");
        nationalNumber = request.getParameter("nationalNumber");
        national_number = request.getParameter("national_number");
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher matcher = pattern.matcher(nationalCode);
        Matcher matcher1 = pattern.matcher(national_code);
        Matcher matcher2 = pattern.matcher(nationalNumber);
        Matcher matcher3 = pattern.matcher(national_number);
        if(matcher.matches() || matcher1.matches() || matcher2.matches() || matcher3.matches()){
            chain.doFilter(request, response);
        }
        else{
            writer.println("Error nationalCode is not valid");
            request.getRequestDispatcher("roomReservationSystem.html").include(request,response);
        }
        writer.print("</html></body>");
        writer.close();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
