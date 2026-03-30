package org.testleaf.week4day1assignment.Abstraction;

public abstract class MySqlConnection implements DatabaseConnection{

    public void executeQuery(){
        System.out.println("Execute Query");
    }

}
