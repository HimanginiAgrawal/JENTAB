import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.IDs;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Avleen Singh Khanuja
 */
@WebServlet(urlPatterns = {"/viewFriends"})
public class ViewFriends extends HttpServlet 
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
        String twt_name;
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

            twt_name = twt.getScreenName();

            IDs followerIDs = twt.getFollowersIDs(twt_name, -1);
            long[] t_ids = followerIDs.getIDs();
            for (long id : t_ids) 
            {
                twitter4j.User usr = twt.showUser(id);
                String userScreenName = usr.getScreenName();
                out.print("Name: " + usr.getScreenName());

                IDs followerIDsOfFollowers = twt.getFollowersIDs(usr.getScreenName(), -1);
                long[] fofIDs = followerIDsOfFollowers.getIDs();
                for (long subId : fofIDs) 
                {
                    twitter4j.User usr1 = twt.showUser(subId);
                    out.print("<br>Follower Master:    " + userScreenName + "      Follower of Follower Name:        " + usr1.getScreenName()+"<br>");
                }
            }
        } 
        
        catch (TwitterException ex) 
        {
            Logger.getLogger(ViewFriends.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IllegalStateException ex) 
        {
            Logger.getLogger(ViewFriends.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
