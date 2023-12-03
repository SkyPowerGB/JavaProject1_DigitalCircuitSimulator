package com.skypowgb.digcircuitsim.model.components;

import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.enums.CommonPinNames;
import com.skypowgb.digcircuitsim.model.enums.PinType;

public class Vcc extends DigitalComponent {
  public   Vcc(){
      this.addPin(new Pin(CommonPinNames.out, PinType.OUTPUT,0,true));
  }

    @Override
    protected void updateOutputs() {

    }
}
