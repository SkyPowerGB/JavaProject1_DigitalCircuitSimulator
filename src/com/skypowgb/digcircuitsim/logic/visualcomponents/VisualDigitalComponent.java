package com.skypowgb.digcircuitsim.logic.visualcomponents;

import com.skypowgb.digcircuitsim.logic.helpers.TextureHelper;
import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class VisualDigitalComponent extends JPanel {
private DigitalComponent digComponent;
private Image backgroundImage;


private ArrayList<VisualPin> pinButtons=new ArrayList<>();

public VisualDigitalComponent(DigitalComponent digComponent){
    this.digComponent=digComponent;
    backgroundImage = TextureHelper.getComponentIcon(digComponent.getClassNameE().toString()).getImage();
this.setSize(backgroundImage.getWidth(null),backgroundImage.getHeight(null));

}


    public ArrayList<Pin> getPins(){
    return digComponent.getPins();
}

    public DigitalComponent getDigComponent() {
        return digComponent;
    }
    public ArrayList<VisualPin> getPinButtons() {
        return pinButtons;
    }

public void addPinButton(VisualPin pin){

    pinButtons.add(pin);

}
public void updateImage(){
    backgroundImage=TextureHelper.getComponentTexture(digComponent.getClassNameE(),
            digComponent.getCompTextureSuffix(),this.getWidth(),this.getHeight()).getImage();
}

public void showPins(){
    for (VisualPin pin:pinButtons) {
        pin.setVisible(true);
    }
}
public void hidePins(){
        for (VisualPin pin:pinButtons) {
            pin.setVisible(false);
        }

    }


@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(),  null);
}


}
