package es.uc3m.g3.queue;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;


/**
 * Servlet implementation class SendMessageQueueServlet
 */
@WebServlet(urlPatterns = {"/SendMessageQueue"})
public class SendMessageQueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 // Inject the connectionFactory using annotations
	@Resource(mappedName="jms/MainConnectionFactory")
	 private ConnectionFactory tiwconnectionfactory;
	 // Inject the queue using annotations
	@Resource(mappedName="jms/queue")
	 private Queue queue;
	 
	 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageQueueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

			
	public void doPost(
			javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Sending message to a queue</title></head>");
			out.println("<body>");
			out.println("<H1><U>Sending the message</U></H1>");
			

			try {

				
				// - In the following steps we write the message and send it				
				// First create a connection using the connectionFactory
				Connection queueConnection = tiwconnectionfactory.createConnection();
			      // Next create the session. Indicate that transaction will not be supported
				Session queueSession = queueConnection.createSession(false,javax.jms.QueueSession.AUTO_ACKNOWLEDGE);	
				// Now use the session to create a message producer associated to the queue
				MessageProducer producer = queueSession.createProducer(queue);
				 // Now use the session to create a text message
				TextMessage message = queueSession.createTextMessage();
				//  We retrieve the parameter 'message' from the request, and use it as text of our message
				message.setText(request.getParameter("message"));
				
				message.setStringProperty("conversationId", request.getParameter("conversationId"));
				message.setStringProperty("sendBy", request.getParameter("sender"));
				message.setLongProperty("timestamp", new Date().getTime());
				// Use the message producer to send the message
				producer.send(message);

				// Close the producer
				producer.close();
				// Close the session 
				queueSession.close();
				// Close the connection 
				queueConnection.close();
				out.println(" Menssage sent </BR>");

			} catch (javax.jms.JMSException e) {
				System.out.println(
					"JHC *************************************** Error in doPost: "
						+ e);
				System.out.println(
					"JHC *************************************** Error MQ: "
						+ e.getLinkedException().getMessage());
				System.out.println(
					"JHC *************************************** Error MQ: "
						+ e.getLinkedException().toString());		
				out.println(" Error when sending the message</BR>");
		
				
			}catch (Exception e) {
				System.out.println(
					"JHC *************************************** Error in doPost: "
						+ e.toString());
				out.println(" Error when sending the message</BR>");
				
			}
			
			out.println(
			" >>>>>>  <A href=\"messages.jsp\">Back</A></P>");
			out.println("</body></html>");
		}

				public void doGet(
					javax.servlet.http.HttpServletRequest request,
					javax.servlet.http.HttpServletResponse response)
					throws javax.servlet.ServletException, java.io.IOException {

					try {
						//Llamamos al m�todo doPost con los parametros que recibe este m�todo
						doPost(request, response);
					} catch (Exception e) {
						System.out.println(
							"JHC ***************************************Error in doGet: "
								+ e);
					}

				}

}
