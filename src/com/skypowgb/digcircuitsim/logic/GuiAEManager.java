package com.skypowgb.digcircuitsim.logic;

import com.skypowgb.digcircuitsim.gui.TextureHelper;
import com.skypowgb.digcircuitsim.gui.ToolButtons;
import com.skypowgb.digcircuitsim.gui.visualV2.GuiV2;
import com.skypowgb.digcircuitsim.logic.data.ActiveToolsV2;
import com.skypowgb.digcircuitsim.logic.data.Storage;
import com.skypowgb.digcircuitsim.logic.events.ComponentMouseListener;
import com.skypowgb.digcircuitsim.logic.events.FrameKeyListener;
import com.skypowgb.digcircuitsim.logic.events.PinActionListener;
import com.skypowgb.digcircuitsim.logic.events.WorkspaceMouseListener;
import com.skypowgb.digcircuitsim.logic.helpers.DigitalComponentFactory;
import com.skypowgb.digcircuitsim.logic.setup.ToolsE;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualDigitalComponent;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualPin;
import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.Pin;
import com.skypowgb.digcircuitsim.model.Whire;
import com.skypowgb.digcircuitsim.model.setup.ComponentClassNamesE;

import javax.swing.*;
import java.awt.*;

public class GuiAEManager {
private static    JFrame window;
private static     JPanel workspace;

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

addComponentPins();

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
refreshFrame();
}



    public static void deleteComponent(VisualDigitalComponent component){
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

        if(visualPin.getPin().isInput()){
            visualPin.setLocation(0,i);
        }else{
            visualPin.setLocation(componentTemp.getWidth()-GuiV2.PIN_SIZE,i);
        }
        componentTemp.add(visualPin);
        componentTemp.addPinButton(visualPin);
        i+=GuiV2.PIN_CLR+GuiV2.PIN_SIZE;
    }

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

    private static void refreshFrame(){
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

}
