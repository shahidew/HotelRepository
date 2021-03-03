package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "DateFilter")
public class DateFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><body>");
        String startDate, endDate;
        startDate = request.getParameter("start_date");
        endDate = request.getParameter("end_date");
       // ^[1-4]\d{3}\/((0[1-6]\/((3[0-1])|([1-2][0-9])|(0[1-9])))|((1[0-2]|(0[7-9]))\/(30|31|([1-2][0-9])|(0[1-9]))))$
        //Pattern pattern = Pattern.compile("((1399|1400|1401|1402))/([1-7]{1})/([1-31]){1}$");
        Pattern pattern = Pattern.compile("^[1][1-4][0-9]{2}\\/((0[1-6]\\/(0[1-9]|[1-2][0-9]|3[0-1]))|(0[7-9]\\/(0[1-9]|[1-2][0-9]|30))|(1[0-1]\\/(0[1-9]|[1-2][0-9]|30))|(12\\/(0[1-9]|[1-2][0-9])))");
        Matcher matcher = pattern.matcher(startDate);
        Matcher matcher1 = pattern.matcher(endDate);
        if(matcher.matches() && matcher1.matches()){
            chain.doFilter(request, response);
        }
        else{
            writer.println("Error Date is not valid");
            request.getRequestDispatcher("roomReservationSystem.html").include(request,response);
        }
        writer.print("</html></body>");
        writer.close();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
