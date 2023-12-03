package com.skypowgb.digcircuitsim.logic.data;

import com.skypowgb.digcircuitsim.logic.setup.ToolsE;

public class Tool {

    private String toolName;
    private ToolsE tool;
    private boolean state;

    public Tool(ToolsE tool) {
        this.toolName = tool.toString();
        this.tool = tool;
        state = false;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ToolsE getToolE() {
        return tool;
    }

    public String getToolName() {
        return toolName;
    }

    public void switchState() {
if(state){
    state=false;
}
state=true;

    }



}