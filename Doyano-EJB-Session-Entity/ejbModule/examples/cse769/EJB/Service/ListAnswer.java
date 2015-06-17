package examples.cse769.EJB.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

import java.util.logging.*;


@Stateless
public class ListAnswer {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
    
	public List<List<String>> listAnswer(String postId)
	{
		List<List<String>> answers = new ArrayList<List<String>>();


		 String answer = "";
		 String user = "";
		 
		List<AnswerEntity> anslist;
		Query query = em.createNativeQuery
				("select * from ANSWERTABLE where POSTID like '" + postId + "'" , 
						AnswerEntity.class);
		anslist = query.getResultList();
		if(!anslist.isEmpty())
		{
			int size = anslist.size();
			
			for (int i = 0; i < size; i++) {
				AnswerEntity anse;
				anse = anslist.get(i);
				answer = anse.getAnswer();
				user = anse.getUser();
				
				List<String> singleAnswer = new ArrayList<String>();
				
				singleAnswer.add(answer);
				singleAnswer.add(user);
				singleAnswer.add(postId);
				answers.add(singleAnswer);
			}

			return answers;

		
		}
		
		else return answers;
	
	}
}
