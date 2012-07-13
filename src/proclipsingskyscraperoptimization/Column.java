package proclipsingskyscraperoptimization;

import processing.core.PApplet;

import java.util.ArrayList;

public class Column {
	
	PApplet parent; // The parent PApplet that we will render ourselves onto

	//Level base;  // Functionally, the level that the column is on
	//Level top;   // Used to generate the column height
	int base1, top1;
	int feet = 12;
	
	//ColumnGridLine ns;  // All columns occur at Grid line intersections
	//ColumnGridLine ew;
	
	int ns;
	int ew;
	
	float w;  // column width, this is set by user choice of profile
	float d;  // column depth, this is set by user choice of profile
	float h;  // column height, this is a calculated value -- user never directly sets
	
	//float crossSection;  //TODO replace with a sketch or profile
	
	public Column ( /*Level l1, Level l2,*/ int n, int e, PApplet p) {
		parent = p;
		//base = l1;
        //top = l2;
		//base1 = 0;
		//top1 = (14*feet+4)*13;
        ns = n;
        ew = e;
        w = 12;  //TODO set column width by user input
        d = 12;  //TODO set column depth by user input
        //h = top.elevation - base.elevation;
        //h = top1-base1;
      }
	
	
	void drawColumn(){
		setColors();
    	parent.pushMatrix();
    	//parent.translate( -(mySkyscraper.myColumn.w/2), 0, (base.elevation + h/2) ); // CRUD the grid line doesn't know where it is!
    	parent.translate(ns-600, ew-600, 1118); // CRUD the grid line doesn't know where it is!
    	parent.box(w, d, 2236); //to be replaced with extruded sketch of profile
    	parent.popMatrix();
	}
	
    void drawColumnModel(){
    	
    	
    }
    
    void setColors(){
    	parent.stroke(155);  
    	parent.fill(155,155);
    }
    
    void drawColumnData(){
    	
    }
    	
	
}