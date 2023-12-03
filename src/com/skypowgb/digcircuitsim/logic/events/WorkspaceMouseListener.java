package com.skypowgb.digcircuitsim.logic.events;

import com.skypowgb.digcircuitsim.logic.GuiAEManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WorkspaceMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        GuiAEManager.addComponent(e.getX(),e.getY());
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
