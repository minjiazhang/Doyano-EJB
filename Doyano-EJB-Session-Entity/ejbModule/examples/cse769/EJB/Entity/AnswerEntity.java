package examples.cse769.EJB.Entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "ANSWERTABLE")
public class AnswerEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ANSWERID")
	private long answerId;
	
	public long getAnswerId(){
		return this.answerId;
	}
	public void setAnswerId(long ansnId){
		this.answerId = ansnId;
	}
	
	
	@Column(name="POSTID")
	private String postId;
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}

	@Column(name="ANSWER")
	private String answer;
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
