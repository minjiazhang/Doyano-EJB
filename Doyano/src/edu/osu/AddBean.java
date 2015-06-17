/**
 * 
 */
package edu.osu;

import javax.ejb.EJB;

import examples.cse769.EJB.Service.AddPost;
import examples.cse769.EJB.Service.HelloService;

import java.io.IOException;
import java.util.logging.*;


/**
 * @author Reddiah
 * @Edited by Minjia 
 */
public class AddBean
{
	private static Logger logger = Logger.getLogger("edu.osu.AddBean");
	private static FileHandler fh;
	
	private LoginBean logBean;
	public LoginBean getLogBean() {
		return logBean;
	}


	public void setLogBean(LoginBean logBean) {
		this.logBean = logBean;
	}


	@EJB 
	private AddPost addPost;
    
	private String title;
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
    private String question;
    public String getQuestion() {
    	return question;
    }
    public void setQuestion(String question) {
    	this.question = question;
    }
    
    private String category;

    public String getCategory() {
    	return category;
    }
    
    public void setCategory(String category) {
    	this.category = category;
    }
    
	public String add() {
		
		String[] params = new String[4];
		params[0] = title;
		params[1] = question;
		params[2] = category;
		params[3] = logBean.getName(); //Suspicious, why can we get logBena instance here?

		try {
			  if(fh == null)
			  fh = new FileHandler("final.txt");
			  fh.setFormatter(new SimpleFormatter());
		  		logger.addHandler(fh);
		 	 	logger.setLevel(Level.ALL);
		  		logger.entering("AddBean", "add", params);
			   }
			catch (IOException e) {
			e.printStackTrace();
		}
	String ret = addPost.addPost(title, question, category, logBean.getName());
	
    logger.exiting("AddBean", "add", ret);

	if(!ret.equalsIgnoreCase("Exists"))
		return "true";
		else 
			return "false";

		
	 //return "false";
	}
	
}
