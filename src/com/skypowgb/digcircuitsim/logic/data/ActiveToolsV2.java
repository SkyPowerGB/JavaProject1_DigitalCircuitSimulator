package com.skypowgb.digcircuitsim.logic.data;

import com.skypowgb.digcircuitsim.logic.setup.ToolsE;

import javax.swing.*;
import java.util.ArrayList;

public class ActiveToolsV2 {
    private static boolean toolsSet=false;
    private static ArrayList<Tool> tools=new ArrayList<Tool>();

public static void setupTools(){
    if(toolsSet){
        return;
    }
    System.out.println("ActiveToolsV2set");
    toolsSet=true;
    for (ToolsE tool:ToolsE.values()) {
        tools.add(new Tool(tool));
    }
}


public static boolean getToolState(ToolsE tool){
setupTools();
  return getTool(tool).getState();

}
public static void setToolState(ToolsE tool,boolean state){
    getTool(tool).setState(state);
}

private static boolean isAnyActiveExcept(ToolsE tool){
   setupTools();
    boolean any=false;
    int i=0;
    for (Tool t:tools) {
        if(t.getState()){
      i++;}
    }
    if(i>1){ error("you can have only one tool active");  return true;}

    if(getTool(tool).getState()||i==0){
        return false;
    }
    return true;
}

public static void switchState(ToolsE toole){
    setupTools();
if(isAnyActiveExcept(toole)){error("You cant have two tools active ->" + getActive()); return;}
Tool mytool=getTool(toole);
  if(mytool.getState()){
      mytool.setState(false);
  }else{mytool.setState(true);}
}

private static ToolsE getActive(){
    for (Tool t:tools) {
        if(t.getState()){return  t.getToolE();}
    }
    error("no acrtive tools");
    return null;
}
public static Tool getTool(ToolsE toolE){
    setupTools();
    for (Tool t:tools) {
        if (t.getToolE() == toolE) {
            return t;
        }
    }
    error("tool not found");
    return null;


}

private static void error(String msg){
    JOptionPane.showMessageDialog(null,msg);
}



}
