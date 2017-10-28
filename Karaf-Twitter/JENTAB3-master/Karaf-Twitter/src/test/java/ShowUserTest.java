/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.Test;
import javax.servlet.http.*;
import junit.framework.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import twitter4j.TwitterException;
/**
 *
 * @author Himangini
 */
@RunWith(MockitoJUnitRunner.class)
public class ShowUserTest extends Mockito {
    
    @Mock
    ShowUser showUserMock;
    
    @Test
    public void test() throws ServletException, IOException{
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class); 
        ShowUser showUserMock = Mockito.mock(ShowUser.class);
        doNothing().when(showUserMock).doGet(request, response);
//        try {
//            showUserMock.doGet(request, response);
//        } catch(Exception e) {
//            Assert.fail("fail");
//        }
    }
  
}
