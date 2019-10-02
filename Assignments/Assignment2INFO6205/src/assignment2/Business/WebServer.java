/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.Business;

import assignment2.Assignment2View;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;

/**
 *
 * @author thakk
 */
public class WebServer extends Thread {
    int processingTime = 1;
    Queue<Request> webServerQueue = new LinkedList<Request>();
    String serverName = "";
    int flag = 1;
    int serverCount = 0;

    Assignment2View mainPanel;

    public WebServer(String serverName, Assignment2View mainPanel) {
        super(serverName);
        this.serverName = serverName;
        this.mainPanel = mainPanel;
    }



    public int getTime() {
        return processingTime;
    }

    public void setTime(int time) {
        this.processingTime = time;
    }

    public Queue<Request> getQ() {
        return webServerQueue;
    }

    public void setQ(Queue<Request> q) {
        this.webServerQueue = q;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String name) {
        this.serverName = name;
    }

    public int getServerCount() {
        return serverCount;
    }

    public void setServerCount(int serverCount) {
        this.serverCount = serverCount;
    }

    
    public void addRequestToServer(final Request element, int time) {

        try {

            this.processingTime = time;
            webServerQueue.add(element);
            
            // Runs inside of the Swing UI thread
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    mainPanel.setProgressValue(serverName, webServerQueue.size());
                    mainPanel.addHistoryTableRow(element.getRequestName(), serverName, "Processing", "");
//                        System.out.println("queue size in "+ serverName +": " + queueSize());
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int queueSize() {
        return webServerQueue.size();
    }

    @Override
    public void run() {
//        serverName = currentThread().getName();
        while (true) {
            final Request webRequest = webServerQueue.poll();
            try {
                Thread.sleep(this.processingTime * 1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }            
            if (webRequest != null) {
                
                webRequest.setEndTime(System.currentTimeMillis());
                System.out.println(webRequest.getRequestName()+" is processed in " + serverName +" & Processing Time: "+ webRequest.getResponseTime());
                
                // Runs inside of the Swing UI thread
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        mainPanel.setProgressValue(serverName, webServerQueue.size());
                        mainPanel.updateHistoryTableRow(webRequest.getRequestName(), serverName, "Done", webRequest.getResponseTime()+"");
    //                    System.out.println("queue size in "+ name +": " + q.size());
                    }
                });
            }
        }
    }
}
