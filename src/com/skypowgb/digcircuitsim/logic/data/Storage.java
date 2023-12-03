package com.skypowgb.digcircuitsim.logic.data;

import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualDigitalComponent;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualWire;
import com.skypowgb.digcircuitsim.model.Whire;

import java.util.ArrayList;

public class Storage {
    public static ArrayList<VisualDigitalComponent> visualDigitalComponents =new ArrayList<>();
    public static ArrayList<Whire> whires =new ArrayList<Whire>();

    public static ArrayList<VisualWire> visualWires=new ArrayList<VisualWire>();
    public static void updateWires(){
        for (Whire w:whires) {
            w.Update();
        }

    }
}