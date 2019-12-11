package Ex1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;
/**
 * This class represents a simple (naive) tester for the Monom class, 
 * Note: <br>
 * (i) The class is NOT a JUNIT - (i.e., educational reasons) - should be changed to a proper JUnit in Ex1. <br>
 * (ii) This tester should be extend in order to test ALL the methods and functionality of the Monom class.  <br>
 * (iii) Expected output:  <br>
 * *****  Test1:  *****  <br>
0) 2.0    	isZero: false	 f(0) = 2.0  <br>
1) -1.0x    	isZero: false	 f(1) = -1.0  <br>
2) -3.2x^2    	isZero: false	 f(2) = -12.8  <br>
3) 0    	isZero: true	 f(3) = 0.0  <br>
*****  Test2:  *****  <br>
0) 0    	isZero: true  	eq: true  <br>
1) -1.0    	isZero: false  	eq: true  <br>
2) -1.3x    	isZero: false  	eq: true  <br>
3) -2.2x^2    	isZero: false  	eq: true  <br>
 */
public class MonomTest {
	public final static double EPS = 0.00001;
	@Test

	public void testMonomcons() {

		Monom m1 = new Monom(1,2);

		if(!(m1.get_power()!=2)&&m1.get_coefficient()!=1) {

            fail("JUnit fail: Somthing is wrong with the Monom construction method");

		}

	} Monom m3= new Monom("2x^2");
	
	@Test

	public void testMonomequals() {

        Monom m1 = new Monom(2, 2);

        Monom m2 = new Monom(m1);
       

		if(!m1.equals(m2)) {

            fail("JUnit fail: Somthing is wrong with the Monom copy method");
            
            

		}
	}
		
		@Test

		public void testMonomString() {

			

			Monom m1 = new Monom(2, 2);

			String s = m1.toString();

			Monom m2 = new Monom(s);
			Monom m3=new Monom("2x^2");

			if(!m1.equals(m2)||!m1.equals(m3)) {

				fail("Something is wrong with the String Constructor of the Monom!");

			}

		}
		
		public void testMonomString2() {

			

			

			String[] s = {"x", "x^2","12","2*2^3"};

			for(int i=0;i<s.length;i++) {

				Monom m = new Monom(s[i]);

				if(!(m.get_power()>=0)) {

					fail("Something is wrong with the String Constructor of the Monom! fail on: "+s[i]);

				}

			}

		}
		
		
		
		@Test

		public void testMonomStringfail() {

			double coef = -2.21;

			int pow = 12;

			Monom m1 = new Monom(coef, pow);

			String[] s = {"--ex", "##$$%%xjjhgjh^@2", "12xx.3", "13.1x^-0.3","xx","--x","x^^","x^^2","-x^",

					"4* x^100"};

			for(int i=0;i<s.length;i++) {

				try {

					Monom m = new Monom(s[i]);

					fail("Something is wrong with the String Constructor of the Monom! fail on: "+s[i]);

				}

				catch (Exception e) {

					// all OK

				}

			}
			
		}
			
			
			public void testGetpower() {

				int power = 11;

				Monom m1 = new Monom(2,11);

				if(power!= m1.get_power()) {

					fail("JUnit fail: Somthing is wrong with the get_power() method");

				}

			}

			
			
			public void testGetcoe() {

				int coe = 11;

				Monom m1 = new Monom(11,11);

				if(coe!= m1.get_coefficient()) {

					fail("JUnit fail: Somthing is wrong with the get_coefficient() method");

				}

			}
			
			
			@Test

			public void testAdd() {

				double cof1 = 34.5, cof2 = 10;

				

				Monom m1 = new Monom(cof1,5);

				Monom m2 = new Monom(cof2,5);

				m1.add(m2);

				assertEquals(m1.get_coefficient(), cof1+cof2,EPS);

			}
			
			
			@Test

			public void testfailAdd() {

				double cof1 = 44, cof2 = 100.5;

				

				boolean fail = false;

				Monom m1 = new Monom(cof1,4);

				Monom m2 = new Monom(cof2,3);

				try {

					m1.add(m2);

				}

				catch(RuntimeException e) {

					fail = true;

				}

				assertTrue(fail);

			}
			
			
			@Test

			public void testMultiply() {

				double cof1 = 10, cof2 = 5;

				int pow1 = 4, pow2 = 11;

				Monom m1 = new Monom(cof1,pow1);

				Monom m2 = new Monom(cof2,pow2);

				m1.multipy(m2);

				assertEquals(cof1*cof2,m1.get_coefficient(),EPS);

				assertEquals(m1.get_power(), pow1+pow2);

			}
			
			
			@Test

			public void testEqualsMonom() {

				Monom m1 = new Monom(2,3);

				Monom m2 = new Monom(2,3);

				if(!m1.equals(m2)) {

					fail("JUnit fail: Somthing is wrong with the Monom copy construction or equals method");

				}

				m1 = new Monom(0,2);

				m2 = new Monom(m1);

				if(!m1.equals(m2)) {

					fail("JUnit fail: Somthing is wrong with the Monom copy construction or equals method");

				}

			}
		
			
			public void testsub() {

				double cof1 = 34.5, cof2 = 10;

				

				Monom m1 = new Monom(cof1,5);

				Monom m2 = new Monom(cof2,5);

				m1.sub(m2);

				assertEquals(m1.get_coefficient(), cof1-cof2,EPS);

			}
			
			public void testmoncopy() {

				double cof1 = 34.5;int pow = 10;

				

				Monom m1 = new Monom(cof1,pow);
				Monom m2=(Monom)m1.copy();
				if(m2.get_coefficient()!=cof1||m2.get_power()!=pow)
					fail("JUnit fail: Somthing is wrong with the Monom copy  method");


				

					
			
			

			}
			
			
			public void testderivative()
			{
				double x=2.5;
				int y=3;
				Monom m1=new Monom(x,y);
				
				Monom m2=new Monom(m1.derivative());
				assertEquals(m1.get_coefficient(),(double)x*y,EPS);
				assertEquals(m1.get_power(),y-1);
				
			}
}

