package com.skypowgb.digcircuitsim.logic.events;

import com.skypowgb.digcircuitsim.logic.GuiAEManager;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualCompCtrlBtn;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualDigitalComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialControlBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        VisualCompCtrlBtn btn= (VisualCompCtrlBtn) e.getSource();
GuiAEManager.specialComponentActivate(btn.getClassNamesE(),btn.getComp());

    }
}
