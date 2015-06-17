package examples.cse769.EJB.Service;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class PostAnswer {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public String postAnswer( String aid, String answer, String user) {
		
		
		//String user = ""; //set user name too later
//		String postTitle = "";
//		String postQuestin = "";
//		List<PostListingEntity> postList;
//		Query query = em.createNativeQuery
//				("select * from POSTLISTING where POSTID like '" + aid
//						+ "'" , PostListingEntity.class);
//
//		postList = query.getResultList();
//		if(!postList.isEmpty())
//		{
//			PostListingEntity jle = new PostListingEntity();
//			jle = postList.get(0);//change to take care of multiple posts, is it possible?
//			
//			postTitle = jle.getTitle();
//			postQuestin = jle.getQuestion();
//			//user = jle.getUser();
//		}
		
		 
		 	AnswerEntity newEntity = new AnswerEntity();
			
			newEntity.setPostId(aid);
			newEntity.setAnswer(answer);
			newEntity.setUser(user);
			
			try
			{
				em.persist(newEntity);		
			}
			
			catch(EntityExistsException e)
			{
				return "no";
			}
			
			return "Success";
	}
}
