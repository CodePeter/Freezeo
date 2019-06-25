package com.sharp.water;

import java.sql.Connection;

public class ConnectionHolder {

    private Connection connection;

    public ConnectionHolder(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
