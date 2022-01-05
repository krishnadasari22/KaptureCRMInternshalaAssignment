package com.customerscrudoperation;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String number=request.getParameter("number");  
        String stime=request.getParameter("stime");  
        String etime=request.getParameter("etime");  
        String duration=request.getParameter("duration");  
          
        Customer e=new Customer();  
        e.setId(id);  
        e.setNumber(number);  
        e.setStime(stime);  
        e.setEtime(etime);  
        e.setDuration(duration);  
          
        int status=CustomerDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}
