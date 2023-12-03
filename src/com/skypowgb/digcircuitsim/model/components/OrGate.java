package com.skypowgb.digcircuitsim.model.components;

import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;

public class OrGate extends DigitalComponent {
    public  OrGate(){
        addPin(new Pin(CommonPinNames.in, PinType.INPUT,0,false));
        addPin(new Pin(CommonPinNames.in, PinType.INPUT,1,false));

        addPin(new Pin(CommonPinNames.out, PinType.OUTPUT,2,false));

    }

    @Override
    protected void updateOutputs() {
       Pin output= getPinByName(CommonPinNames.out);
        if(getPinByPinNum(0).getPinState()||getPinByPinNum(1).getPinState()){
            output.setPinState(true);
        }else{
            output.setPinState(false);
        }
    }
}
