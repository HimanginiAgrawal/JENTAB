import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Avleen Singh Khanuja
 */
@WebServlet(urlPatterns = {"/DirectMessage"})
public class DirectMessage extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            ConfigurationBuilder confg_b= new ConfigurationBuilder();
        
         confg_b.setDebugEnabled(true)
            .setOAuthConsumerKey("7d3syEvuKlbdDprpOkAOF7Th7")
            .setOAuthConsumerSecret("scgsHKgsnZoRI2dbX8ubsOdRfEfS436gqNbADWkB5eoQULg0gs")
            .setOAuthAccessToken("917203328647413760-Z4TPcjRBugMTt8CKfDmtIKu4W8CGmdC")
            .setOAuthAccessTokenSecret("SaGRwiFZ5OY0Kvl14B6oEBs8snND4UBWuFaPjRgtk09g9");
        
        TwitterFactory twit_fact= new TwitterFactory(confg_b.build());
        twitter4j.Twitter twt= twit_fact.getInstance();
        String id="Enter Twitter ID of your Friend whom you want to send a Direct Message";
        String msg="Enter the message here";
        DirectMessage message;
        
        
            twitter4j.DirectMessage msg1 = twt.sendDirectMessage(id, msg);
            out.print("<h1>Direct message successfully sent to:<h1>                        " + id);
        }
        
        catch (TwitterException e) 
        {
            e.printStackTrace();
            System.out.println("Failed to send a direct message: " + e.getMessage());
        }


}
}
