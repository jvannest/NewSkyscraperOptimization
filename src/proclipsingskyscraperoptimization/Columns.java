package proclipsingskyscraperoptimization;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Columns {
	
	PApplet parent;
	ArrayList<ArrayList<ArrayList<Column>>> ColumnLvl;
	ArrayList<ArrayList<Column>> ColumnRow;
	ArrayList<Column> ColumnCol;
	ArrayList myColumns;
	ColumnGridLine ColGrid;
	ColumnGridLine ew,ns;
	ColumnGrid ColLines;
	int x,y,z,skyscraperWidth;
	
	public Columns(int cgRow, int cgColumn, LevelStack lvl, int sWidth, ArrayList ewA, ArrayList nsA, PApplet p){
		parent = p;
		x = cgRow;
		y = cgColumn;
		z = lvl.myLevels.size()-1;
		skyscraperWidth = sWidth;
		ColumnLvl = new ArrayList<ArrayList<ArrayList<Column>>>(z);
		for (int i=0; i<z; i++){
    		ColumnRow = new ArrayList<ArrayList<Column>>(x);
			for(int j=0; j<x; j++){
				ColumnCol = new ArrayList<Column>(y);
				for(int k=0; k<y; k++){
					ew = (ColumnGridLine)ewA.get(j);
    				ns = (ColumnGridLine)nsA.get(k);
    				ColumnCol.add(new Column( (Level)lvl.myLevels.get(i+1), (Level)lvl.myLevels.get(i), skyscraperWidth, ns.dist*j, ew.dist*k, parent));
    			}
    			ColumnRow.add(ColumnCol);
    			//myColumns.add( new Column( ColGrid, ColGrid.dist, parent));
    		}
			ColumnLvl.add(ColumnRow);
    	}
		
	}
    
    public void drawColumn(){
    	parent.pushMatrix();
    	parent.translate(-skyscraperWidth, 0);
    	for (int i=0; i<ColumnLvl.size(); i++){
    		for (int j=0; j<ColumnRow.size(); j++){
    			for (int k=0; k<ColumnCol.size(); k++){
    				Column g = (Column) ColumnLvl.get(i).get(j).get(k);
    				g.drawColumn();
    			}
    		}   		
    	}
    	parent.popMatrix();
    }
}
