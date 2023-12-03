package com.skypowgb.digcircuitsim.logic.events;

import com.skypowgb.digcircuitsim.logic.GuiAEManager;
import com.skypowgb.digcircuitsim.logic.data.ActiveToolsV2;
import com.skypowgb.digcircuitsim.logic.setup.ToolsE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBtnActionLister implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button= (JButton) e.getSource();
                System.out.println("pressed:"+button.getName());
        ActiveToolsV2.switchState(ToolsE.valueOf(button.getName()));

        GuiAEManager.updateToolTextures();

        if(ActiveToolsV2.getToolState(ToolsE.connect)){
            GuiAEManager.SetComponentPinsVisible();

        }else if(!ActiveToolsV2.getToolState(ToolsE.connect)){
            GuiAEManager.SetComponentPinsInvisible();

        }

        if(ActiveToolsV2.getToolState(ToolsE.simulate)){
            GuiAEManager.startSimulation();
        }


    }
}
