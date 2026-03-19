package org.testleaf.week3day2assignment;

public class APIClient {

    // Method 1: Single parameter
    public void sendRequest(String Endpoint){
        System.out.println("Sending request to endpoint: " + Endpoint);
    }
    
    // Method 2: Three parameters
    public void sendRequest(String Endpoint, String requestBody, boolean requestStatus){
        System.out.println("Sending request to endpoint: " + Endpoint);
        System.out.println("Sending request to endpoint: " + requestBody);
        System.out.println("Sending request to endpoint: " + requestStatus);
    }

    public static void main(String[] args) {
        //create an object of the APIClient class
        APIClient api = new APIClient();

        //Call both versions of the sendRequest method with different sets of input arguments
        api.sendRequest("users");
        System.out.println("------");
        api.sendRequest("login", "{username: admin}", true);

    }
}
