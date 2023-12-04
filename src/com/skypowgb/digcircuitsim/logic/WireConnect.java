package com.skypowgb.digcircuitsim.logic;


import com.skypowgb.digcircuitsim.logic.data.Storage;
import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.Whire;

public class WireConnect{
    private static DigitalComponent comp1temp;
    private static Pin pin1temp;

    private static boolean connectingStarted=false;
    public static void prepareNewWire(DigitalComponent comp1,Pin pin1){
        if(connectingStarted){
connect(comp1,pin1);
            connectingStarted=false;
        }
        comp1temp=comp1;
        pin1temp=pin1;
connectingStarted=true;
    }
    private static void connect(DigitalComponent comp2,Pin pin2){
        Whire wire = new Whire(comp1temp,pin1temp,comp2,pin2);
        Storage.whires.add(wire);
    }


}
