/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.Business;

import assignment2.Assignment2View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhaVYa
 */
public class WebServerPool {
    private List<WebServer> webServerPool;
    int serverCount = 0;
    
    Assignment2View mainPanel;
            
    WebServerPool(Assignment2View mainPanel) {
        webServerPool = new ArrayList<WebServer>();
        this.mainPanel = mainPanel;
    }

    public List<WebServer> getWebServerPool() {
        return webServerPool;
    }
    
    public WebServer addWebServer() {
        serverCount++;
        WebServer newWebServer = new WebServer("Server-"+serverCount, mainPanel);
        webServerPool.add(newWebServer);
        mainPanel.addTableRow("Server-"+serverCount);
        return newWebServer;
    }
   
    public int getServerSize() {
        return this.webServerPool.size();
    }
    
    public boolean isServerPoolEmpty() {
        return webServerPool.isEmpty();
    }
}
