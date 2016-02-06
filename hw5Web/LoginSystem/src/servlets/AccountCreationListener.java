package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.AccountManager;

/**
 * Application Lifecycle Listener implementation class AccountCreationListener
 *
 */
@WebListener
public class AccountCreationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AccountCreationListener() {
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         AccountManager accountManager = new AccountManager();
         ServletContext sc = sce.getServletContext();
         sc.setAttribute(AccountManager.ATTRIBUTE_NAME, accountManager);
    }
	
}
