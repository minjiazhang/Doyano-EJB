package examples.cse769.EJB.Entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "POSTLISTING")
public class PostListingEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="POSTID")
	private long postId;
	
	public long getPostId(){
		return this.postId;
	}
	public void setPostId(long postId){
		this.postId = postId;
	}
	
	
	@Column(name="TITLE")
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="QUESTION")
	private String question;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name="CATEGORY")
	private String category;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}


	@Column(name="USER")
	private String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	
}
