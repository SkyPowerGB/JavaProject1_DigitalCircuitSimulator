package com.skypowgb.digcircuitsim.model.components;

import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;

public class Probe extends DigitalComponent {
    public Probe(){this.addPin(new Pin(CommonPinNames.in, PinType.INPUT,0,false));}

    @Override
    protected void updateOutputs() {

    }
}
