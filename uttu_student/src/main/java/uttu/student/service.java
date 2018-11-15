package uttu.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class service {

	public student get(int rollno) 
	{
		student s=new student();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","newuser","password");
			PreparedStatement ps=con.prepareStatement("select * from student where rollno=?");
			ps.setInt(1,rollno);
			ResultSet rs=ps.executeQuery();
			//convert rs into list and return
			while(rs.next())
			{
				s=new student(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			}
			if(s.getName()==null)
			{
				s.setName("");
			}
			System.out.println(s.getName());
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
	
	public int post(String name,int rollno,int pm,int cm,int mm) 
	{
		int res=0;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","newuser","password");
			PreparedStatement ps=con.prepareStatement("insert into student values (?,?,?,?,?)");
			//System.out.println(rr.getDate()+" "+rr.getTime()+" "+rr.getName()+" "+rr.getPhone());
			ps.setString(1, name);
			ps.setInt(2, rollno);
			ps.setInt(3, pm);
			ps.setInt(4, cm);
			ps.setInt(5, mm);
			res=ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return res;
	}
	
	public student put(int rollno,String field,String value) 
	{
		System.out.println(rollno+" "+field+" "+value);
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","newuser","password");
			PreparedStatement ps=con.prepareStatement("update student set "+field+"= ? where rollno=?");
			System.out.println(ps);
//			ps.setString(1, field);
			if(field.equals("name"))
				ps.setString(1, value);
			else
				ps.setInt(1,Integer.parseInt(value));
			ps.setInt(2, rollno);
			ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(field.equals("rollno"))
			rollno=Integer.parseInt(value);
			
//			return new service().get(Integer.parseInt(value));
//		else
			return new service().get(rollno);
		
	}
	public List<student> rangeQuery(int start,int end) 
	{
		List<student>rec=new ArrayList<student>();
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","newuser","password");
			PreparedStatement ps=con.prepareStatement("select * from student where rollno between ? and ?");
			ps.setInt(1,start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			System.out.println(ps);
			//convert rs into list and return
			while(rs.next())
			{
				rec.add(new student(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rec;
	}
}
