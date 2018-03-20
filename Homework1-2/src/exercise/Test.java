package exercise;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import exercise.ex1.*;
import exercise.ex2.*;
import exercise.ex3.OutState;


public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//int x = (Integer) null;
		
		//System.out.println(DVDPlayer.getInstance().getState());
		//ex2............................
		ArrayList<Polygon> p = new ArrayList<Polygon>();
		p.add( new Triangle( new Point(0,0),new Point(2,2),new Point(1,3) ));		
		p.add( new Rectangle ( new Point(0,0),new Point(2,2),new Point(1,3), new Point(4,4)));
		Iterator<Polygon> it = p.iterator();
		while( it.hasNext() ){
			Polygon nextP = it.next();
			System.out.println( nextP.getPoints() );
			System.out.println( nextP.getArea() );
			//System.out.println( nextP.getCentroid() );
			}
		
		
		//ex1.......................................
		ArrayList<Student> students = new ArrayList<Student>();
		students.add( new OutStateStudent(2000) );
		students.add( new InStateStudent(1000) );
		students.add( new IntlStudent(3000) );
		Iterator<Student> it1 = students.iterator();
		while( it1.hasNext() )
			System.out.println( it1.next().getTuition() );
		
//		ArrayList<Student> al = new ArrayList<Student>();
//		al.add( new OutStateStudent(2000) );
//		System.out.println( al.get(0).getTuition() );
		
//		ArrayList al = new ArrayList();
//		al.add( new OutStateStudent(2000) );
//		System.out.println( al.get(0).getTuition());
		
		//ex3...............................................
		
		exercise.ex3.Student s1 = new exercise.ex3.Student(new OutState(30000000),"John Smith");
		System.out.println(s1.getTuition());
		s1.setStatus( new OutState(100000000) );
		System.out.println(s1.getTuition());
		
		exercise.ex4.Student s2 = new exercise.ex4.Student(new OutState(30),"John Smith");
		System.out.println(s2.getTuition());
		s2.setStatus( new OutState(10) );
		System.out.println(s2.getTuition());
	}

}