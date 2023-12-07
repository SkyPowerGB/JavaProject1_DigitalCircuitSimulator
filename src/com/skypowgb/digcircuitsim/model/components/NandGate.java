package com.skypowgb.digcircuitsim.model.components;

import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;

public class NandGate extends DigitalComponent {
    public NandGate(){
        addPin(new Pin(CommonPinNames.in, PinType.INPUT,0,false));
        addPin(new Pin(CommonPinNames.in, PinType.INPUT,1,false));
        addPin(new Pin(CommonPinNames.out, PinType.OUTPUT,2,true));
    }

    @Override
    protected void updateOutputs() {
        if(getPinByPinNum(0).getPinState()&&getPinByPinNum(1).getPinState()){
            getPinByPinNum(2).setPinState(false);
        }
        else{
            getPinByPinNum(2).setPinState(true);
        }
    }
}
