package Ex1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class PolynomTest {
	public final static double EPS = 0.00001;

	@Test

    public void testPolynomcons() {
       
        Polynom p=new Polynom("2x^2+3x+2");

        Polynom p1 =new Polynom("2x^2+3x+2");

        if (!p.equals(p1)) {

            fail("ERR - problem with equals method the polynoms should be the same (equals)");

        }

    }
	
	
	@Test

    public void testPolynomString() {
        String s= "3.0x^3+2.0x^2+x+1.0"; 
        Polynom p = new Polynom(s);
        String s1 = p.toString();

        Polynom p1 = new Polynom(s1);

        if (!p.equals(p1)) {

            fail("ERR - related to the Polynom(String) init: the polynoms should be the same (equals)");

        }
	}
	
	
	
	@Test

    public void testPolynomtoString() {
        String s= "3.0x^3+2.0x^2+x+1.0"; 
        Polynom p = new Polynom(s);
        String s1 = p.toString();

        Polynom p1 = new Polynom(s1);

        if (!s1.equals(s)) {

            fail("ERR - related to the Polynom(String) init: the polynoms should be the same (equals)");

        }
	}
        
        
        @Test

        public void testAddMonom() {

            Polynom p1 = new Polynom("2x^2");
            Monom m= new Monom("2x^2");
            Monom m1= new Monom("2x");
            p1.add(m);
            p1.add(m1);
            Polynom p=new Polynom("4.0x^2+2.0x");

            

            if (!p1.equals(p)) {

                fail("ERR - the polynoms should be the same (equals)");

            }

        }
        
        
        public void testAddPolynom() {

            Polynom p1 = new Polynom("2x^2+x+2");

            Polynom p2 = new Polynom("2x^2+x+2");

            Polynom p3 = new Polynom("x^3");

            p1.add(p2);

            p1.add(p3);

            

            Polynom p4= new Polynom("x^3+4x^2+2x+4");

            if (!p1.equals(p4) ){

                fail("ERR - the polynoms should be the same");

            }

        }
        
        @Test

        public void testMultiplyPolynom() {

            Polynom p1 = new Polynom("x+1");

            Polynom p2 = new Polynom("x+2");

            Polynom p3 = new Polynom("x^2+3x+2");

            p2.multiply(p1);

            if(!p3.equals(p2)){

                fail("polynoms Should be the same error in method multiply");

            }

        }
        
        
        @Test

        public void testEqualsPolynom() {

            Polynom p1 = new Polynom("2x^2+3x^1+4x^5");

            Polynom p2 = new Polynom("2x^2+3x^1+4x^5");




            if (!(p1.equals(p2))) {

                fail("error in method equals Polynoms should be the same");

            }

        }
        
        
        @Test

        public void testIsZero() {

            Polynom p1 = new Polynom();

            assertTrue("ERR -> " + p1 + " is Zero", p1.isZero());

        }
        
        
        @Test

        public void testF() {

            Polynom p1 = new Polynom("2x^2+x+2");

            double x = 2;

            double y = 12;
        

          
            
            assertEquals(  p1.f(x),y,EPS);
        }
        
        @Test

    	public void testDerivative() {

    		double cof = -2.5;

    		int pow = 5;

    		Monom m1 = new Monom(cof,pow);

    		Monom m2 = new Monom(m1.derivative());

    		

    		double cof2 = cof*m1.get_power();

    		int pow2 = m1.get_power()-1;

    		


    		assertEquals(m2.get_coefficient(),cof2,EPS);

    		assertEquals(m2.get_power(),pow2,EPS);

    	}
        
        
        @Test
        public void testmultiplymonom()
        {
        	Polynom p = new Polynom("2x^2+2");
        	Monom m= new Monom("x^3");
        	p.multiply(m);
        	Polynom p1= new Polynom("2x^5+2x^3");
        	if(!(p1.equals(p)))
        	{
        		 fail("error in method multiply polynoms should be the same");

        	}
        }


	
        @Test

        public void testRoot1() {

          
            String[] spolynoms = {"x^3+2","x^5-12","20x^5-20"};

            Polynom p=new Polynom(spolynoms[0]);
            Polynom p1=new Polynom(spolynoms[1]);
            Polynom p2=new Polynom(spolynoms[2]);

               

            

            

               

                
                double root2 = p1.root(-100,100,EPS);
                double ans2 = p1.f(root2);
                assertEquals("Should be 0 ", ans2, 0,EPS*100);
                double root1 = p.root(-100,100,EPS);

                double ans1 = p.f(root1);
                assertEquals("Should be 0 ", ans1, 0,EPS*100);

                double root3 = p2.root(-100,100,EPS);
                double ans3 = p2.f(root3);
                assertEquals("Should be 0 ", ans3, 0,EPS*100);


            }

    
        @Test

        public void testroot2(){
        String s = "3x^2+5";
        try {
        Polynom p = new Polynom(s);

      

            p.root(-100, 100, MonomTest.EPS);

        }

     catch (Exception e) {

    }
        
    


}
        
        
        
        @Test

        public void testArea() {

          

            Polynom p1 = new Polynom("x^3-27");

       


            double area1 = p1.area(0,10,MonomTest.EPS);


            double x = 2290.75;







            assertEquals("p1 area isnt the correct result ", x, area1, EPS*1000);



        }
        
        
        
        @Test
        public void testderivativepol()
        {
        	Polynom p1= new Polynom("2x^3+x+1");
        	Polynom p2= new Polynom("6x^2+1");
        	Polynom p3=(Polynom)p1.derivative();
        	
        	if(!(p3.equals(p2)))
        	{
                fail("error in method derivative Polynoms should be the same");

        	}
        }


}

