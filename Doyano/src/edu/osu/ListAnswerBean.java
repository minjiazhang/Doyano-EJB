/**
 * 
 */
package edu.osu;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import edu.osu.WelcomeBean;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

import examples.cse769.EJB.Service.HelloService;
import examples.cse769.EJB.Service.ListAnswer;

/**
 * @author Reddiah
 * @edited by Minjia
 *
 */
public class ListAnswerBean
{
	
	private String aid;

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	private LoginBean logBean;
	public LoginBean getLogBean() {
		return logBean;
	}

	public void setLogBean(LoginBean logBean) {
		this.logBean = logBean;
	}

	private WelcomeBean welBean;

	public WelcomeBean getWelBean() {
		return welBean;
	}

	public void setWelBean(WelcomeBean welBean) {
		this.welBean = welBean;
	}

	
	private List<List<String>> answers = new ArrayList<List<String>>();
	public List<List<String>> getAnswers() {
		return answers;
	}

	public void setAnswers(List<List<String>> answers) {
		this.answers = answers;
	}
	
	@EJB
	private ListAnswer listAnswer;
	 
	public String listAnswer() {
		

		//String aid = welBean.getAid();
		
		//FIXME:
		System.out.println("aid:" + aid);
		answers = listAnswer.listAnswer(aid);
		
		System.out.println("ListAnswerBean:" + " answers:" + answers);
		
		if(answers.isEmpty())
			return "false";
		
		else
		{return "true";}
//		return "false";


	}
	
}
