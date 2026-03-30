package org.testleaf.week4day1assignment.Abstraction;

public interface DatabaseConnection {

    public abstract void connect();
    public abstract void disconnect();
    public abstract void executeUpdate();

}
