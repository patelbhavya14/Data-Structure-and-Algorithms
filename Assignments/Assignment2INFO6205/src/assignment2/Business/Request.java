/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.Business;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author bhaVYa
 */
public class Request {
    private String requestName;
    private long startTime;
    private long endTime;
    private long responseTime;
    private static int requestCount = 0;
    
    public Request() {
        requestCount++;
        this.requestName = "Request: " + requestCount;
        this.startTime = System.currentTimeMillis();
    }
    
    public String getRequestName() {
        return requestName;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
 
    public long getResponseTime() {
        return TimeUnit.MILLISECONDS.toSeconds((endTime - startTime));
    }
}
