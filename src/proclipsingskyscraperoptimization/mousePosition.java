package proclipsingskyscraperoptimization;

import controlP5.ControlP5;
import controlP5.ControlWindow;
import processing.core.PApplet;



public class mousePosition extends PApplet{
	
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
	
	public void setup(){
		ctrlWindow = cp5.addControlWindow("controlP5window2",600,100,400,200).show();
		cp5.addSlider("sliderValue1").moveTo(ctrlWindow);
	}
	
	void myWindowTextfield(String theValue) {
		  println("from controlWindow: "+theValue);
	}
	
	 public void draw() {
	      background(255);
	 }
	
}
