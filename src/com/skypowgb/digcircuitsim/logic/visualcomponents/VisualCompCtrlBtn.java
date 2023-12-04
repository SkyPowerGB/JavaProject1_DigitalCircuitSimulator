package com.skypowgb.digcircuitsim.logic.visualcomponents;

import com.skypowgb.digcircuitsim.model.setup.ComponentClassNamesE;

import javax.swing.*;

public class VisualCompCtrlBtn extends JButton {
    VisualDigitalComponent comp;
    ComponentClassNamesE classNamesE;
 public   VisualCompCtrlBtn(ComponentClassNamesE classNamesE,VisualDigitalComponent comp){
     this.comp=comp;
     this.classNamesE=classNamesE;
 }

    public VisualDigitalComponent getComp() {
        return comp;
    }



    public ComponentClassNamesE getClassNamesE() {
        return classNamesE;
    }


}
