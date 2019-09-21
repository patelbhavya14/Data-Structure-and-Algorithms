/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205;

/**
 *
 * @author bhaVYa
 */
public class Input {

    int a = 0;

    public static void main(String[] args) {
        byte byteDataType = 127;
        short shortDataType = 128;
        int intDataType = 32768;// longDataType
        long longDataType = 2147483648L;
        float floatDataType = 20.99F;
        double doubleDataType = 49999999.9d;
        char charDataType = 'M';
        boolean booleanDataType = true;
        System.out.println(byteDataType);
        System.out.println(shortDataType);
        System.out.println(intDataType);
        System.out.println("hello" + longDataType + "123" + intDataType);
        System.out.println(floatDataType);
        System.out.println(doubleDataType);
        System.out.println(charDataType);
        System.out.println(booleanDataType);
        
    }

    public void function1() {
        System.out.println("here we go" + a + "hello world");
    }

    void ab() {
    }
}
