package es.uc3m.g3.queue;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadMessageListenerServlet
 */
@WebServlet(urlPatterns={"/ReadMessageListenerServlet"})//,loadOnStartup=0)
public class ReadMessageListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Inject the connectionFactory using annotations
	@Resource(mappedName="jms/MainConnectionFactory")
	 private ConnectionFactory tiwconnectionfactory;
	 // Inject the queue using annotations
	@Resource(mappedName="jms/AdminQueue")
	 private Queue queue;
	
	private Connection queueConnection;
	private Session queueSession;
	private EntityManagerFactory factory;
	
	@PersistenceContext(unitName="tiwgrupo3")
	private EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadMessageListenerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig a) throws ServletException{
    	System.out.println("Initializing AdminApp JMS listener...");
    	factory = Persistence.createEntityManagerFactory("tiwgrupo3");
        em = factory.createEntityManager();
    	try {	
			// Create a connection using the connectionFactory
			queueConnection = tiwconnectionfactory.createConnection();
		      // Next create the session. Indicate that transaction will not be supported
			queueSession = queueConnection.createSession(false,javax.jms.QueueSession.AUTO_ACKNOWLEDGE);						
			//Start connection
			queueConnection.start();
			// USe the session to create a consumer
			MessageConsumer consumer = queueSession.createConsumer(queue);
			
			consumer.setMessageListener(new QueueListener(em));
		} catch (Exception e) {
			System.out.println("Error recovering messages");
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void destroy() {
		//Close session and connection
		try{
			queueSession.close();
			queueConnection.close();
		} catch (Exception e) {
			System.out.println("Error closing message session and connection");
			e.printStackTrace();
		}
	}

}
