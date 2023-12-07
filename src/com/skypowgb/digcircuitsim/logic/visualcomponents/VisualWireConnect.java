package com.skypowgb.digcircuitsim.logic.visualcomponents;

import com.skypowgb.digcircuitsim.logic.GuiAEManager;

import com.skypowgb.digcircuitsim.logic.data.ActiveToolsV2;
import com.skypowgb.digcircuitsim.logic.data.Storage;
import com.skypowgb.digcircuitsim.logic.setup.ToolsE;
import com.skypowgb.digcircuitsim.logic.wires.WireLineGenerator;

public class VisualWireConnect {
  static  VisualDigitalComponent component;
   static VisualPin pin;
   static boolean rdy=false;
    public static void prepareDataForWire(VisualPin pinIn){
        if(!ActiveToolsV2.getToolState(ToolsE.connect)){component=null;pin=null;rdy=false;
            GuiAEManager.CursorDefault(); return;}
if(rdy){ GuiAEManager.CursorDefault();connect(pinIn); return;}
pin=pinIn;
component=pinIn.getComp();
rdy=true;
GuiAEManager.CursorCross();
    }


    private static void connect(VisualPin pin2){


VisualWire wire=new VisualWire(component,pin,pin2.getComp(),pin2);
        WireLineGenerator.generateWireLinePoints(wire);
        Storage.visualWires.add(wire);
component=null;
pin=null;
rdy=false;

        GuiAEManager.refreshFrame();
    }




}
