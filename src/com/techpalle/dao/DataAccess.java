package com.techpalle.dao;

import java.sql.*;

import com.techpalle.model.Customer;

public class DataAccess
{
	
	public static final String url="jdbc:mysql://localhost:3306/customer";
	public static final String user ="root";
	public static final String password = "MithunKichu";
	

	public static void inserting(Customer c)
	{
		 Connection con = null;
		 PreparedStatement ps = null;
		
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
     		 con = DriverManager.getConnection(url,user,password);
			String qry ="insert into customer_details(C_name,Gender,Email,Password,Mobile,State) values(?,?,?,?,?,?)";
			 ps  = con.prepareStatement(qry);
			
			ps.setString(1, c.getName());
			ps.setString(2, c.getGen());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getPwd());
			ps.setLong(5, c.getMob());
			ps.setString(6, c.getState());
			
			ps.executeUpdate();
			
			
			
		} 
		
		catch (SQLException  | ClassNotFoundException e)
		{
			
			e.printStackTrace();
		}
		finally 
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
		}

	}
	
	public static boolean validation(String m,String p)
	{
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 boolean b = false;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
    		 con = DriverManager.getConnection(url,user,password);
			String qry ="select * from customer_details where Email=? and Password=?";
			 ps  = con.prepareStatement(qry);
			 ps.setString(1, m);
			 ps.setString(2, p);
				
			 rs = ps.executeQuery();
			 b=rs.next();
			
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	     
		finally
		{
			if(rs!=null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
		}
		
		return b;
		
	}
}
