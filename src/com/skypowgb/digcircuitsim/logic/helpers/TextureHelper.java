package com.skypowgb.digcircuitsim.logic.helpers;

import com.skypowgb.digcircuitsim.gui.visualV2.GuiV2;
import com.skypowgb.digcircuitsim.logic.data.ActiveToolsV2;
import com.skypowgb.digcircuitsim.logic.setup.ToolsE;
import com.skypowgb.digcircuitsim.model.setup.ComponentClassNamesE;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class TextureHelper {

    public static final String COMPONENT_BTN_PATH="./././Files/Textures/ComponentButtons/";
    public static final String CONTROL_BTN_PATH="./././Files/Textures/ControlButtons/";
    public static final String COMPONENT_PATH="./././Files/Textures/Components/";

    public static final String PIN_PATH="./././Files/Textures/Random/pin.png";


public static ImageIcon getNewCompBtnIcon(ComponentClassNamesE className){
    String fileName=className.toString().toLowerCase(Locale.ROOT)+".png";
    String texturePath="./././Files/Textures/ComponentButtons/"+fileName;

    ImageIcon icon = new ImageIcon(texturePath);

return  icon;

}

public  static  ImageIcon getNewCompBtnIcon(ComponentClassNamesE className , Dimension dimension){
    String fileName=className.toString().toLowerCase(Locale.ROOT)+".png";
    String texturePath=COMPONENT_BTN_PATH+fileName;
    ImageIcon icon = new ImageIcon(texturePath);
    Image scaled=icon.getImage().getScaledInstance(dimension.width,dimension.height,Image.SCALE_FAST);

    return new ImageIcon(scaled);
}

public static  ImageIcon getNewCompBtnIcon(ComponentClassNamesE classNamesE,int width,int height){

    return getNewCompBtnIcon(classNamesE,new Dimension(width,height));


}


private static ImageIcon getScaledFast(ImageIcon icon ,int width,int height){
    Image scaled=icon.getImage().getScaledInstance(width,height,Image.SCALE_FAST);
    return new ImageIcon(scaled);
}


public static ImageIcon getControlBtnIcon(ToolsE toole, int width, int height){
    String state="";
    String name= ActiveToolsV2.getTool(toole).getToolName();


    if(ActiveToolsV2.getToolState(toole)){
        state="_on";
    }else{
        state="_off";}


    String fullpath=CONTROL_BTN_PATH+name+state+".png";

    ImageIcon icon=new ImageIcon(fullpath);

    return getScaledFast(icon,width,height);
}

public static ImageIcon getComponentTexture(ComponentClassNamesE component,int width,int height){
    ImageIcon icon=new ImageIcon(COMPONENT_PATH+component+".png");
    return getScaledFast(icon ,width,height);

}
public static ImageIcon getComponentTexture(ComponentClassNamesE component,String suffix,int width,int height) {
    ImageIcon icon;

    if(suffix.equals("")){
     icon=  getComponentTexture(component,width,height);
       return getScaledFast(icon,width,height);
   }
    icon = new ImageIcon(COMPONENT_PATH + component + suffix + ".png");
    return getScaledFast(icon, width, height);

}

public static ImageIcon getComponentIcon(String component){

    return new ImageIcon(COMPONENT_PATH+component+".png");
}


public static ImageIcon getPinTexture(){
    ImageIcon icon=new ImageIcon(PIN_PATH);
    return getScaledFast(icon, GuiV2.PIN_SIZE,GuiV2.PIN_SIZE);
}




}
