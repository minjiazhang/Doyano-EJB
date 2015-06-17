package examples.cse769.EJB.Service;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;
import javax.ejb.Stateless;
import java.util.logging.*;


@Stateless
public class AddPost {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
    
    private static Logger logger = Logger.getLogger("examples.cse769.EJB.Service.AddPost");
    private static FileHandler fh;

	public String addPost(String title, String question, String category, String user) {
		
		String[] params = new String[4];
		params[0] = title;
		params[1] = question;
		params[2] = category;
		params[3] = user;
	    try {
	 	  if(fh == null)
	 	  fh = new FileHandler("final.txt");
	 	  fh.setFormatter(new SimpleFormatter());
	      		logger.addHandler(fh);
	     	 	logger.setLevel(Level.ALL);
	      		logger.entering("AddPost", "addPost", params);
	 	   }
	 	catch (IOException e) {
			e.printStackTrace();
		}		
		
		PostListingEntity newEntity = new PostListingEntity();

		newEntity.setTitle(title);
		newEntity.setQuestion(question);
		newEntity.setCategory(category);
		newEntity.setUser(user);

		  logger.exiting("AddPost", "addpost", "true");

		
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
		//String UserName = newEntity.getUserName();
		//return "JobPortal" + "Name =" + UserName;
		return "true";
	}
}
