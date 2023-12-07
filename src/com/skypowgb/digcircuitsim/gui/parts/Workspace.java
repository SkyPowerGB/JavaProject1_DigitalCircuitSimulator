package com.skypowgb.digcircuitsim.gui.parts;

import com.skypowgb.digcircuitsim.logic.data.Storage;
import com.skypowgb.digcircuitsim.logic.wires.WireLine;
import com.skypowgb.digcircuitsim.logic.wires.WireLinePartsList;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Workspace extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;



        // Set common properties outside the loop
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(5));

        for (WireLinePartsList lines : Storage.wireLines) {
            for (WireLine line : lines.getLines()) {
                Line2D.Float line2d = new Line2D.Float();
                line2d.setLine(line.getP1(), line.getP2());
                g2d.draw(line2d);
            }
        }
    }
}
