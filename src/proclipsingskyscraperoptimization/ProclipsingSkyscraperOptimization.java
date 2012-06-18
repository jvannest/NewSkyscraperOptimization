
package proclipsingskyscraperoptimization;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import processing.core.PApplet;
import proclipsingskyscraperoptimization.Skyscraper;
import peasy.*;
import controlP5.*;

public class ProclipsingSkyscraperOptimization extends PApplet{
	
	PeasyCam cam;
	ControlP5 controlP5;
	//PMatrix3D currCameraMatrix;
	//PGraphics3D g3; 
	
	Skyscraper mySkyscraper;
	DropdownList cg1, cg2; //Create variable for DropdowLists
	
	

	int numLevels = 15;


	int feet = 12;
	
	int guiWidth = 350;
	int guiHeight = 900;

    
	public void setup() {
		size(1200,900, P3D);
		
		cam = new PeasyCam(this, 300*feet);
		cam.setMinimumDistance(2*feet);
		cam.setMaximumDistance(2000*feet);
		
		controlP5 = new ControlP5(this);
		//PFont p = font = loadFont("Helvetica-15.vlw");
		//controlP5.setControlFont(p);
		  
		mySkyscraper = new Skyscraper(numLevels, this);
		
		setupSliders();
		setupGrid(); //Calling New Method;
	}

	public void draw() {
		background(250);
		prePeasy();
		mySkyscraper.draw();
		
		gui();
	}
	
	void prePeasy(){
		translate(0, 0, -2500);
	}

	void gui() {
		noSmooth();
		//currCameraMatrix = new PMatrix3D(g3.camera);
		camera();
		fill(155);
		noStroke();
		//rect(0, 0, guiWidth, guiHeight);
		controlP5.draw();
		//g3.camera = currCameraMatrix;
	}
	
	void setupSliders() {
		  controlP5.addSlider("VAR 1", 0, 3, 2, 20, 50, 200, 20);
		  controlP5.addSlider("VAR 2", 0, 3, 2, 20, 75, 200, 20);
		  controlP5.addSlider("VAR 3", 0, 4, 3, 20, 100, 200, 20);
		  controlP5.addSlider("VAR 4", 0, 300, 100, 20, 125, 200, 20);
		}
	
	//New Method
	/*GUI for chosing and isolating each line of the Grid. When Grid Line is chosen
	 * then the user will be able to edit its location by using a Slider Bar. Each Line i will be 
	 * "Hosted" to its previous neighbor i-1. This way the Grid_Line will always have a neighbor as
	 * reference to its current location.
	 */
	void setupGrid(){
		cg1 = controlP5.addDropdownList(" Move NS GridLine")
			       .setPosition(20,170)
			       .setSize(100,100);
		cg2 = controlP5.addDropdownList("Move EW GridLine")
				   .setPosition(130,170)
				   .setSize(100,100);
		for(int i=1; i<=ColumnGrid.myNSLines.size(); i++){
			cg1.addItem(" Grid_Line "+i, i-1);
		}
		
		for(int i=65; i<=ColumnGrid.myEWLines.size()+65; i++){
			
			cg2.addItem(" Grid_Line "+(char)i, i-66);
		}
		
		cg1.setIndex(ColumnGrid.myNSLines.size());
		cg2.setIndex(ColumnGrid.myEWLines.size());
		  
	}

}
