package proclipsingskyscraperoptimization;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import processing.core.PApplet;
import processing.core.PGraphics3D;
import processing.core.PMatrix3D;
import peasy.*;
import processing.opengl.*;
import processing.core.*;
import controlP5.*;

public class peasyCP5 extends PApplet{
	
	PeasyCam cam;
	ControlP5 cp5;
	PMatrix3D currCameraMatrix;
	//PGraphics3D g3;

	int buttonValue = 1;

	int myColor = color(255, 0, 0);

	public void setup() {
		//g3 = (PGraphics3D)g;
	  size(400, 400, P3D);
	  cam = new PeasyCam(this, 100);
	  cp5 = new ControlP5(this);
	  cp5.addButton("button").setId(1);
	  cp5.addButton("buttonValue").setId(2);
	  cp5.setAutoDraw(false);
	}
	public void draw() {

	  background(0);
	  fill(myColor);
	  box(30);
	  pushMatrix();
	  translate(0, 0, 20);
	  fill(0, 0, 255);
	  box(5);
	  popMatrix();
	  // makes the gui stay on top of elements
	  // drawn before.
	 
	  gui();
	  
	}

	void gui() {
	  hint(DISABLE_DEPTH_TEST);
	  cam.beginHUD();
	  cp5.draw();
	  cam.endHUD();
	  hint(ENABLE_DEPTH_TEST);
	}

	void controlEvent(ControlEvent theEvent) {
	  println(theEvent.getController().getId());
	}

	void button(float theValue) {
	  myColor = color(random(255), random(255), random(255));
	  println("a button event. "+theValue);
	}

}
