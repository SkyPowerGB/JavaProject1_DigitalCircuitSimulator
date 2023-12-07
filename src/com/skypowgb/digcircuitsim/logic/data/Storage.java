package com.skypowgb.digcircuitsim.logic.data;

import com.skypowgb.digcircuitsim.logic.GuiAEManager;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualDigitalComponent;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualWire;
import com.skypowgb.digcircuitsim.logic.wires.WireLine;
import com.skypowgb.digcircuitsim.logic.wires.WireLinePartsList;
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
for(VisualWire wire:visualWires){

if(wire.getComp1().equals(comp)){
    deleteWireLine(wire);

}
if(wire.getComp2().equals(comp)){
    deleteWireLine(wire);
}

}

}

public static void updateVisualWires(){
        for(VisualWire wire:visualWires){
            wire.updateWire();
        }
}


public static ArrayList<WireLinePartsList> wireLines =new ArrayList<>();


    public static void deleteWireLine(VisualWire wire){
if(wireLinesContainCompWire(wire)){
    wireLines.remove(getWireLine(wire));
}

    }

    private static boolean wireLinesContainCompWire(VisualWire wire){
        for (WireLinePartsList wireList:wireLines) {
            for(WireLine line:wireList.getLines()){
   if(line.getWire().equals(wire)){return true;}

            }
        }
return false;

    }

    private static WireLinePartsList getWireLine(VisualWire wire){
        for (WireLinePartsList wires:wireLines){
if(wires.getLine(0).getWire().equals(wire)){
    return wires;
}

        }
return null;
    }
}