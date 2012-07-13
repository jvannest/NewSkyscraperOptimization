package proclipsingskyscraperoptimization;

import proclipsingskyscraperoptimization.LevelStack;
import processing.core.PApplet;


public class Skyscraper {

    float x;
    float y;
    float radius;
    
    int feet = 12;
    
    int skyscraperWidth = 100*feet;
    int skyscraperDepth = 100*feet;
    int colSize, rowSize;
    
    PApplet parent; // The parent PApplet that we will render ourselves onto
    
    LevelStack myLevelStack;
    ColumnGrid myColumnGrid;
    Columns myColumns;
    Floor[] myFloors;
    Column[][] myColumn;

    public Skyscraper ( int numLevels, PApplet p){
    	parent = p;
    	myLevelStack = new LevelStack(numLevels, parent); 
    	myColumnGrid = new ColumnGrid(skyscraperWidth, skyscraperDepth, parent); 
    	initFloors(numLevels, parent);
    	initColumn(parent);
    }
  
    public void draw(){
    	myLevelStack.drawStack();
    	myColumnGrid.drawGrid();
    	drawFloors();
    	drawColumns();
    	//myStairs.draw();
    }
    
   public void initFloors( int numLevels, PApplet p ){
    	myFloors = new Floor[numLevels];
    	parent = p;
    	for(int i=0; i<numLevels; i++){
    	myFloors[i] = new Floor( (Level) myLevelStack.myLevels.get(i), p);
    	}
    }
   
   public void initColumn(PApplet p){
	   parent = p;
	   colSize = myColumnGrid.myNSLines.size();
	   rowSize = myColumnGrid.myEWLines.size();
	   ColumnGridLine l,k;
	   myColumn = new Column[colSize][rowSize];
	   for(int i = 0; i<colSize; i++){
		   for (int j = 0; j<rowSize; j++){
			   k = (ColumnGridLine) myColumnGrid.myNSLines.get(i);
			   l = (ColumnGridLine) myColumnGrid.myNSLines.get(j);
			   System.out.println("["+i+"] "+"["+j+"] :"+k.dist+","+l.dist);
			   myColumn[i][j] = new Column(k.dist, l.dist, p);
		   }
	   }
   }
    
    public void drawFloors(){
    	for(int i=0; i<myFloors.length; i++){
    		myFloors[i].drawFloor();
    	}
    }
    
    public void drawColumns(){
    	for(int i = 0; i<colSize; i++){
 		   for (int j = 0; j<rowSize; j++){
 			   myColumn[i][j].drawColumn();
 		   }
 	   }
    }
}
