package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class PostListing {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public List<List<String>> findPost(String title, String category) {
		PostListingEntity newEntity = new PostListingEntity();
		
		List<List<String>> posts = new ArrayList<List<String>>();
		long aidNbr;
		String aid = "";
		String question;
		String questioner;
		List<PostListingEntity> postListing;
		
		Query query;
		if (title != "") { // specific question. //Should we use contain instead of 'like'?
			query = em.createNativeQuery
					("select * from POSTLISTING where TITLE like '" + title
							+ "'" + " AND CATEGORY like '" + category + "'", PostListingEntity.class);
		} else { // general category posts.
			query = em.createNativeQuery
					("select * from POSTLISTING where CATEGORY like '" + category
							+ "'", PostListingEntity.class);
		}
		
		postListing = query.getResultList();
		if(!postListing.isEmpty())
		{
			int size = postListing.size();
			
			for(int i = 0; i< size ; i++)
			{
			PostListingEntity jle = new PostListingEntity();
			jle = postListing.get(i);
			
			title = jle.getTitle();
			question = jle.getQuestion();
			category = jle.getCategory();
			questioner = jle.getUser();
			aidNbr = jle.getPostId();
			aid = String.valueOf(aidNbr);

			List<String> post = new ArrayList<String>();

			post.add(title);
			post.add(question);
			post.add(category);
			post.add(questioner);
			post.add(aid);
			
			posts.add(post);
			}
			
			return posts;
		
		}
		
		else return posts;
	}
}
