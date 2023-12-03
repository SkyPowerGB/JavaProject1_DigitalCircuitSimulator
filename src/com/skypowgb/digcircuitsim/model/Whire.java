package com.skypowgb.digcircuitsim.model;

public class Whire {
    DigitalComponent component1;
    Pin pin1;



    DigitalComponent component2;
    Pin pin2;



    private boolean state=false;

    private boolean whireType=false;


 public Whire(DigitalComponent component1,Pin pin1 , DigitalComponent component2,Pin pin2){
        this.component1=component1;
        this.pin1=pin1;
        this.component2=component2;
        this.pin2=pin2;
whireType=false;
 }



 //getters and setters----------------------------

    public DigitalComponent getComponent1() {
        return component1;
    }
    public void setComponent1(DigitalComponent component1) {
        this.component1 = component1;
    }


    public Pin getPin1() {
        return pin1;
    }
    public void setPin1(Pin pin1) {
        this.pin1 = pin1;
    }

    public DigitalComponent getComponent2() {
        return component2;
    }
    public void setComponent2(DigitalComponent component2) {
        this.component2 = component2;
    }

    public Pin getPin2() {
        return pin2;
    }
    public void setPin2(Pin pin2) {
        this.pin2 = pin2;
    }

//-------------extended-------------------------------------




    //-------------------------------------------

    //*********--CONTROL--****************************

public void Update(){
if(whireType){
return;
}

if(pin1.isOutput()){
    this.state=pin1.getPinState();

}
if(pin2.isOutput()){
    this.state=pin2.getPinState();

}

if(pin1.isInput()){

    component1.updateComponentInput(pin1.getPinNum(),state);
}
if(pin2.isInput()){

    component2.updateComponentInput(pin2.getPinNum(),state);
}

}
private  void UpdateWhire(){

}


}
