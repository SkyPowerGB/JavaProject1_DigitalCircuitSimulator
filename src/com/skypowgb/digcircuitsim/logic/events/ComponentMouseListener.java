package com.skypowgb.digcircuitsim.logic.events;

import com.skypowgb.digcircuitsim.logic.GuiAEManager;
import com.skypowgb.digcircuitsim.logic.data.ActiveToolsV2;
import com.skypowgb.digcircuitsim.logic.setup.ToolsE;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualDigitalComponent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComponentMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        VisualDigitalComponent component= (VisualDigitalComponent) e.getSource();
if(ActiveToolsV2.getToolState(ToolsE.delete)){

    GuiAEManager.deleteComponent(component);

}

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
