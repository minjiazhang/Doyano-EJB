package examples.cse769.EJB.Service;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class UserService {
	@PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
    
//    private static Logger logger = Logger.getLogger("examples.cse769.EJB.Service.UserService");
//    private static FileHandler fh;
//
//	public String addUser(String title, String location, String pay, String technology, String user) {
//		
//		String[] params = new String[5];
//		params[0] = title;
//		params[1] = location;
//		params[2] = pay;
//		params[3] = technology;
//		params[4] = user;
//	    try {
//	 	  if(fh == null)
//	 	  fh = new FileHandler("final.txt");
//	 	  fh.setFormatter(new SimpleFormatter());
//	      		logger.addHandler(fh);
//	     	 	logger.setLevel(Level.ALL);
//	      		logger.entering("AddJob", "addJob", params);
//	 	   }
//	 	catch (IOException e) {
//			e.printStackTrace();
//		}		
//		
//		PostListingEntity newEntity = new PostListingEntity();
//
//		newEntity.setTitle(title);
//		newEntity.setLocation(location);
//		newEntity.setPay(pay);
//		newEntity.setTechnology(technology);
//		newEntity.setUser(user);
//
//		  logger.exiting("AddJob", "addJob", "true");
//
//		
//		try
//		{
//		em.persist(newEntity);
//		em.flush();
//		}
//		catch(EntityExistsException e)
//		{
//			return "Exists";
//		}
//		
//		catch(ConstraintViolationException e)
//		{
//			return "Exists";
//		}
//		
//		catch(Exception e)
//		{
//			return "Exists";
//		}
//		//String UserName = newEntity.getUserName();
//		//return "JobPortal" + "Name =" + UserName;
//		return "true";
//	}
}
