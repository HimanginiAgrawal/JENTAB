import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Avleen Singh Khanuja
 */
@WebServlet(urlPatterns = {"/Retweet"})
public class Retweet extends HttpServlet 
{
    private boolean[] $_GET;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        long twt_Id = 923776149821341697L;			// Enter Tweet ID here
        
        twt.retweetStatus(twt_Id);
        String stname= request.getParameter("GO");
        out.print("<h1><b>Retweeted the Tweet Successfully!</b></h1>");
        
        }
        
        catch (TwitterException e) {
            Logger.getLogger(Retweet.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}