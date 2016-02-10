package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.DataManager;

/**
 * Application Lifecycle Listener implementation class DataManagerListener
 *
 */
@WebListener
public class DataManagerListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DataManagerListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext context = sce.getServletContext();
         context.setAttribute(DataManager.ATTRIBUTE_NAME, new DataManager());
    }
	
}
