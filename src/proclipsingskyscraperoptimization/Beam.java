package proclipsingskyscraperoptimization;

import processing.core.PApplet;

public class Beam {
	
	PApplet parent;
	
	Column myColumn;
	ColumnGrid myColumnGrid;
	Level myLevel;
	
	float xb, yb, zb, cw;
	int bw,ft;
	static int feet = 12;

	Beam(int flthickness, int b, Level l, Column col, PApplet p){
		ft = flthickness;
		cw= col.w;
		bw = b;
		parent = p;
		myLevel = l;
		myColumn = col;
		xb=(myColumnGrid.typicalGridDist)-(cw);
		yb=1*feet;
		zb=1*feet;
	}
	
	void drawBeam(){
		drawBeamStruct();
	}
	
	
	void drawBeamStruct(){
		setColors();
    	parent.pushMatrix();
    	parent.translate((xb/2)+(cw/2)+myColumn.ns-(bw/2), myColumn.ew-(bw/2), myLevel.elevation-ft); 
    	parent.box(xb, yb, zb); 
    	parent.popMatrix();
	}
	
	void setColors() {
		parent.stroke(55);  
    	parent.fill(250,0,0,155);
	}

}
