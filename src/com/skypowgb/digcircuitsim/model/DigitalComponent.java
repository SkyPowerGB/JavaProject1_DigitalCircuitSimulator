package com.skypowgb.digcircuitsim.model;

import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;
import com.skypowgb.digcircuitsim.model.setup.ComponentClassNamesE;

import java.util.ArrayList;

public class DigitalComponent {

    private boolean special=false;

    private ArrayList<Pin> pins=new ArrayList<Pin>();

    private String compTextureSuffix="";
    private int maxPinNum=0;


   //-*------------------------------------------------------
   //Getter and setter

    public ArrayList<Pin> getPins() {
        return pins;
    }

    public ArrayList<Pin> getInputPins(){
        ArrayList<Pin> inputs = new ArrayList<>();
        for (Pin pin:pins) {
            if(pin.getPinType()==PinType.INPUT){
            inputs.add(pin);}
        }
        return inputs;
    }

    public ArrayList<Pin> getOutputPins(){
        ArrayList<Pin> outputs = new ArrayList<>();
        for (Pin pin:pins) {
            if(pin.getPinType()==PinType.OUTPUT)
            outputs.add(pin);
        }
        return outputs;
    }


    public ArrayList<Integer> getInputPinNums(){
        ArrayList<Integer> numbers=new ArrayList<>();
        for (Pin pin:getInputPins()) {
numbers.add(pin.getPinNum());
        }
return numbers;

    }

   public ArrayList<Integer> getOutputPinNums(){
        ArrayList<Integer> numbers=new ArrayList<>();
        for (Pin pin:getOutputPins()) {
numbers.add(pin.getPinNum());
        }
return numbers;

    }


    public int getNumOfPins(){

        return pins.size();
}

    public int getNumOfInputs(){
        ArrayList<Pin> inputs=getInputPins();
        return inputs.size();
}

    public int getNumOfOutputs(){
        ArrayList<Pin> output=getOutputPins();
        return output.size();
}

    public Pin getPinByName(CommonPinNames name){
        Pin output=null;
        for (Pin pin:pins) {
            if(pin.getPinName()==name){
                return pin;
            }
        }
     return output;
    }

    public Pin getPinByPinNum(int num){
        for (Pin pin:pins) {
            if(pin.getPinNum()==num){
                return pin;
            }
        }
        return  null;
    }


    public boolean pinsIsPinInput(int pinNum){
      if(pins.get(pinNum).getPinType()== PinType.INPUT){
          return true;
      }
      return false;
    }

    public boolean pinsIsPinOutput(int pinNum){
      if(pins.get(pinNum).getPinType()== PinType.OUTPUT ){
          return true;
      }
      return false;
    }

    public String getCompTextureSuffix() {
        return compTextureSuffix;
    }

    public void setCompTextureSuffix(String compTextureSuffix) {
        this.compTextureSuffix = compTextureSuffix;
    }


//-------------------------------------------------------------------------------
//public methods

    public void printState(){
        System.out.println("-------------Component State---------------------------");
        for (Pin pin:pins) {
            System.out.println("Pin: "+pin.getPinNum()+ " State: " +pin.getPinState() +" PinType: "+pin.getPinType());
        }
        System.out.println("----------------------------------------");
    }


    public ComponentClassNamesE getClassNameE(){
        ComponentClassNamesE var=null;
        for (ComponentClassNamesE classNamesE:ComponentClassNamesE.values()){

            if(classNamesE.toString().equals(this.getClass().getSimpleName())){
                var=classNamesE;
            }
        }
        return var;
    }

    //******************----CONTROL-------FOR WHIRE-----------------------------------------****************************


    public void updateComponentInput(int pinNum,boolean state) {
        if(getPinByPinNum(pinNum).isOutput()){return;}
        getPinByPinNum(pinNum).setPinState(state);
       updateOutputs();
    }

    public void updateComponentInput(CommonPinNames pinName,boolean state){
        if(getPinByName(pinName).isOutput()){return;}

    getPinByName(pinName).setPinState(state);
updateOutputs();
    }



//-***********************************************************************-------------------------------

    // protected and public methods for child classes

    protected void updateOutputs(){

    }


    public void addPin(Pin pin){
        pins.add(pin);
    }





// private methods------------------------------


//public----------------------------------------

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }
}
