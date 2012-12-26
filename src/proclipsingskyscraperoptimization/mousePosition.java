package proclipsingskyscraperoptimization;

import controlP5.ControlP5;
import controlP5.ControlWindow;
import processing.core.PApplet;



public class mousePosition {
	
	PApplet parent;
	ControlP5 cp5;
	ControlWindow ctrlWindow;
	
	public mousePosition(PApplet p){
		parent = p;
		cp5 = new ControlP5(parent);
	}
	void myTextfield(String theValue) {
		  println(theValue);
	}
	
	void drawMousePostion(){
		ctrlWindow = cp5.addControlWindow("controlP5window2",600,100,400,200);
		cp5.window("controlP5window").show();
		controlP5.controller("sliderValue1").moveTo(ctrlWindow);
	}
	
	void myWindowTextfield(String theValue) {
		  println("from controlWindow: "+theValue);
	}
	
	void println(Object object){
		System.out.println(object);
	}
	
}
