package com.customerscrudoperation;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Customer</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Customer e=CustomerDao.getCustomerById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='text' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Number:</td><td><input type='text' name='number' value='"+e.getNumber()+"'/></td></tr>");  
        out.print("<tr><td>Start_Time:</td><td><input type='text' name='stime' value='"+e.getStime()+"'/>"
        		+ "</td></tr>");  
        out.print("<tr><td>End_Time:</td><td><input type='text' name='etime' value='"+e.getEtime()+"'/></td></tr>");  
        out.print("<tr><td>Duration:</td><td><input type='text' name='duration' value='"+e.getDuration()+"'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}