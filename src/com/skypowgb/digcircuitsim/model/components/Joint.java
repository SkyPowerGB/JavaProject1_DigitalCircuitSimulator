package com.skypowgb.digcircuitsim.model.components;

import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;

public class Joint extends DigitalComponent {

private boolean state=false;

    public Joint(){

        addPin(new Pin(CommonPinNames.in, PinType.INPUT,0,false));
        addPin(new Pin(CommonPinNames.out, PinType.OUTPUT,1,false));

    }
    @Override
    protected void updateOutputs() {
state=getPinByName(CommonPinNames.in).getPinState();
getPinByName(CommonPinNames.out).setPinState(state);
getPinByName(CommonPinNames.in).setPinState(state);

    }
}
