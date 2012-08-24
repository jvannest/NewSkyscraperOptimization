import java.util.*;

import processing.core.PApplet;
import processing.opengl.*;
import anar.*;
import voronoi.*;

public class testFloor extends PApplet{
	
	//PApplet parent; // The parent PApplet that we will render ourselves onto
	//Level level;
	//LevelStack levels;
	
	int thickness = 12;
	int width =100;
	int length=100;
	Simplex numbers;

	Pnt[] floor = new Pnt[8];
	Pnt[] flrHole = new Pnt[8];
	Pnt[] eHole = new Pnt[8];
	
	public void setup(){
	    size(800,400,OPENGL);
	    Anar.init(this);
	    Anar.drawAxis();
	    initForm();
	}
	
	void floorPoints(){
		
		floor[0].add(new Pnt(-(width/2), length/2, 0));
		floor[1].add(new Pnt(-(width/2), -(length/2), 0));
		floor[2].add(new Pnt(width/2, -(length/2), 0));
		floor[3].add(new Pnt(width/2, length/2, 0));
		floor[4].add(new Pnt(-(width/2), length/2, thickness));
		floor[5].add(new Pnt(-(width/2), -(length/2), thickness));
		floor[6].add(new Pnt(width/2, -(length/2), thickness));
		floor[7].add(new Pnt(width/2, length/2, thickness));
		for(int x =0; x<8; x++){
			numbers.add(floor[x]);
		}
	}
	
	void stairHole(){
		flrHole[0].add(new Pnt(-49, 0, 0));
		flrHole[1].add(new Pnt(-49, -12, 0));
		flrHole[2].add(new Pnt(-37, -12, 0));
		flrHole[3].add(new Pnt(-37, 0, 0));
		flrHole[4].add(new Pnt(-49, 0, thickness));
		flrHole[5].add(new Pnt(-49, -12, thickness));
		flrHole[6].add(new Pnt(-37, -12, thickness));
		flrHole[7].add(new Pnt(-37, 0, thickness));
		for(int x = 0;x<8; x++){
			numbers.add(flrHole[x]);
		}
	}
	
	void elevatorHole(){
		eHole[0].add(new Pnt(-49, -13, 0));
		eHole[1].add(new Pnt(-49, -19, 0));
		eHole[2].add(new Pnt(-43, -19, 0));
		eHole[3].add(new Pnt(-43, -13, 0));
		eHole[4].add(new Pnt(-49, -13, thickness));
		eHole[5].add(new Pnt(-49, -19, thickness));
		eHole[6].add(new Pnt(-43, -19, thickness));
		eHole[7].add(new Pnt(-43, -13, thickness));
		for(int x=0;x<8; x++){
			numbers.add(eHole[x]);
		}
	}
	
	void initForm(){
		floorPoints();
		stairHole();
		elevatorHole();
		Triangulation floor = new Triangulation(numbers);
	}
	

	
	public void draw() {
		background(250);
	}
}
	