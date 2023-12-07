package com.skypowgb.digcircuitsim.gui.visualV2;

import com.skypowgb.digcircuitsim.gui.parts.Workspace;
import com.skypowgb.digcircuitsim.logic.helpers.TextureHelper;
import com.skypowgb.digcircuitsim.gui.ToolButtons;
import com.skypowgb.digcircuitsim.logic.GuiAEManager;
import com.skypowgb.digcircuitsim.logic.events.NewComponentActionListener;
import com.skypowgb.digcircuitsim.logic.events.ToolBtnActionLister;
import com.skypowgb.digcircuitsim.logic.setup.ToolsE;
import com.skypowgb.digcircuitsim.model.setup.ComponentClassNamesE;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GuiV2 {
    //***********************************PRESETS***********************************************************
    //----------------------------------------------------------------------------------------------------
    private static final Dimension WINDOW_SMALL_DIM=new Dimension(1200,700);
    private static final Dimension WORKSPACE_MIN_DIM=new Dimension(500,500);
    public static final Dimension CONTROL_BTN_DIM = new Dimension(50,50);
    public static int PIN_SIZE=20;
    public static int PIN_CLR=5;
    private static Dimension SIDEMENU_DIM;

    //----------------------------------------------------------------------------------------------------
    private static final int SIDE_BAR_WIDTH=100;
    private static final int UPPER_PANEL_HEIGHT=100;

    private static final int COMP_CTRL_BTN_H=25;
public static final Dimension COMP_CONTROL_BTN_DIM=new Dimension(COMP_CTRL_BTN_H,COMP_CTRL_BTN_H);
    private static final int NEW_COMPONENT_BTN_HEIGHT=50;
    //----------------------------------------------------------------------------------------------------
    //***************************************************************************************************

    JFrame window;
    ArrayList<JButton> newComponentButtons =new ArrayList<>();
    ArrayList<JButton> upperToolButtons=new ArrayList<>();
    ArrayList<JButton> upperFileButtons=new ArrayList<>();

    JPanel workspace ;


    public void runGui(){

        JFrame window = new JFrame();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        window.setLayout(new BorderLayout());
        SIDEMENU_DIM=new Dimension(SIDE_BAR_WIDTH,window.getHeight()-UPPER_PANEL_HEIGHT);

        Workspace workspace = new Workspace();
workspace.setLayout(null);

        GuiAEManager guiManager=new GuiAEManager(window,workspace);

        JScrollPane workspaceHolder=new JScrollPane(workspace);

        JPanel upperPanel= new JPanel();
        upperPanel.setPreferredSize(new Dimension(window.getWidth(),UPPER_PANEL_HEIGHT));
        upperPanel.setLayout(new BorderLayout());

        JPanel fileControlPanel= new JPanel();
        fileControlPanel.setPreferredSize(new Dimension(SIDE_BAR_WIDTH,UPPER_PANEL_HEIGHT));

upperPanel.add(fileControlPanel,BorderLayout.WEST);

JPanel toolPanel=new JPanel();
toolPanel.setBackground(Color.gray);
    toolPanel.setLayout(new BoxLayout(toolPanel,BoxLayout.X_AXIS));

        toolPanel.setPreferredSize(new Dimension(window.getWidth(),UPPER_PANEL_HEIGHT));
        ToolBtnActionLister toolSelector=new ToolBtnActionLister();

        for (ToolsE e:ToolsE.values()) {

            JButton toolBtn=new JButton();
ToolButtons.toolButtons.add(toolBtn);
            toolBtn.setPreferredSize(CONTROL_BTN_DIM);
            toolBtn.setName(e.toString());
            toolBtn.addActionListener(toolSelector);
toolBtn.setBackground(Color.gray);
            toolBtn.setIcon(TextureHelper.getControlBtnIcon(e,CONTROL_BTN_DIM.width,CONTROL_BTN_DIM.height));
            toolPanel.add(toolBtn);

        }




    upperPanel.add(toolPanel,BorderLayout.CENTER);
upperPanel.repaint();


        JPanel palette=new JPanel();
        palette.setPreferredSize(SIDEMENU_DIM);


palette.setBackground(Color.gray);
palette.setLayout(new BoxLayout(palette,BoxLayout.Y_AXIS));

        NewComponentActionListener newComp =new NewComponentActionListener();

    for(ComponentClassNamesE name:ComponentClassNamesE.values()){
        JButton newComponentBtn=new JButton();
       newComponentBtn.setIcon(TextureHelper.getNewCompBtnIcon(name,SIDE_BAR_WIDTH,NEW_COMPONENT_BTN_HEIGHT));
       newComponentBtn.setName(name.toString());
       newComponentBtn.addActionListener(newComp);

       newComponentBtn.setBackground(Color.gray);
        palette.add(newComponentBtn);
    }




        JScrollPane sideMenu=new JScrollPane(palette);
        sideMenu.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
sideMenu.setPreferredSize(SIDEMENU_DIM);
window.add(upperPanel,BorderLayout.NORTH);
window.add(sideMenu,BorderLayout.WEST);
window.add(workspace,BorderLayout.CENTER);
window.setSize(1200,700);
        window.setVisible(true);

    }


}
