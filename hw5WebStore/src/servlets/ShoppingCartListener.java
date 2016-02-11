package servlets;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.ShoppingCart;

/**
 * Application Lifecycle Listener implementation class ShoppingCartListener
 *
 */
@WebListener
public class ShoppingCartListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ShoppingCartListener() {
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent httpSessionEvent)  { 
    	httpSessionEvent.getSession().setAttribute(ShoppingCart.ATTRIBUTE_NAME, new ShoppingCart());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent)  { 
    }
	
}
