package org.enterprise.client;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mexicacode.enterprisebeans.IMessageEnterprise;
import com.mexicacode.enterprisebeans.MessageEnterprise;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	invokeRemoteMessage();
    }
    
    private static void invokeRemoteMessage() {
    	try {
			IMessageEnterprise ime = lookupMessageEnterprise();
			System.out.println(ime.mesage());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

		
	
	private static IMessageEnterprise lookupMessageEnterprise() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.URL_PKG_PREFIXES,"org.wildfly.naming");
		jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
        final Context context = new InitialContext(jndiProperties);
        final String appName = "";
        // This is the module name of the deployed EJBs on the server. This is typically the jar name of the
        // EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
        // In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
        // jboss-as-ejb-remote-app
        final String moduleName = "enterprise-backend-1.0.0";
        // AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
        // our EJB deployment, so this is an empty string
        final String distinctName = "";
        // The EJB name which by default is the simple class name of the bean implementation class
        final String beanName = MessageEnterprise.class.getSimpleName();
        // the remote view fully qualified class name
        final String viewClassName = IMessageEnterprise.class.getName();
        // let's do the lookup
        return (IMessageEnterprise) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);

	}
}
