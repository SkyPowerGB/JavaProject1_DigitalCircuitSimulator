package com.skypowgb.digcircuitsim.model.components;

import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;

public class AndGate extends DigitalComponent {
    public AndGate(){
        addPin(new Pin(CommonPinNames.in, PinType.INPUT,0,false));
        addPin(new Pin(CommonPinNames.in, PinType.INPUT,1,false));

        addPin(new Pin(CommonPinNames.out, PinType.OUTPUT,2,false));

    }

    public AndGate(int n){

        for(int i=0;i<n;i++){

            addPin(new Pin(CommonPinNames.in, PinType.INPUT,i,false));

        }
        addPin(new Pin(CommonPinNames.in, PinType.INPUT,n,false));

        addPin(new Pin(CommonPinNames.out, PinType.OUTPUT,1,false));

    }

    @Override
    protected void updateOutputs() {
        for (Pin pin:getInputPins()) {
            if(!(pin.getPinState())) {

                getPinByName(CommonPinNames.out).setPinState(false);
                return;
            }

        }

        getPinByName(CommonPinNames.out).setPinState(true);
    }
}

