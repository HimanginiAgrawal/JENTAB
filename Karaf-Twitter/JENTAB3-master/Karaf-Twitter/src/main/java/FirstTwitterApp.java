import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.conf.ConfigurationBuilder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.TwitterFactory;
import twitter4j.Status;
import twitter4j.TwitterException;


/**
 *
 * @author Avleen Singh Khanuja
 */
@WebServlet(urlPatterns = {"/FirstTwitterApp"})
public class FirstTwitterApp extends HttpServlet {
    private boolean[] $_GET;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws twitter4j.TwitterException
     */
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        ConfigurationBuilder cf= new ConfigurationBuilder();
        
        ConfigurationBuilder confg_b= new ConfigurationBuilder();
        
         confg_b.setDebugEnabled(true)
            .setOAuthConsumerKey("7d3syEvuKlbdDprpOkAOF7Th7")
            .setOAuthConsumerSecret("scgsHKgsnZoRI2dbX8ubsOdRfEfS436gqNbADWkB5eoQULg0gs")
            .setOAuthAccessToken("917203328647413760-Z4TPcjRBugMTt8CKfDmtIKu4W8CGmdC")
            .setOAuthAccessTokenSecret("SaGRwiFZ5OY0Kvl14B6oEBs8snND4UBWuFaPjRgtk09g9");
        
        TwitterFactory twit_fact= new TwitterFactory(confg_b.build());
        twitter4j.Twitter twt= twit_fact.getInstance();
        
    List<Status> stt=twt.getHomeTimeline();
        for(Status st: stt)
        {
            String stname= request.getParameter("VIEW");
           out.print("<br>"+st.getUser().getName()+st.getText()+"<br>");
        }
        
    }   
        catch (TwitterException e) 
        {
            Logger.getLogger(FirstTwitterApp.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

