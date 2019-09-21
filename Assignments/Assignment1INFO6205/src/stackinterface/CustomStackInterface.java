/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackinterface;

/**
 *
 * @author bhaVYa
 */
public interface CustomStackInterface {
    public boolean push(String i);
    public String pop() throws Exception;
    public String peek() throws Exception;
    public int size();
    public boolean isEmpty();
}
