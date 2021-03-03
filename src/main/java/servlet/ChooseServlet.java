package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ChooseServlet")
public class ChooseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><body>");

        String op;
        op = request.getParameter("operation");
        if(op.equals("reserve")){
            String name, family, nationalCode;
            int capacity, reserveCode;
            name = request.getParameter("fname");
            family = request.getParameter("lname");
            nationalCode = request.getParameter("nationalCode");
            String startDateStr = request.getParameter("start_date");
            Date startDate = null;
            try {
                startDate = new SimpleDateFormat("yyyy/MM/dd").parse(startDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String endDateStr = request.getParameter("end_date");
            Date endDate = null;
            try {
                endDate = new SimpleDateFormat("yyyy/MM/dd").parse(endDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            capacity = Integer.parseInt(request.getParameter("capacity"));
            reserveCode = 1001;
            RoomReservationDao roomReservationDao = new RoomReservationDao();
            RoomReservation roomReservation = new RoomReservation(name,family,nationalCode,startDate,endDate,capacity,roomReservationDao.returnCode(reserveCode));
            roomReservationDao.insert(roomReservation);
            writer.println("the reserve is done " + "your reserve number is : " + roomReservation.getReserveCode());
            writer.println(roomReservation.getName() + " " + roomReservation.getFamily() +" "+ roomReservation.getNationalCode()+" " + roomReservation.getStartDate() +" " + roomReservation.getEndDate() + " " + roomReservation.getCapacity() + " " + roomReservation.getReserveCode());
        }
        else if(op.equals("cancellation")){

        }
        else if(op.equals("changePeriod")){

        }
        else if (op.equals("changeCapacity")){

        }


        writer.println("</body></html>");
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
