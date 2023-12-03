package com.skypowgb.digcircuitsim.logic.visualcomponents;

import com.skypowgb.digcircuitsim.model.Whire;

public class VisualWire {
  private   Whire whire;
  private   VisualPin pin1;
  private   VisualPin pin2;
    VisualWire(VisualPin pin1, VisualPin pin2, Whire whire){
this.pin1=pin1;
this.pin2=pin2;
this.whire=whire;
    }

    public void updateWire(){
        whire.Update();

    }

}
