package hw5;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;


public class PolygonTest {

	@Test
	public void test()  throws Exception{
		ArrayList<Point> al = new ArrayList<Point>();
		al.add( new Point(0,0));
		al.add( new Point(0,15)); 
		al.add( new Point(30,0));
		Polygon p = new Polygon (al, new TriangleAreaCalc());
		System.out.println("Area:  "+p.getArea());
		
		System.out.println("triange,(0,0)(0,15)(30,0):  " +p.getArea());// triangle area
		System.out.println("----");
		p.addPoint( new Point(30,15) );
		p.setAreaCalc( new RectangleAreaCalc());
		System.out.println("Area:  "+p.getArea());		
		System.out.println("rectange,(0,0 )(0,15)(30,0)(30,15):  " +p.getArea()); // rectangle area
		System.out.println("---");
		System.out.println("----------------------------------Test1 end------------------------------------------------------------------");
		
		assertTrue(true);

	}
	
	@Test
	public void polygonArrayListAndAreaPrintout()  throws Exception{
		//Take array list set 1
		ArrayList<Point> al1 = new ArrayList<Point>();
		al1.add(new Point(11,10));
		al1.add(new Point(11,25)); 
		al1.add(new Point(26,10));
		
		//take second arraylist set
		ArrayList<Point> al2 = new ArrayList<Point>();
		al2.add( new Point(10,10));
		al2.add( new Point(10,26)); 
		al2.add( new Point(45,26));
		
		//create arraylist of polygon
		ArrayList<Polygon> p = new ArrayList<Polygon>();
		//Polygon p = new Polygon (al, new TriangleAreaCalc());
		//add triangle and rectangle using two different point list
		p.add(new Polygon(al1, new TriangleAreaCalc()));//polygon 1 triangle
		al1.add(new Point(26,25));
		p.add(new Polygon(al1,new RectangleAreaCalc()));//polygon 2 rectangle
		p.add(new Polygon(al2, new TriangleAreaCalc()));//polygon 3 triangle
		al2.add(new Point(45,10));
		p.add(new Polygon(al2,new RectangleAreaCalc()));//polygon 3 rectangle.
		
		
		
		Iterator<Polygon> it = p.iterator();
		while( it.hasNext() ){
			Polygon nextP = it.next();
			//System.out.println( nextP.getPoints() );
			System.out.println("Area: "+nextP.getArea());
			System.out.println("---");
			System.out.println(nextP.getAreaCalc()+ " :      "+nextP.getArea()+"     : "+nextP.getPoints());
			System.out.println("---------------------------------------------------");
			
			//System.out.println( nextP.getCentroid() );
			}
		
		assertTrue(true);

	}
	
	

}
