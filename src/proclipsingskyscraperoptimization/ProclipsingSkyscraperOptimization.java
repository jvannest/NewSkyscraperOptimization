
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
	//MyControlListener MyListener;
	//PMatrix3D currCameraMatrix;
	//PGraphics3D g3; 
	
	Skyscraper mySkyscraper;
	DropdownList cg1, cg2; //Create variable for DropdowLists
	Slider sl1;
	
	
	

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
		//background(MyListener.col);
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
		 //new slider for moving Grid Line
		 sl1 = controlP5.addSlider("EditGridLine")
			            .setRange(100,200)
		 				.setValue(140)
		 				.setPosition(20,300);
	
		 
		//MyListener = new MyControlListener();
		  
		//controlP5.getController("Edit GridLine").addListener(MyListener);
	
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
		cg2 = controlP5.addDropdownList(" Move EW GridLine")
				       .setPosition(130,170)
				       .setSize(100,100);
		
		//MyListener = new MyControlListener();
		//cg1.getController(" Move NS GridLine").addListener(MyListener);	
		
		for(int i=1; i<=ColumnGrid.myNSLines.size(); i++){
			cg1.addItem(" Grid_Line "+i, i-1);
		}
		
		for(int i=65; i<=ColumnGrid.myEWLines.size()+65; i++){
			
			cg2.addItem(" Grid_Line "+(char)i, i-65);
		}
		
		
		
		//cg1.setIndex(ColumnGrid.myNSLines.size());
		//cg2.setIndex(ColumnGrid.myEWLines.size());
		
	}
	//class MyControlListener implements ControlListener {
		//int col;
		  // public void controlEventSlider(ControlEvent theEvent2){ 
			//System.out.println("i got an event from mySlider, " +
			        //  "changing background color to "+
			           // theEvent2.getController().getValue());      
		    			//col = (int)theEvent2.getController().getValue();
		// }
	public void EditGridLine(int theValue){
		System.out.println(theValue);
	}
		
	public void controlEvent(ControlEvent theEvent) {
		  // DropdownList is of type ControlGroup.
		  // A controlEvent will be triggered from inside the ControlGroup class.
		  // therefore you need to check the originator of the Event with
		  // if (theEvent.isGroup())
		  // to avoid an error message thrown by controlP5.

		  if (theEvent.isGroup()) {
		    // check if the Event was triggered from a ControlGroup
		    println("event from group : "+theEvent.getGroup().getValue()+" from "+theEvent.getGroup());
		  } 
		  else if (theEvent.isController()) {
		    println("event from controller : "+theEvent.getController().getValue()+" from "+theEvent.getController());
		   
		  }
		  
		  
		  //Testing Listener and controlEvent
		  if(theEvent.getGroup().getValue() == 1.0 && theEvent.getGroup() == cg1){
			  println("Permission to edit Grid_Line 2 ");
		  }
		  
		  //Connecting the value of the Dropdownlist with the index of the ArrayList value
		  //This is done by using the get() message
		  //Having a problem with the listener still, when I chose a line from the NSLine array
		  //it also picks up the line from the EW this is because the two dropdownlists are using the
		  //same listener I believe.
		  //System.out.println(ColumnGrid.myNSLines.get((int)theEvent.getGroup().getValue()));
		  //System.out.println(ColumnGrid.myEWLines.get((int)theEvent.getGroup().getValue()));
		  int p = (int)theEvent.getGroup().getValue();
		  ColumnGridLine temp;
		  temp = (ColumnGridLine) mySkyscraper.myColumnGrid.myNSLines.get(p);
		  System.out.println(temp.id);
		  System.out.println(mySkyscraper.myColumnGrid.myEWLines.get((int)theEvent.getGroup().getValue()));
	}
          

	}
//}
