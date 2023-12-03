package com.skypowgb.digcircuitsim.model.components;

import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;

public class Gnd extends DigitalComponent {
    public   Gnd(){
        this.addPin(new Pin(CommonPinNames.out, PinType.OUTPUT,0,false));
    }

    @Override
    protected void updateOutputs() {

    }
}
