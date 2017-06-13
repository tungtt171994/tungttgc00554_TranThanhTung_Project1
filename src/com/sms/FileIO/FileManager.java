package com.sms.FileIO;

import com.sms.Physical.Entity;
import com.google.gson.Gson;
import java.io.BufferedWriter;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;

import java.io.IOException;

public class FileManager {

    //Save File Data
    public static void SaveData(String filePath,Entity entities) throws IOException{
        Gson gson = new Gson(); 
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter( filePath));
            writer.write( gson.toJson(entities));

        }
        catch ( IOException e)
        {
        }
        finally
        {
            try
            {
                if ( writer != null)
                writer.close( );
            }
            catch ( IOException e)
            {
            }
        }
    }
    //Load File Data
    public static Entity LoadData(String filePath) throws FileNotFoundException{
        Gson gson = new Gson();
//        Res.getDesktopFile("dsa2017-data/1e2/customers.json");
//        Res.getDesktopFile("dsa2017-data/1e2/orders.json");
//        Res.getDesktopFile("dsa2017-data/1e2/products.json");
        Entity result = gson.fromJson(new FileReader(filePath), Entity.class);
        return result;
    }
}
