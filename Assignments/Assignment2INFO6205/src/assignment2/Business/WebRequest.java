/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.Business;

import assignment2.Assignment2View;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TimerTask;
import javax.swing.SwingUtilities;

/**
 *
 * @author bhaVYa
 */
public class WebRequest extends TimerTask{
    int requestCount = 0;
    Cloud_Elasticity elasticity;
   
    Queue<Request> queue = new LinkedList<Request>();        
    Assignment2View mainPanel;
    WebServerPool webServerPool = null;
    public WebRequest(Cloud_Elasticity elasticity, Assignment2View mainPanel) {
        this.elasticity = elasticity;
        this.mainPanel = mainPanel;
        webServerPool = new WebServerPool(mainPanel);
    }        
    
    @Override
    public void run() {
        Request request = new Request();
        queue.add(request);
        System.out.println(request.getRequestName() + " received");
        dispatchRequest(queue); 
    }
    
    void dispatchRequest(Queue<Request> q) {
        if(webServerPool.isServerPoolEmpty()) {
            WebServer webServer = webServerPool.addWebServer();
            webServer.addRequestToServer(q.poll(), elasticity.getProcessTime());
            webServer.start();
            return;
        }
        
        for(final WebServer ws: webServerPool.getWebServerPool()) {
            if(ws.queueSize()< elasticity.getServerCapacity()) {
                ws.addRequestToServer(q.poll(), elasticity.getProcessTime());                
                return;
            }
        }
        
        
        WebServer webServer = webServerPool.addWebServer();
        webServer.addRequestToServer(q.poll(), elasticity.getProcessTime());
        webServer.start();
    }
    
}
