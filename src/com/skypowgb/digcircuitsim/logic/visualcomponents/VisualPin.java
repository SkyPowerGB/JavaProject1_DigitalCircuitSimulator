package com.skypowgb.digcircuitsim.logic.visualcomponents;

import com.skypowgb.digcircuitsim.model.Pin;

import javax.swing.*;

public class VisualPin extends JButton {
private VisualDigitalComponent comp;
private Pin pin;
    public  VisualPin(VisualDigitalComponent comp,Pin pin){

this.pin=pin;
    }

    public void setComp(VisualDigitalComponent comp) {
        this.comp = comp;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public VisualDigitalComponent getComp() {
        return comp;
    }


    public Pin getPin() {
        return pin;
    }


}
