package Ex1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ComplexFunctiontest {
	
	public static final double EPSILON = 0.0000001;


	@Test

    public void testComplexFunctionequals() {
       Polynom p=new Polynom("2x^2");
       Polynom p1=new Polynom("2x^2");

       ComplexFunction c=new ComplexFunction(Operation.Plus,p1,p);
       ComplexFunction c1=new ComplexFunction(Operation.Plus,p1,p);

       if(!c1.equals(c))
    	   

       
  

 

            fail("ERR - problem with equals method the ComplexFunctions should be the same (equals)");

        }

	
	
	@Test

    public void testComplexFunctioninit() {
       
       String s="plus(mul(2x^2+3x+2,x),2)";
       Polynom p = new Polynom("2x^2+3x+2");
       Polynom p1 = new Polynom("x");
       ComplexFunction c1=new ComplexFunction(Operation.Times,p,p1);
       Polynom p2= new Polynom("2");
       ComplexFunction c2=new ComplexFunction(Operation.Plus,c1,p2);
       ComplexFunction c3=new ComplexFunction();
       c3=(ComplexFunction)c3.initFromString("plus(mul(2x^2+3x+2,x),2)");
       if(!c3.equals(c2))
    	   

       
  

 

            fail("ERR - problem with init method the ComplexFunctions should be the same (equals)");

        }
	
	@Test

	 public void testComplexFunctiontoString() {
	       String s="plus(mul(2.0x^2+3.0x+2.0,x),2.0)";
	       
	       ComplexFunction c3=new ComplexFunction();
	       c3=(ComplexFunction)c3.initFromString("plus(mul(2x^2+3x+2,x),2)");
	       if(!s.equals(c3.toString()))
	    	   

	       
	  

	 

	            fail("ERR - problem with tostring method the strings should be the same (equals)");

	        }
	 
	 @Test
	 public void testComplexFunctionf() {
	       double i=12;
	       double i2=5;
	       
	       
	       ComplexFunction c3=new ComplexFunction();
	       ComplexFunction c2=new ComplexFunction();
	       c3=(ComplexFunction)c2.initFromString("plus(div(2x,x),3)");

	       
	       c2=(ComplexFunction)c3.initFromString("mul(2x,3)");
	      double j=c3.f(2);
	      double j2=c2.f(2);
	      assertEquals(i2, j,EPSILON);
	      assertEquals(i, j2,EPSILON);


	       
	  
	        }
	 
	 @Test
	 public void testComplexFunctioncopy() {
	    ComplexFunction f= new ComplexFunction();
	    f=(ComplexFunction)f.initFromString("plus(x,x)");
	    ComplexFunction f1=(ComplexFunction)f.copy();
	     if(!f.equals(f1))
	            fail("ERR - problem with copy method the ComplexFunctions should be the same (equals)");

	    	 


	       
	  
	        }
	 
		@Test
		
			public void testComplexFunctionplus() {
			    ComplexFunction f= new ComplexFunction();
			    f=(ComplexFunction)f.initFromString("plus(x,x)");
			    ComplexFunction f2= new ComplexFunction();
			    f2=(ComplexFunction)f.initFromString("x^2");
			    ComplexFunction f3= new ComplexFunction();
			    f3=(ComplexFunction)f.initFromString("plus(plus(x,x),x^2)");
			    f.plus(f2);
			    if(!f3.equals(f))
		            fail("ERR - problem with plus method the ComplexFunctions should be the same (equals)");

			    	 


			       
			  
			        }
		
		
		@Test
		
		public void testComplexFunctionTimes() {
		    ComplexFunction f= new ComplexFunction();
		    f=(ComplexFunction)f.initFromString("plus(x,x)");
		    ComplexFunction f2= new ComplexFunction();
		    f2=(ComplexFunction)f.initFromString("x^2");
		    ComplexFunction f3= new ComplexFunction();
		    f3=(ComplexFunction)f.initFromString("mul(plus(x,x),x^2)");
		    f.mul(f2);
		    if(!f3.equals(f))
	            fail("ERR - problem with mul method the ComplexFunctions should be the same (equals)");

		    	 


		       
		  
		        }
		
		
		@Test
		public void testComplexFunctiondiv() {
		    ComplexFunction f= new ComplexFunction();
		    f=(ComplexFunction)f.initFromString("plus(x,x)");
		    ComplexFunction f2= new ComplexFunction();
		    f2=(ComplexFunction)f.initFromString("x^2");
		    ComplexFunction f3= new ComplexFunction();
		    f3=(ComplexFunction)f.initFromString("div(plus(x,x),x^2)");
		    f.div(f2);
		    if(!f3.equals(f))
	            fail("ERR - problem with div method the ComplexFunctions should be the same (equals)");

		    	 


		       
		  
		        }
		

		@Test
		public void testComplexFunctionmin() {
		    ComplexFunction f= new ComplexFunction();
		    f=(ComplexFunction)f.initFromString("plus(x,x)");
		    ComplexFunction f2= new ComplexFunction();
		    f2=(ComplexFunction)f.initFromString("x^2");
		    ComplexFunction f3= new ComplexFunction();
		    f3=(ComplexFunction)f.initFromString("min(plus(x,x),x^2)");
		    f.min(f2);
		    if(!f3.equals(f))
	            fail("ERR - problem with min method the ComplexFunctions should be the same (equals)");

		    	 


		       
		  
		        }
		
		

		@Test
		public void testComplexFunctionmax() {
		    ComplexFunction f= new ComplexFunction();
		    f=(ComplexFunction)f.initFromString("plus(x,x)");
		    ComplexFunction f2= new ComplexFunction();
		    f2=(ComplexFunction)f.initFromString("x^2");
		    ComplexFunction f3= new ComplexFunction();
		    f3=(ComplexFunction)f.initFromString("max(plus(x,x),x^2)");
		    f.max(f2);
		    if(!f3.equals(f))
	            fail("ERR - problem with max method the ComplexFunctions should be the same (equals)");

		    	 


		       
		  
		        }
		
		

		@Test
		public void testComplexFunctioncomp() {
		    ComplexFunction f= new ComplexFunction();
		    f=(ComplexFunction)f.initFromString("plus(x,x)");
		    ComplexFunction f2= new ComplexFunction();
		    f2=(ComplexFunction)f.initFromString("x^2");
		    ComplexFunction f3= new ComplexFunction();
		    f3=(ComplexFunction)f.initFromString("comp(plus(x,x),x^2)");
		    f.comp(f2);
		    if(!f3.equals(f))
	            fail("ERR - problem with comp method the ComplexFunctions should be the same (equals)");

		    	 


		       
		  
		        }
	
	
	
	
	
		

	 
	 
	 
	 
	 
	 

    }
	


