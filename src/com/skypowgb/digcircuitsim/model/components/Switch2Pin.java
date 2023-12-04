package com.skypowgb.digcircuitsim.model.components;

import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;

import java.util.SimpleTimeZone;

public class Switch2Pin extends DigitalComponent {

    private boolean state=false;
    public Switch2Pin(){
        addPin(new Pin(CommonPinNames.in, PinType.INPUT,0,false));
        addPin(new Pin(CommonPinNames.out, PinType.OUTPUT,1,false));
setSpecial(true);
    }

    public boolean getState(){
        return state;}
    public void switchState(){
        if(state){
            System.out.println("off");
            state=false;
            setCompTextureSuffix("");
        }else{
        state=true;
        System.out.println("on");
        setCompTextureSuffix("ON");
    }}

    @Override
    protected void updateOutputs() {
        boolean b=getPinByName(CommonPinNames.in).getPinState();
        if(state){

            getPinByName(CommonPinNames.out).setPinState(b);
        }else{
            getPinByName(CommonPinNames.out).setPinState(false);
        }








    }
}
