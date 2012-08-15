package proclipsingskyscraperoptimization;

import java.util.ArrayList;

import processing.core.PApplet;

public class Beams {
	
	PApplet parent;
	ArrayList<ArrayList<ArrayList<Beam>>> NSBeamLvl, EWBeamLvl;
	ArrayList<ArrayList<Beam>> NSBeamRow, EWBeamRow;
	ArrayList<Beam> NSBeamCol, EWBeamCol;
	ArrayList myColumnsA;
	Column myColumn;
	Columns myColumns;
	LevelStack myLevelStack;
	ColumnGridLine ColGrid;
	ColumnGridLine ew,ns;
	ColumnGrid ColLines;
	Floor flr;
	int x,y,z,skyscraperWidth,typicalLevelD;

	public Beams(int leveltd, ArrayList CGLEW, ArrayList CGLNS, int bRow, int bColumn, ArrayList<ArrayList<ArrayList<Column>>> col, int numLvls, int sWidth, PApplet p){
		parent = p;
		x = bRow;
		y = bColumn;
		z = numLvls;
		typicalLevelD = leveltd;
		skyscraperWidth = sWidth;
		NSBeamLvl = new ArrayList<ArrayList<ArrayList<Beam>>>(z);
		EWBeamLvl = new ArrayList<ArrayList<ArrayList<Beam>>>(z);
		for (int i=0; i<z; i++){
    		NSBeamRow = new ArrayList<ArrayList<Beam>>(x);
    		EWBeamRow = new ArrayList<ArrayList<Beam>>(x);
			for(int j=0; j<x; j++){
				NSBeamCol = new ArrayList<Beam>(y);
				EWBeamCol = new ArrayList<Beam>(y);
				for(int k=0; k<y; k++){
					ew = (ColumnGridLine)CGLEW.get(j);
					ns = (ColumnGridLine)CGLNS.get(k);
    				NSBeamCol.add(new Beam(12, skyscraperWidth, myLevelStack.typicalLevelHeight*(i+1), (Column)col.get(i).get(j).get(k), (ColumnGridLine)CGLEW.get(j), (ColumnGridLine)CGLNS.get(j), ew.dist*k, ns.dist*j, parent));
    				EWBeamCol.add(new Beam(12, skyscraperWidth, myLevelStack.typicalLevelHeight*(i+1), (Column)col.get(i).get(j).get(k), (ColumnGridLine)CGLEW.get(j), (ColumnGridLine)CGLNS.get(j), ew.dist*k, ns.dist*j, parent));
    			}
    			NSBeamRow.add(NSBeamCol);
    			EWBeamRow.add(EWBeamCol);
    			//myColumns.add( new Column( ColGrid, ColGrid.dist, parent));
    		}
			NSBeamLvl.add(NSBeamRow);
			EWBeamLvl.add(EWBeamRow);
    	}
		
	}
    
    public void drawBeams(){
    	parent.pushMatrix();
    	parent.translate(-skyscraperWidth, 0);
    	for(int i = 0; i<z; i++){
  		   for (int j = 0; j<x; j++){
  			   for (int k=0; k<y; k++){
  				  NSBeamLvl.get(i).get(j).get(k).drawNSBeam();
  				  parent.pushMatrix();
  				  EWBeamLvl.get(i).get(j).get(k).drawEWBeam();
  				  parent.popMatrix();
  			   }
  		   }
  	   }
    	parent.popMatrix();
    }
}
