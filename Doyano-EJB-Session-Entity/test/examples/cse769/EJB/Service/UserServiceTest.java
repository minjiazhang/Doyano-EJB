package examples.cse769.EJB.Service;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

//	private static EJBContainer ec;
//	private static Context ctx;
	
//	@Mock
//	private EntityManager mockedEntityManager;
	
	private UserService userService;
	
	@Before
	public void inti() throws Exception {
//		Hashtable props = new Hashtable();
//		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.openejb.client.RemoteInitialContextFactory");
//		props.put(Context.PROVIDER_URL, "http://localhost:8080/"); //Problematic, know how to set this value and what does it mean.
//		Context ctx = new InitialContext(props);
//		userService = (UserService)ctx.lookup("UserService");
		
//		Map props = new HashMap();
//		props.put(EJBContainer.APP_NAME, "Doyano-EJB-Session-Entity");
//		ec = EJBContainer.createEJBContainer(props);
//		ctx = ec.getContext();
		
//		userService = new UserService();
//		Map properties = new HashMap();
//        properties.put(EJBContainer.MODULES, new File[]{new File("target/classes"), new File("target/test-classes")});
//        ec = EJBContainer.createEJBContainer(properties);
//        ctx = ec.getContext();
		
//		Properties props = new Properties();
//		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
//		props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
//		props.setProperty("javax.naming.provider.url", "jnp://localhost:1099"); 
//		InitialContext ctx = new InitialContext(props);
//		userService = (UserService)ctx.lookup("Doyano-EJB-Session-Entity/UserService!examples.cse769.EJB.Service.UserService");
		
		Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        Context context = new InitialContext(props);
//        userService = (UserService) context.lookup("UserService");

	}
	
	@AfterClass
	public static void closeContainer() throws Exception {
//		if (ec != null) {
//			ec.close();
//		}
	}
	
	@Test
	public void test() throws Exception {
//		userService = (UserService)ctx.lookup("java:global/UserEntity");
//		userService.createHelloMessage("1");
//		fail("Not yet implemented");
	}

}
