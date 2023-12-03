package com.skypowgb.digcircuitsim.model;

import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;

public class Pin {

private CommonPinNames pinName;
private boolean pinState;
private PinType pinType;
private int pinNum;

//*-----------------------------------------------------------------------------------------

public Pin(CommonPinNames pinName,PinType pinType,int pinNum,boolean pinState){
    this.pinName=pinName;
    this.pinState=pinState;
    this.pinType=pinType;
    this.pinNum=pinNum;


}


//getter and setter

        public CommonPinNames getPinName () {
        return pinName;
    }
        public void setPinName (CommonPinNames pinName){
        this.pinName = pinName;
    }


        public boolean getPinState () {
        return pinState;
    }
        public void setPinState ( boolean pinState){
        this.pinState = pinState;
    }


        public PinType getPinType () {
        return pinType;
    }
        public void setPinType (PinType pinType){
        this.pinType = pinType;
    }


        public int getPinNum () {
        return pinNum;
    }
        public void setPinNum ( int pinNum){
        this.pinNum = pinNum;
    }

    //------------------------------------------------------------------------------------------
public boolean isOutput(){
    if(pinType==PinType.OUTPUT){return true;}
    return false;
}
public boolean isInput(){
    if(pinType==PinType.INPUT){return true;}
    return false;
}

    //---------------------------------------------------------------------------------




}
