package proclipsingskyscraperoptimization;

import processing.core.PApplet;

public class Beam {
	
	PApplet parent;
	
	Column myColumn;
	Columns myColumns;
	ColumnGrid myColumnGrid;
	ColumnGridLine myColGridLine;
	//Level myLevel;
	int myLevel;
	
	float EWxb, NSxb, cw;//yb, zb, cw;
	int bw,ft, EWDist, NSDist;
	static int feet = 12;
	static int depth = 1*feet;

	Beam(int flthickness, int b, int l, Column col, ColumnGridLine ew, ColumnGridLine ns, int ewdist, int nsdist, PApplet p){
		ft = flthickness;
		cw= col.w;
		bw = b;
		parent = p;
		myLevel = l;
		myColumn = col;
		EWxb=ew.dist-cw;
		NSxb=ns.dist-cw;
		EWDist = ewdist;
		NSDist = nsdist;
	}
	
	void drawBeam(){
		drawEWBeam();
		drawNSBeam();
	}
	
	
	void drawEWBeam(){
		setColors();
    	parent.pushMatrix();
    	parent.translate((EWxb/2)+(cw/2)+NSDist-(bw/2), EWDist-(bw/2), myLevel-ft); 
    	parent.box(EWxb, depth, depth); 
    	parent.popMatrix();
	}
	
	void drawNSBeam(){
		setColors();
    	parent.pushMatrix();
    	parent.translate(EWDist-(bw/2), (NSxb/2)+(cw/2)+NSDist-(bw/2), myLevel-ft); 
    	parent.box(depth, NSxb, depth); 
    	parent.popMatrix();
	}
	
	void setColors() {
		parent.stroke(55);  
    	parent.fill(250,0,0,155);
	}
	
	int getDepth() {
		return depth;
	}

}
