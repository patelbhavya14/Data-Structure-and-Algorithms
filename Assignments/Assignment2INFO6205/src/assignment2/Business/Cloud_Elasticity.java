/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.Business;

/**
 *
 * @author thakk
 */
public class Cloud_Elasticity {
    
    int requestRate,serverCapacity,processTime;

    public Cloud_Elasticity(int requestRate, int serverCapacity, int processTime) {
        this.requestRate = requestRate;
        this.serverCapacity = serverCapacity;
        this.processTime = processTime;
    }

    public int getRequestRate() {
        return requestRate;
    }

    public void setRequestRate(int requestRate) {
        this.requestRate = requestRate;
    }

    public int getServerCapacity() {
        return serverCapacity;
    }

    public void setServerCapacity(int serverCapacity) {
        this.serverCapacity = serverCapacity;
    }

    public int getProcessTime() {
        return processTime;
    }

    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }

    
    
    
}
