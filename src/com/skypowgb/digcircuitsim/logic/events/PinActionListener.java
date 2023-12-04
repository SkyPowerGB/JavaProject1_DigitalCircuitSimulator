package com.skypowgb.digcircuitsim.logic.events;

import com.skypowgb.digcircuitsim.logic.WireConnect;
import com.skypowgb.digcircuitsim.logic.data.ActiveToolsV2;
import com.skypowgb.digcircuitsim.logic.setup.ToolsE;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualPin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!ActiveToolsV2.getToolState(ToolsE.connect)) {return;}
        VisualPin pin= (VisualPin) e.getSource();
        WireConnect.prepareNewWire(pin.getComp().getDigComponent(),pin.getPin());
pin.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        pin.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

    }
}
