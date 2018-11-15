package uttu.student;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("student")
public class MyResource {

	service s=new service();
	
    @GET
    @Path("{a}")
    @Produces(MediaType.APPLICATION_JSON)
    public student getIt(@PathParam("a")int rollno) {
        return s.get(rollno);
    }
    @POST
    @Path("{a}/{b}/{c}/{d}/{e}")
    @Produces(MediaType.TEXT_PLAIN)
    public int postIt(@PathParam("a")String name,@PathParam("b")int rollno,@PathParam("c")int pm,
    					 @PathParam("d")int cm,@PathParam("e")int mm) {
        return s.post(name,rollno,pm,cm,mm);
   }
    @PUT
    @Path("{a}/{b}/{c}")
    @Produces(MediaType.APPLICATION_JSON)
    public student putIt(@PathParam("a")int rollno,@PathParam("b")String field,@PathParam("c")String value) {
        return s.put(rollno,field,value);
    }
    @GET
    @Path("range/{a}/{b}/{c}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<student> rangeQuery(@PathParam("a")int start,@PathParam("b")int end,@PathParam("c")String criteria)
    {
    	List<student>l=s.rangeQuery(start,end);
    	//sorting by rollno
    	for (int i=0;i<l.size();i++)
    	{
    		for(int j=i+1;j<l.size();j++)
    		{
    			if(l.get(i).getRollno()>l.get(j).getRollno())
    			{
    				Collections.swap(l, i, j);
    			}
    		}
    	}
    	//sorting by criteria - rollno,name,grade,marks
    	if(criteria.equals("name"))
    	{	
    		for (int i=0;i<l.size();i++)
	    	{
	    		for(int j=i+1;j<l.size();j++)
	    		{
	    			if(l.get(i).getName().compareTo(l.get(j).getName())>0)
	    			{
	    				Collections.swap(l, i, j);
	    			}
	    		}
	    	}
	    }
    	else if(criteria.equals("grade"))
    	{
    		for (int i=0;i<l.size();i++)
	    	{
	    		for(int j=i+1;j<l.size();j++)
	    		{
	    			if(l.get(i).getGrade().compareTo(l.get(j).getGrade())>0)
	    			{
	    				Collections.swap(l, i, j);
	    			}
	    		}
	    	}

    	}
    	else if(criteria.equals("marks"))
    	{
    		for (int i=0;i<l.size();i++)
	    	{
	    		for(int j=i+1;j<l.size();j++)
	    		{
	    			if(l.get(i).getTotalMarks()>l.get(j).getTotalMarks())
	    			{
	    				Collections.swap(l, i, j);
	    			}
	    		}
	    	}    		
    	}
    	return (l);
    }
    
}
