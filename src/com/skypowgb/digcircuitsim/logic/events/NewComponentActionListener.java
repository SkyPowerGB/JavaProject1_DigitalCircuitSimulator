package com.skypowgb.digcircuitsim.logic.events;

import com.skypowgb.digcircuitsim.logic.GuiAEManager;
import com.skypowgb.digcircuitsim.model.setup.ComponentClassNamesE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewComponentActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn= (JButton) e.getSource();
        GuiAEManager.prepareComponent(ComponentClassNamesE.valueOf(btn.getName()));
    }
}
