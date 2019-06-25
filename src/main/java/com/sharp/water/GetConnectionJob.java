package com.sharp.water;

import java.sql.Connection;
import java.util.concurrent.Callable;

public class GetConnectionJob implements Runnable {

    private WaterDataSource waterDataSource;

    public GetConnectionJob(WaterDataSource waterDataSource) {
        this.waterDataSource = waterDataSource;
    }

    @Override
    public void run() {
        System.out.println("Run");
        waterDataSource.getConnection();
    }
}
