package proclipsingskyscraperoptimization;

import java.util.ArrayList;
import processing.core.PApplet;

public class Columns {
	
	PApplet parent;
	static ArrayList myColumns;
	ColumnGridLine ColGrid;
	ColumnGrid ColLines;
	
	int x,y;
	
	public Columns(){
		
		myColumns = new ArrayList();
		
		x = ColLines.myNSLines.size();
		y = ColLines.myEWLines.size();
		System.out.println(x);
		System.out.println(y);
		for (int i=0; i<x; i++){
    		for(int j=0; j<y; j++){
    			//myColumns.add( new Column( ColGrid, ColGrid.dist, parent));
    		}
    	}
		
		
	}
	
    public void drawColumnModel(){
    	/*parent.pushMatrix();
    	for (int i=0; i<myColumns.size(); i++){
    		Column g = (Column) myColumns.get(i);
    		g.drawColumn();
    	}
    	parent.popMatrix();*/
    	parent.stroke(155);  
    	parent.fill(155,155);
    	parent.pushMatrix();
    	//parent.translate( -(mySkyscraper.myColumn.w/2), 0, (base.elevation + h/2) ); // CRUD the grid line doesn't know where it is!
    	parent.translate(0, 0, 0); // CRUD the grid line doesn't know where it is!
    	parent.box(10, 10, 2236); //to be replaced with extruded sketch of profile
    	parent.popMatrix();
    }
    
    public void drawColumn(){
    	for (int i=0; i<myColumns.size(); i++){
    		Column g = (Column) myColumns.get(i);
    		g.drawColumnModel();   		
    	}
    	drawColumnModel();
    }
	
}
