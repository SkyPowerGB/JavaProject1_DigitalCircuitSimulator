package com.skypowgb.digcircuitsim.logic;

import com.skypowgb.digcircuitsim.logic.events.*;
import com.skypowgb.digcircuitsim.logic.helpers.TextureHelper;
import com.skypowgb.digcircuitsim.gui.ToolButtons;
import com.skypowgb.digcircuitsim.gui.visualV2.GuiV2;
import com.skypowgb.digcircuitsim.logic.data.ActiveToolsV2;
import com.skypowgb.digcircuitsim.logic.data.Storage;
import com.skypowgb.digcircuitsim.logic.helpers.DigitalComponentFactory;
import com.skypowgb.digcircuitsim.logic.helpers.PinButtonLocationHelper;
import com.skypowgb.digcircuitsim.logic.setup.ToolsE;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualCompCtrlBtn;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualDigitalComponent;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualPin;
import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.components.Switch2Pin;
import com.skypowgb.digcircuitsim.model.setup.ComponentClassNamesE;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;

public class GuiAEManager {
private static    JFrame window;
private static     JPanel workspace;

private static SpecialControlBtnListener specialControlBtnListener;
private static ComponentMouseListener componentMouseListener;
private static FrameKeyListener frameKeyListener;
private static PinActionListener pinListener;
private static WorkspaceMouseListener workspaceListener;

private static boolean makingComponent=false;
private static VisualDigitalComponent componentTemp;

private static boolean isAllSet=false;


    public GuiAEManager(JFrame window, JPanel workspace) {
        isAllSet=true;
        this.window = window;
        this.workspace = workspace;

        frameKeyListener =new FrameKeyListener();
        window.addKeyListener(frameKeyListener);

        workspaceListener=new WorkspaceMouseListener();
        workspace.addMouseListener(workspaceListener);

        //------------------------------------------------------

       pinListener=new PinActionListener();

        componentMouseListener=new ComponentMouseListener();

        //-----------
        specialControlBtnListener=new SpecialControlBtnListener();

    }

    public static void removeAllListeners(){
for(VisualDigitalComponent component :Storage.visualDigitalComponents){
    deleteComponent(component);

}
        refreshFrame();
workspace.removeMouseListener(workspaceListener);
window.removeKeyListener(frameKeyListener);

    }

    public static void prepareComponent(ComponentClassNamesE name){
if(!isAllSet){return;}

makingComponent=true;
if(ActiveToolsV2.getToolState(ToolsE.newComp)){return;}
updateToolTextures();
    DigitalComponent digComp= DigitalComponentFactory.createDigitalComponent(name.toString());

componentTemp=new VisualDigitalComponent(digComp);
ActiveToolsV2.setToolState(ToolsE.newComp,true);
    Storage.visualDigitalComponents.add(componentTemp);
    componentTemp.setLayout(null);

componentTemp.setBackground(null);
componentTemp.setOpaque(false);
        updateToolTextures();
refreshFrame();
addComponentPins();
addComponentControlBtn();

}

    public static void addComponent(int x ,int y){
        if(componentTemp==null){return;}
        if(!ActiveToolsV2.getToolState(ToolsE.newComp)){return;}
        if(!makingComponent){return;}
        makingComponent=false;
componentTemp.setLocation(x,y);


        workspace.add(componentTemp);
componentTemp.addMouseListener(componentMouseListener);


componentTemp=null;
        ActiveToolsV2.setToolState(ToolsE.newComp,false);
        updateToolTextures();
refreshFrame();
}



    public static void deleteComponent(VisualDigitalComponent component){
        Storage.deleteComp(component);
removeComponentPins(component);

component.removeMouseListener(componentMouseListener);
workspace.remove(component);
Storage.visualDigitalComponents.remove(component);

refreshFrame();
}

    public static void updateToolTextures(){
        if(!isAllSet){return;}
        for (JButton btn: ToolButtons.toolButtons) {
            btn.setIcon(TextureHelper.getControlBtnIcon(ToolsE.valueOf(btn.getName()), GuiV2.CONTROL_BTN_DIM.width,GuiV2.CONTROL_BTN_DIM.height));
        }
refreshFrame();
    }


    private static void addComponentPins(){
        int i=0;
    for(Pin pin: componentTemp.getPins()){
        VisualPin visualPin=new VisualPin(componentTemp,pin);
        visualPin.setVisible(false);
        visualPin.addActionListener(pinListener);
      visualPin.setSize(GuiV2.PIN_SIZE,GuiV2.PIN_SIZE);
visualPin.setIcon(TextureHelper.getPinTexture());
visualPin.setOpaque(false);
visualPin.setBorderPainted(false);
visualPin.setContentAreaFilled(false);
visualPin.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
      ComponentClassNamesE nameOf= ComponentClassNamesE.valueOf(componentTemp.getDigComponent().getClass().getSimpleName());
        PinButtonLocationHelper.setup();
if(PinButtonLocationHelper.isPinLocationSaved(nameOf,i)){

    visualPin.setLocation(PinButtonLocationHelper.getPinLocation(nameOf,i));
    i++;
}else{
        if(visualPin.getPin().isInput()){
            visualPin.setLocation(0,i);
            i++;
        }else{
            visualPin.setLocation(componentTemp.getWidth()-GuiV2.PIN_SIZE,i);
            i+=GuiV2.PIN_CLR+GuiV2.PIN_SIZE;
        }
}

        componentTemp.add(visualPin);
        componentTemp.addPinButton(visualPin);

    }

}

    private static void addComponentControlBtn(){
            if(!componentTemp.getDigComponent().isSpecial()){return;}
        VisualCompCtrlBtn compControlBtn=new VisualCompCtrlBtn(componentTemp.getDigComponent().getClassNameE(),componentTemp);
compControlBtn.setSize(GuiV2.COMP_CONTROL_BTN_DIM);
compControlBtn.addActionListener(specialControlBtnListener);
compControlBtn.setLocation((componentTemp.getWidth()/2)-GuiV2.COMP_CONTROL_BTN_DIM.width,
        (componentTemp.getHeight()/2)-GuiV2.COMP_CONTROL_BTN_DIM.height      );

            componentTemp.add(compControlBtn);
            refreshFrame();
    }

    private static void removeComponentPins(VisualDigitalComponent target){
    for (VisualPin pin:target.getPinButtons()) {
        pin.removeActionListener(pinListener);
        pin.setComp(null);
        pin.setPin(null);
        target.remove(pin);
    }

}



public static void SetComponentPinsVisible(){
        for(VisualDigitalComponent component:Storage.visualDigitalComponents){
component.showPins();
        }
}

public static void SetComponentPinsInvisible(){

    for(VisualDigitalComponent component:Storage.visualDigitalComponents){
        component.hidePins();
    }
}

    public static void refreshFrame(){
        if(!isAllSet){return;}
        window.repaint();
        window.setVisible(true);

}

public static void startSimulation(){
System.out.println("starting simulation");
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
        @Override
        protected Void doInBackground() throws Exception {
            while (ActiveToolsV2.getToolState(ToolsE.simulate)) {
                Storage.updateWires();
System.out.println("simulation running" );

            }
            return null;
        }


    };



    worker.execute();
}


public static void specialComponentActivate(ComponentClassNamesE comp,VisualDigitalComponent component){
        if(comp== ComponentClassNamesE.Switch2Pin){
System.out.println("switchstate");
        Switch2Pin switchComp= (Switch2Pin) component.getDigComponent();
switchComp.switchState();
component.updateImage();

        } else if (false){


        }
        refreshFrame();

}


}
