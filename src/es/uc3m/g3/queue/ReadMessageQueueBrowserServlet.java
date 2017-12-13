package es.uc3m.g3.queue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadMessageQueueBrowserServlet
 */
@WebServlet(urlPatterns={"/ReadMessageQueueBrowser.html"},loadOnStartup=0)
public class ReadMessageQueueBrowserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 // Inject the connectionFactory using annotations
	 @Resource(mappedName="jms/MainConnectionFactory")
	 private ConnectionFactory tiwconnectionfactory;
	 // Inject the queue using annotations
	 @Resource(mappedName="jms/AdminQueue")
	 private Queue queue;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadMessageQueueBrowserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			doPost(request, response);
		} catch (Exception e) {
			System.out.println(
				"JHC ***************************************Error in doGet: "
					+ e);
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println(
			"<head><title>An example on how to read messages in browser mode</title></head>");
		out.println("<body>");
		out.println("<H1><U>Reading a message in browser mode</U></H1>");


		try {

			// Create a connection using the connectionFactory
			Connection queueConnection = tiwconnectionfactory.createConnection();
		      // Next create the session. Indicate that transaction will not be supported
			Session queueSession = queueConnection.createSession(false,javax.jms.QueueSession.AUTO_ACKNOWLEDGE);	
		 			   
			// USe the session to create a browser associated to the queue
			QueueBrowser browser = queueSession.createBrowser(queue);
			//Start the connection
			queueConnection.start();
			// User the browser to retrieve a collection (enumeration) of messages
			java.util.Enumeration enum1 = browser.getEnumeration();
			while (enum1.hasMoreElements()) {
				// Get a message from the enumeration
				Object mensaje = enum1.nextElement();
				
				// Check if the message is an instance of TextMessage
				if(mensaje instanceof TextMessage){
					// If it is an instance of TextMessage, cast it and add it to the out
					out.println(((TextMessage) mensaje).getText());
				}
			}
			// Stop connection
			queueConnection.stop();
			// Close browser
			browser.close();
			// Close session
			queueSession.close();
			// Close connection
			queueConnection.close();
		} catch (Exception e) {
			System.out.println(
				"JHC *************************************** Error in doPost: "
					+ e);
		}

		out.println(
			" >>>>>>  <A href=\"messages.jsp\">Back</A></P>");
		out.println("</body></html>");
	}


}
