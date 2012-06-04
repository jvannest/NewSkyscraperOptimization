/*
 *  
 * 
*/

package proclipsingskyscraperoptimization;

import processing.core.PApplet;
import proclipsingskyscraperoptimization.Skyscraper;
import peasy.*;
import controlP5.*;

public class ProclipsingSkyscraperOptimization extends PApplet {
	
	PeasyCam cam;
	ControlP5 controlP5;
	//PMatrix3D currCameraMatrix;
	//PGraphics3D g3; 
	
	Skyscraper mySkyscraper;

	int numLevels = 34;


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
	}

	public void draw() {
		background(250);
		prePeasy();
		mySkyscraper.draw();
		
		gui();
	}
	
public void betterGUI(){
  //Fake Method  	
    }
	void prePeasy(){
		translate(0, 0, -2500);
	}

	void gui() {
		noSmooth();
		//this is a comment
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

}
