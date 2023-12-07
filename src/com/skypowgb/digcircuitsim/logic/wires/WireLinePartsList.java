package com.skypowgb.digcircuitsim.logic.wires;

import com.skypowgb.digcircuitsim.logic.wires.WireLine;

import java.util.ArrayList;

public class WireLinePartsList {
    private ArrayList<WireLine> wireLines =new ArrayList<>();

    public ArrayList<WireLine> getLines() {
        return wireLines;
    }

    public void addLine(WireLine ln){
        wireLines.add(ln);
    }

    public void setLines(ArrayList<WireLine> wireLines) {
        this.wireLines = wireLines;
    }

    public WireLine getLine(int x){
        return wireLines.get(x);
    }
}
