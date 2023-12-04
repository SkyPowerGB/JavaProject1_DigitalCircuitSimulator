package com.skypowgb.digcircuitsim.logic.helpers;

import com.skypowgb.digcircuitsim.model.setup.ComponentClassNamesE;

import java.awt.*;
import java.io.*;

public class PinButtonLocationHelper {
    private static final String PATH_PINS_DATA = "./././Files/text/pinsLoc.txt";
    private static String data;




    private static boolean set = false;

    public static void setup() {
        if (set) {
            return;
        }
        data = readFullFIle();
        setupSortedData();
    }

    private static String readFullFIle() {
        StringBuilder fullText = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH_PINS_DATA));
            String line;
            while ((line = br.readLine()) != null) {

                fullText.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }


        return fullText.toString();
    }

    private static void setupSortedData() {


            }


public static Point getPinLocation(ComponentClassNamesE comp, int pinNum) {

        if(!set){setup();}
    for (String s :data.split(";")) {
        String[] parts=s.split(":");
        if(ComponentClassNamesE.valueOf(parts[0])==comp){
          String pins[]=  parts[1].split(",");

    return convertStringToPoint(pins[pinNum]);

        }
    }


    return null;
}


public static boolean isPinLocationSaved(ComponentClassNamesE comp,int pin){
if(!set){setup();}
    Point p=    getPinLocation(comp,pin);
     if(p==null){return false;}
     return true;
};

private static Point convertStringToPoint(String point){
       if(!set){setup();}
        String[] pointAxis=point.split("\\.");
        return  new Point(Integer.parseInt(pointAxis[0]),Integer.parseInt(pointAxis[1]));
}



}
