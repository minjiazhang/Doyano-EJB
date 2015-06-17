package examples.cse769.EJB.Entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "USERTABLE")
public class HelloServiceEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USERID")
	private long userId;
	
	public long getUserId(){
		return this.userId;
	}
	public void setUserId(long postId){
		this.userId = postId;
	}
	
	
	@Column(name="USERNAME")
	private String userName;
	public String getUserName() {return userName;}

	public void setUserName(String userName) { this.userName = userName;}
	
	
	@Column(name="PASSWORD")
	private String password;
	public String getPassword() {return password;}

	public void setPassword(String password) { this.password = password;}
	
	@Column(name="TYPE")
	private String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
//	@Column(name="QUESTION")
//	private String question;
//
//	public String getQuestion() {
//		return question;
//	}
//	public void setQuestion(String question) {
//		this.question = question;
//	}

	
	@Column(name="EXPERTISE")
	private String expertise;
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

}
