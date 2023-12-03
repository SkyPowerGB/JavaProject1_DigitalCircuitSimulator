package com.skypowgb.digcircuitsim.model.components;

import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;

public class NotGate extends DigitalComponent {
    public NotGate(){
        this.addPin(new Pin(CommonPinNames.in, PinType.INPUT,0,false));
        this.addPin(new Pin(CommonPinNames.out, PinType.OUTPUT,1,true));
    }

    @Override
    protected void updateOutputs() {
       Pin output= this.getPinByName(CommonPinNames.out);
       if(this.getPinByName(CommonPinNames.in).getPinState()){
           output.setPinState(false);
       }
       else{output.setPinState(true);}
    }
}
