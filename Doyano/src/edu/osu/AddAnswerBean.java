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
import examples.cse769.EJB.Service.PostAnswer;

/**
 * @author Reddiah
 * @edited by Minjia
 *
 */
public class AddAnswerBean
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

	private String answer;
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@EJB
	private PostAnswer postAnswer;

	public String addAnswer() {
		

		//String aid = welBean.getAid();
		
		if (answer == "") {
			return "false";
		}
		System.out.println("AddAnswerBean aid:" + aid + " answer:" + answer);
		//FIXME: 
		String results = postAnswer.postAnswer(aid, answer, logBean.getName());
		 
		//String[] results = helloService.search(title, location);//position String non array hmmmmm
		
		
		 //System.setProperty("log4j.debug", "");
		
		 //initializeLog4j("log4j.properties");
		 
	    // PropertyConfigurator.configure("log5j.properties");

		  //final Logger log = Logger.getRootLogger();

		   //Logger log1 = Logger.getLogger(ApplyBean.class.getName());//static
		  
		   //Logger log2 = LogFactory.getLogger(WelcomeBean.class.getName());//static

		 //final Logger log2 = Logger.getLogger()//static
		 /*log1.warn("warn");
		 log1.debug("debug");
		 log1.info("info");
		 log1.error("error");
		 log1.fatal("fatal");

		 log.info("Hello this is an info message Dingry");

		 log.warn("Hello this is an warn message Dingry");
		 log.debug("Hello this is an debug message Dingry");
		 log.trace("Trace Message!");
	      log.error("Error Message!");
	      log.fatal("Fatal Message!");

	     // log.setLevel(Level.WARN);
	     log.info("Hello this is an info message Dingry");*/
		
	    //BasicConfigurator.configure(); chk later

	
		//String[] results = helloService.search(title, location);//position String non array hmmmmm
		
		//FIXME:
		if(results.equalsIgnoreCase("no"))
			return "false";
		
		else
		{
			return "true";		
		}


	}
}
