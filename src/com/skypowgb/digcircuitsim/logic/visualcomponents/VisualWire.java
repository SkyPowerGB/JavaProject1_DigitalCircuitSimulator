package com.skypowgb.digcircuitsim.logic.visualcomponents;

import com.skypowgb.digcircuitsim.gui.visualV2.GuiV2;
import com.skypowgb.digcircuitsim.model.Whire;

import java.awt.*;

public class VisualWire {
  private   Whire whire;
  private   VisualPin pin1;
  private   VisualPin pin2;
 private  VisualDigitalComponent comp1;
 private  VisualDigitalComponent comp2;


 public   VisualWire(VisualDigitalComponent comp1,VisualPin pin1, VisualDigitalComponent comp2,VisualPin pin2){
        Whire wire=new Whire(comp1.getDigComponent(),pin1.getPin(),comp2.getDigComponent(),pin2.getPin());
        this.whire=wire;
        this.pin1=pin1;
        this.pin2=pin2;
        this.comp1=comp1;
        this.comp2=comp2;
 }

    public void updateWire(){
        whire.Update();

    }

    public Point getPin1Position(){
     return pin1.getLocation();
    }
    public Point getPin2Position(){
     return pin2.getLocation();
    }

    public Point getComponent1Position() {
       return comp1.getLocation();
    }
    public Point getComponent2Position() {
       return comp2.getLocation();
    }


    public Point getPin1TruePosition(){
     return new Point(getPin1Position().x+( GuiV2.PIN_SIZE/2) +getComponent1Position().x,
             getComponent1Position().y+getPin1Position().y+( GuiV2.PIN_SIZE/2));
    }
    public Point getPin2TruePosition(){
     return new Point(getPin2Position().x+( GuiV2.PIN_SIZE/2)+getComponent2Position().x,
             getComponent2Position().y+getPin2Position().y+( GuiV2.PIN_SIZE/2));
    }

    public VisualDigitalComponent getComp1() {
        return comp1;
    }

    public VisualDigitalComponent getComp2() {
        return comp2;
    }

    public void delete(){
     this.comp1=null;
     this.comp2=null;
     this.pin1=null;
     this.pin2=null;
    }
}
