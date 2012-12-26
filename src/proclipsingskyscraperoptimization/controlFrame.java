package proclipsingskyscraperoptimization;
	import controlP5.*;
	import processing.core.*;
	
public class controlFrame extends PApplet{
	 
	  ControlP5 cp5;
	  PApplet parent;
	
	  int w, h;
	  int abc = 250;

	  public controlFrame(PApplet theParent, int theWidth, int theHeight) {
		  parent = theParent;
		  w = theWidth;
		  h = theHeight;
	  }
	  
	  public void setup() {
		  size(w, h);
		  frameRate(25);
		  cp5 = new ControlP5(this);
		  cp5.addSlider("abc").setRange(0, 255).setPosition(10,10).setVisible(true);
		  cp5.addSlider("def").plugTo(this,"def").setRange(0, 255).setPosition(10,30);
	  }

	  public void draw() {
	      background(abc);
	  }
	  
	  


	  public ControlP5 control() {
	    return cp5;
	  }
	  

	  
}
