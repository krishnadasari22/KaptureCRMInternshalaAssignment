package com.customerscrudoperation;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Customer</a>");  
        out.println("<h1>Customers List</h1>");  
          
        List<Customer> list=CustomerDao.getAllCustomers();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>From_Number</th><th>Start_Time</th><th>End_Time</th><th>Duration</th> "
        		+ "<th>Edit</th><th>Delete</th></tr>");  
        for(Customer e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNumber()+"</td><td>"+e.getStime()+"</td>"
         		+ "<td>"+e.getEtime()+"</td><td>"+e.getDuration()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"
         				+ "<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}