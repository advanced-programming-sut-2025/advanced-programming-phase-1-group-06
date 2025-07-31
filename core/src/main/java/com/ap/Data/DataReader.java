package com.ap.Data;

public class DataReader {
    private static DataReader instance;

    public static DataReader getInstance() {
        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }


}
