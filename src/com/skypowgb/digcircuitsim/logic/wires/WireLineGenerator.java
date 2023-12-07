package com.skypowgb.digcircuitsim.logic.wires;

import com.skypowgb.digcircuitsim.logic.data.Storage;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualDigitalComponent;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualPin;
import com.skypowgb.digcircuitsim.logic.visualcomponents.VisualWire;
import com.skypowgb.digcircuitsim.model.Whire;

import java.awt.*;

public class WireLineGenerator {

   static Point pointA;
   static Point pointB;

   static VisualWire wireTemp;
    public static void generateWireLinePoints(VisualWire wire ){
System.out.println("generating whire lines");
        pointA=wire.getPin1TruePosition();
        pointB=wire.getPin2TruePosition();
        wireTemp=wire;
generate();
    }
    private static  int SPACING=50;
    private static void generate(){
        int hlpCompX=pointA.x+pointB.x;
        int hlpCompY=pointA.y+pointB.y;
SPACING=250;
        //tocke direktno
        if(pointA.y==pointB.y){generateStraightX();}

       else if(pointA.x==pointB.x){generateStraightY();}

       //tocke udaljene po x vise nego po y
       else if(pointA.x<pointB.x ){generateByXNegative();}
       else if(pointA.x>pointB.x ){generateByXPositive();}

       //tocke udaljene po y vise nego po x
       else if(pointA.y<pointB.y ){generateByXNegative();}
       else if(pointA.y>pointB.y ){generateByXPositive();}


    }
    private static void generateStraightX(){
        WireLine ln=new WireLine(pointA,pointB,wireTemp);
        WireLinePartsList lines=new WireLinePartsList();
        lines.addLine(ln);
        Storage.wireLines.add(lines);
        System.out.println("generating whire x straight");
    }
    private static void generateStraightY(){
        WireLine ln=new WireLine(pointA,pointB,wireTemp);
        WireLinePartsList lines=new WireLinePartsList();
        lines.addLine(ln);
        Storage.wireLines.add(lines);
        System.out.println("generating whire y straight");
    }
    private static void generateByXPositive(){
if((pointB.x-pointA.x)<SPACING){

    System.out.println("generating whire x positive-nospace");
    generateByXPositiveNoSpace();
    return;
}
        System.out.println("generating whire x positive");
Point pointC=new Point(pointB.x-SPACING,pointA.y);
Point pointD=new Point(pointC.x,pointB.y);

WireLine ln1=new WireLine(pointA,pointC,wireTemp);
WireLine ln2=new WireLine(pointC,pointD,wireTemp);
WireLine ln3=new WireLine(pointD,pointB,wireTemp);
WireLinePartsList lineGroup=new WireLinePartsList();
lineGroup.addLine(ln1);
lineGroup.addLine(ln2);
lineGroup.addLine(ln3);

        Storage.wireLines.add(lineGroup);
        System.out.println("generating whire x positive");
    }
    private static void generateByXPositiveNoSpace(){
        int space=SPACING;
        while((pointB.x-pointA.x)<space){
            space=space/2;
            if(space<2){space=1; break;}
        }
        Point pointC=new Point(pointB.x-space,pointA.y);
        Point pointD=new Point(pointC.x,pointB.y);

        WireLine ln1=new WireLine(pointA,pointC,wireTemp);
        WireLine ln2=new WireLine(pointC,pointD,wireTemp);
        WireLine ln3=new WireLine(pointD,pointB,wireTemp);
        WireLinePartsList lineGroup=new WireLinePartsList();
        lineGroup.addLine(ln1);
        lineGroup.addLine(ln2);
        lineGroup.addLine(ln3);
        Storage.wireLines.add(lineGroup);

    }
    private static void generateByXNegative(){
        if((pointA.x-pointB.x)<SPACING){
            System.out.println("generating whire x negative-nospace");
            generateByXNegativeNoSpace();
            return;
        }
        System.out.println("generating whire x negative");
        Point pointC=new Point(pointA.x-SPACING,pointB.y);
        Point pointD=new Point(pointC.x,pointA.y);

        WireLine ln1=new WireLine(pointB,pointC,wireTemp);
        WireLine ln2=new WireLine(pointC,pointD,wireTemp);
        WireLine ln3=new WireLine(pointD,pointA,wireTemp);
        WireLinePartsList lineGroup=new WireLinePartsList();
        lineGroup.addLine(ln1);
        lineGroup.addLine(ln2);
        lineGroup.addLine(ln3);

        Storage.wireLines.add(lineGroup);

    }
    private static void generateByXNegativeNoSpace(){

        int space=SPACING;
        while((pointA.x-pointB.x)<space){
            space=space/2;
            if(space<2){space=1; break;}
        }
        Point pointC=new Point(pointB.x-space,pointA.y);
        Point pointD=new Point(pointC.x,pointA.y);

        WireLine ln1=new WireLine(pointB,pointC,wireTemp);
        WireLine ln2=new WireLine(pointC,pointD,wireTemp);
        WireLine ln3=new WireLine(pointD,pointA,wireTemp);
        WireLinePartsList lineGroup=new WireLinePartsList();
        lineGroup.addLine(ln1);
        lineGroup.addLine(ln2);
        lineGroup.addLine(ln3);

        Storage.wireLines.add(lineGroup);


    }








    private static void generateByYPositive(){}
    private static void generateByYNegative(){}

}
