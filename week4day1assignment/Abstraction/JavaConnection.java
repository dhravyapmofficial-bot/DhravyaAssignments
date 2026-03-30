package org.testleaf.week4day1assignment.Abstraction;

public class JavaConnection extends MySqlConnection{

    public void connect(){
        System.out.println("Connect");
    }

    public void disconnect(){
        System.out.println("Disconnect");
    }

    public void executeUpdate(){
        System.out.println("Execute Update");
    }

    public static void main(String[] args) {

        JavaConnection connections =  new JavaConnection();
        connections.connect();
        connections.disconnect();
        connections.executeUpdate();
        connections.executeQuery();
        
    }


}
