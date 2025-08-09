package com.ap.Data;

import com.ap.Model.Item.ItemData;
import com.ap.Model.Item.ItemDataRoot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;

public class DataReader {
    private static DataReader instance;

    public static DataReader getInstance() {
        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }




}
