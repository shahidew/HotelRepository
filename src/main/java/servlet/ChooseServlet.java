package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "ChooseServlet")
public class ChooseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><body>");
        String op;
        op = request.getParameter("operation");

        if(op.equals("reserve")){
            String name, family, nationalCode, startDateStr, endDateStr;
            int capacity, reserveCode;
            reserveCode = 1001;
            name = request.getParameter("fname");
            family = request.getParameter("lname");
            nationalCode = request.getParameter("nationalCode");
            startDateStr = request.getParameter("start_date");
            endDateStr = request.getParameter("end_date");
            capacity = Integer.parseInt(request.getParameter("capacity"));
            String[] arr = startDateStr.split("/");
            servlet.Date startDate = new servlet.Date(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
            String[] arr2 = endDateStr.split("/");
            servlet.Date endDate = new Date(Integer.parseInt(arr2[0]),Integer.parseInt(arr2[1]),Integer.parseInt(arr2[2]));
            RoomReservationDao roomReservationDao = new RoomReservationDao();
            reserveCode = roomReservationDao.returnCode(reserveCode);
            RoomReservation roomReservation = new RoomReservation(name,family,nationalCode,startDate,endDate,capacity,reserveCode);
            roomReservationDao.insert(roomReservation);
            writer.println("the reserve is done " + "your reserve number is : " + roomReservation.getReserveCode());
           // writer.println(roomReservation.getName() + " " + roomReservation.getFamily() +" "+ roomReservation.getNationalCode()+" " + roomReservation.getStartDate() +" " + roomReservation.getEndDate() + " " + roomReservation.getCapacity() + " " + roomReservation.getReserveCode());
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
