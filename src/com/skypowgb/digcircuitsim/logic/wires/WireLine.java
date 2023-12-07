package com.skypowgb.digcircuitsim.logic.wires;

import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualWire;

import java.awt.*;

public class WireLine {
    private Point p1;
    private Point p2;

    private VisualWire wire;

    public WireLine(Point p1, Point p2,VisualWire wire) {
        this.p1 = p1;
        this.p2 = p2;
        this.wire=wire;
    }

    public VisualWire getWire() {
        return wire;
    }

    public void setWire(VisualWire wire) {
        this.wire = wire;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
}
