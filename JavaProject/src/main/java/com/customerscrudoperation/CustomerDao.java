package com.customerscrudoperation;
import java.util.*;  
import java.sql.*;  
  
public class CustomerDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","abcd");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Customer e){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into database.customer_cal_detailsl(Number,Start_Time,End_Time,Duration) values (?,?,?,?)");  
            ps.setString(1,e.getNumber());  
            ps.setString(2,e.getStime());  
            ps.setString(3,e.getEtime());  
            ps.setString(4,e.getDuration());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Customer e){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update database.customer_cal_detailsl set Number=?,Start_Time=?,End_Time=?,Duration=? where id=?");  
            ps.setString(1,e.getNumber());  
            ps.setString(2,e.getStime());  
            ps.setString(3,e.getEtime());  
            ps.setString(4,e.getDuration());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from database.customer_cal_detailsl where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Customer getCustomerById(int id){  
    	Customer e=new Customer();  
          
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from database.customer_cal_detailsl where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setNumber(rs.getString(2));  
                e.setStime(rs.getString(3));  
                e.setStime(rs.getString(4));  
                e.setDuration(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Customer> getAllCustomers(){  
        List<Customer> list=new ArrayList<Customer>();  
          
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from database.customer_cal_detailsl");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Customer e=new Customer();  
                e.setId(rs.getInt(1));  
                e.setNumber(rs.getString(2));  
                e.setStime(rs.getString(3));  
                e.setStime(rs.getString(4));  
                e.setDuration(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){
        	e.printStackTrace();
        }  
          
        return list;  
    }  
}