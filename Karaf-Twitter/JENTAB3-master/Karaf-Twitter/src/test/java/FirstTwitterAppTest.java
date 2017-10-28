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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import org.mockito.runners.MockitoJUnitRunner;
import twitter4j.TwitterException;

/**
 *
 * @author Himangini
 */
@RunWith(MockitoJUnitRunner.class)
public class FirstTwitterAppTest extends Mockito{
    
    @Mock
    FirstTwitterApp firstTwitterAppMock;

    @Test
    public void FirstTwitterApp() throws ServletException, IOException{
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class); 
        FirstTwitterApp firstTwitterAppMock = Mockito.mock(FirstTwitterApp.class);
        doNothing().when(firstTwitterAppMock).doGet(request, response);
//        try {
//            firstTwitterAppMock.doGet(request, response);
//        } catch(Exception e) {
//            Assert.fail("fail");
//        }
    }
}