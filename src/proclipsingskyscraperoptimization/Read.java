package proclipsingskyscraperoptimization;

import java.awt.event.*;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import processing.core.*;



public class Read extends PApplet{
	
	BufferedReader reader;
	String line;
	String[] beamPieces, colPieces, bCPieces;
	ProclipsingSkyscraperOptimization myProclipsing;
	
	public void beamOutput(String file){
		reader = createReader(file);
		  try {
			    while ((line = reader.readLine()) != null){
			    	beamPieces = split(line, ',');
				    int level = Integer.parseInt(beamPieces[0]);
				    String axis = beamPieces[1];
				    String endpoint1 = beamPieces[2];
				    String endpoint2 = beamPieces[3];
				    int beamDepth = Integer.parseInt(beamPieces[4]);
				   
				    //System.out.println("Level: " + level + ", Axis: " + axis + ", Endpoint1: " + endpoint1 + ", Endpoint2: " + endpoint2 + ", Beam Depth: " + beamDepth);
			    }
			  } catch (IOException e) {
			    e.printStackTrace();
			    line = null;
			  }
			  if (line == null) {
			    // Stop reading because of an error or file is empty
			    noLoop();  
			  }
			  
	}
	
	public void colOutput(String file){
		reader = createReader(file);
		try {
			  while ((line = reader.readLine()) != null){
				  colPieces = split(line, ',');
				  String EW = colPieces[0];
				  int EWdist = Integer.parseInt(colPieces[1]);
				  String NS = colPieces[2];
				  int NSdist = Integer.parseInt(colPieces[3]);
				  int lvlNum = Integer.parseInt(colPieces[4]);
				  double lvlDist = Double.parseDouble(colPieces[5]);
				  //System.out.println(EW + " " + EWdist + " " + NS + " " + NSdist + " " + lvlNum + " " + lvlDist);
				  
			  }
			} catch (IOException e) {
			    e.printStackTrace();
			    line = null;
			}
			if (line == null) {
			    // Stop reading because of an error or file is empty
			    noLoop();  
			}
			  
	}
	
	public void beamCost(String file){
		reader = createReader(file);
		try {
			  while ((line = reader.readLine()) != null){
				  bCPieces = split(line, ',');
				  int depth = Integer.parseInt(bCPieces[0]);
			      int minL = Integer.parseInt(bCPieces[1]);
			      int maxL = Integer.parseInt(bCPieces[2]);
			      double cost = Double.parseDouble(bCPieces[3]);
				  //System.out.println(EW + " " + EWdist + " " + NS + " " + NSdist + " " + lvlNum + " " + lvlDist);
				  
			  }
			} catch (IOException e) {
			    e.printStackTrace();
			    line = null;
			}
			if (line == null) {
			    // Stop reading because of an error or file is empty
			    noLoop();  
			}
			  
	}
	
	/*
	 * Beams data structure.
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
	*/
}
