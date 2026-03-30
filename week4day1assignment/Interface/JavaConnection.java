package org.testleaf.week4day1assignment.Interface;

public class JavaConnection implements DatabseConnection {

    public void connect(){
        System.out.println("Print Connect");
    }

    public void disconnect(){
        System.out.println("Print Disconnect");
    }

    public void executeUpdate(){
        System.out.println("Print Execute Update");
    }

    public static void main(String[] args) {

        JavaConnection obj =  new JavaConnection();
        obj.connect();
        obj.disconnect();
        obj.executeUpdate();
        
    }

}
