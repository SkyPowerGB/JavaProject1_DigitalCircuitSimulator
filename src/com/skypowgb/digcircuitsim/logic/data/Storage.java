package com.skypowgb.digcircuitsim.logic.data;

import com.skypowgb.digcircuitsim.logic.GuiAEManager;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualDigitalComponent;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualWire;
import com.skypowgb.digcircuitsim.model.Whire;
import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.setup.ComponentClassNamesE;

import java.util.ArrayList;

public class Storage {
    public static ArrayList<VisualDigitalComponent> visualDigitalComponents =new ArrayList<>();
    public static ArrayList<Whire> whires =new ArrayList<Whire>();

    public static ArrayList<VisualWire> visualWires=new ArrayList<VisualWire>();
    public static void updateWires(){
        for (Whire w:whires) {


            w.Update();
        }

updateTexture();
        GuiAEManager.refreshFrame();

    }
private static void updateTexture(){
        for (VisualDigitalComponent comp:visualDigitalComponents){
comp.updateImage();


        }
}

public static void deleteComp(VisualDigitalComponent comp){
    for (Whire w :whires) {
        if(w.getComponent1().equals(comp)){whires.remove(w);}
        if(w.getComponent2().equals(comp)){whires.remove(w);}
    }

}

}