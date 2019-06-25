package com.sharp.water;

import java.sql.Connection;
import java.util.concurrent.Callable;

public class GetConnectionTask implements Callable<Connection> {

    private WaterDataSource waterDataSource;

    public GetConnectionTask(WaterDataSource waterDataSource) {
        this.waterDataSource = waterDataSource;
    }

    @Override
    public Connection call() throws Exception {
        return waterDataSource.getConnection();
    }
}
