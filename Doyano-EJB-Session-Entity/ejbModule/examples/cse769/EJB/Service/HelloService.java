package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class HelloService {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public String userName(String name, String password, String type) {
		HelloServiceEntity newEntity = new HelloServiceEntity();
		

		newEntity.setUserName(name);
		newEntity.setPassword(password);
		newEntity.setType(type);
		newEntity.setExpertise("");


		try
		{
		em.persist(newEntity);
		em.flush();
		}
		catch(EntityExistsException e)
		{
			return "Exists";
		}
		
		catch(ConstraintViolationException e)
		{
			return "Exists";
		}
		
		catch(Exception e)
		{
			return "Exists";
		}
		String UserName = newEntity.getUserName();
		return "Doyano " + "Name =" + UserName;
	}
	
	
	public String[] search(String userName) {	//change	
		 String[] results = new String[1];

		 String expertise = "";
		 
		List<HelloServiceEntity> ann;
		Query query = em.createNativeQuery
				("select * from UserTable where USERNAME like '" + userName + "'" , 
						HelloServiceEntity.class);
		ann = query.getResultList();
		if(!ann.isEmpty())
		{
		HelloServiceEntity hse = new HelloServiceEntity();
		hse = ann.get(0);
		
		 expertise = hse.getExpertise();
		 //return un;

		
		results[0] = expertise;

		return results;

		
		}
		
		else 
			{
			results[0] = "no";//change
			return results;

			}
	}
	
	
	
	public String update(String user, String expertise) {
		
		
		List<HelloServiceEntity> ann;
		Query query = em.createNativeQuery
				("update UserTable set expertise = " + "'" + expertise + "'" +
									 " where username like "  + "'" + user + "'"
						, HelloServiceEntity.class);
		
		try
		{
		query.executeUpdate();
		em.flush();

		}
		catch(Exception e)
		{
			return "fail";
		}
		
		return "success";
	
	}
	
	public List<List<String>> findUser(String expertise) 	
	{
		 List<List<String>> users = new ArrayList<List<String>>();
		 String userName = "";
		 String queryString = "select * from UserTable where expertise like '" + expertise + "'";
		 
		List<HelloServiceEntity> userList;
		Query query = em.createNativeQuery(queryString	, HelloServiceEntity.class);
		userList = query.getResultList();
		if(!userList.isEmpty())
		{
			int size = userList.size();
			
			for(int i = 0; i< size ; i++)
			{
				HelloServiceEntity hse = new HelloServiceEntity();
				hse = userList.get(i);
			
			expertise = hse.getExpertise();
			userName = hse.getUserName();
			List<String> user = new ArrayList<String>();

			user.add(userName);
			user.add(expertise);
			
			users.add(user);
			}
			
			return users;
		
		}
		else return users;
	}
	
	
}
