package Ex1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.RuntimeErrorException;



public class ComplexFunction implements complex_function {
	public static final double EPSILON = 0.0000001;

	Operation op;
	function left;
	function right;

	public ComplexFunction(Operation op, function left , function right) {
		if(op==null)
			throw new RuntimeException("operation cant be null");
	
		this.op=op;
		
		
		
		this.left=left;
		this.right=right;
		
		
	}
	
	public ComplexFunction(function f)
	{
		this.op=Operation.None;
		this.left=f.copy();
		this.right=null;
	}
	
	public ComplexFunction(String s,function f,function r)
	{
		s=s.toLowerCase();
		switch(s)
		{
		case "plus":
		{
			this.left=f;
		    this.right=right;
		    this.op=Operation.Plus;
		    break;
		}
		case "mul":
		{
			this.left=f;
		    this.right=right;
		    this.op=Operation.Times;
		    break;
		}
		case "div":
		{
			this.left=f;
		    this.right=right;
		    this.op=Operation.Divid;
		    break;
		}
		case "max":
		{
			this.left=f;
		    this.right=right;
		    this.op=Operation.Max;
		    break;
		}
		case "min":
		{
			this.left=f;
		    this.right=right;
		    this.op=Operation.Min;
		    break;
		}
		case "comp":
		{
			this.left=f;
		    this.right=right;
		    this.op=Operation.Comp;
		    break;
		}
		case "none":
		{
			this.left=f;
		    this.right=null;
		    this.op=Operation.None;
		    break;
		}
		case"error":
		{
			throw new RuntimeException("error");
		}
		default:{
			throw new RuntimeException("invalid input");

			
		}
			
		}
		
	}

	

	

	public ComplexFunction() {
		
		this.left=null;
		this.right=null;
		this.op=Operation.None;
	}
	
	//10+x

	
	public function initFromString(String s) {
		s=s.toLowerCase();
		
		int i=s.indexOf("plus(");
		
		int i1=s.indexOf("div(");

		int i2=s.indexOf("mul(");

		int i3=s.indexOf("max(");

		int i4=s.indexOf("min(");
		int i5=s.indexOf("comp(");
		int i6=s.indexOf("none(");
		ComplexFunction co=new ComplexFunction();
		//10+x
		if((i!=0&&i1!=0&&i2!=0&&i3!=0&&i4!=0&&i5!=0)||i6==0)
		{
			if(s.contains(","))
			{int j=s.indexOf(",");
				Polynom p=new Polynom(s.substring(0,j));
			
				return new ComplexFunction(Operation.None,p,null);
			}
			else
			{
			Polynom p = new Polynom(s);
			
			return new ComplexFunction(Operation.None,p,null);
			}
		}
		if((i==0||i1==0||i2==0||i3==0||i4==0||i5==0)&&!s.contains(","))
			
		{
			int j=s.indexOf("(");
			Polynom p=new Polynom(s.substring(j+1,s.length()-1));
			
			return new ComplexFunction(Operation.None,p,null);
		}
			
			if(i==0)
			{
				String k=shelp(s.substring(5));
				co=new ComplexFunction(Operation.Plus,initFromString(k),initFromString(s.substring(k.length()+1+5,s.length()-1)));
				
			}
			
			if(i1==0)
			{
				String k=shelp(s.substring(4));
				co=new ComplexFunction(Operation.Divid,initFromString(k),initFromString(s.substring(k.length()+1+4,s.length()-1)));
				
			}
			if(i2==0)
			{
				String k=shelp(s.substring(4));
				co=new ComplexFunction(Operation.Times,initFromString(k),initFromString(s.substring(k.length()+1+4,s.length()-1)));
				
			}
			if(i3==0)
			{
				String k=shelp(s.substring(4));
				co=new ComplexFunction(Operation.Max,initFromString(k),initFromString(s.substring(k.length()+1+4,s.length()-1)));
				
			}
			if(i4==0)
			{
				String k=shelp(s.substring(4));
				co=new ComplexFunction(Operation.Min,initFromString(k),initFromString(s.substring(k.length()+1+4,s.length()-1)));
				
			}
			if(i5==0)
			{
				String k=shelp(s.substring(5));
				co=new ComplexFunction(Operation.Comp,initFromString(k),initFromString(s.substring(k.length()+1+5,s.length()-1)));
				
			}
			
			return co;
		}
		

		
		
		
		
	
		
		

		

		
		
		
		
	

	
	
	

	@Override
	public function copy() {
		ComplexFunction co=new ComplexFunction();
		co=(ComplexFunction)this.initFromString(this.toString());
		
    return co; 
	
	}

	@Override
	public boolean equals(Object m1) {
		// TODO Auto-generated method stub
		if(!(m1 instanceof function)||m1==null)
			return false;
		int c=0;

		if(m1 instanceof Monom)
		{
			Monom m = (Monom)m1;
		
			for(int i=-100;i<=100;i++)
			{
				if(i==0)
					i++;
				if(Math.abs(this.f(i)-m.f(i))>EPSILON)
				{
					return false;
				}
				c++;
			}
		}
		if(m1 instanceof Polynom)
		{
			Polynom p = (Polynom)m1;
			for(int i=-100;i<=100;i++)
			{
				if(i==0)
					i++;
				if(Math.abs(this.f(i)-p.f(i))>EPSILON)
				{
					return false;
				}
				c++;
			}
		}
		
		if(m1 instanceof ComplexFunction)
		{
			ComplexFunction co=(ComplexFunction) m1;
			for(int i=-100;i<=100;i++)
			{
				if(i==0)
					i++;
				if(Math.abs(this.f(i)-co.f(i))>EPSILON)
				{
					return false;
				}
				c++;
			}
			
		}
			if(c==200)
				return true;
			else
				return false;
	
   		
	}

	

	@Override
	public void plus(function f1) {
		// TODO Auto-generated method stub
		
		ComplexFunction c= new ComplexFunction(this.op,this.left,this.right);
		this.op=Operation.Plus;
		this.left=c;
		this.right=f1;
		
		
		
	}

	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub
		ComplexFunction c= new ComplexFunction(this.op,this.left,this.right);
		this.op=Operation.Times;
		this.left=c;
		this.right=f1;
		

	}

	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub
		ComplexFunction c= new ComplexFunction(this.op,this.left,this.right);
		this.op=Operation.Divid;
		this.left=c;
		this.right=f1;
		
	}

	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub
		ComplexFunction c= new ComplexFunction(this.op,this.left,this.right);
		this.op=Operation.Max;
		this.left=c;
		this.right=f1;
	}

	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		ComplexFunction c= new ComplexFunction(this.op,this.left,this.right);
		this.op=Operation.Min;
		this.left=c;
		this.right=f1;
	}
	
	
	public double f(double x)
	{
      Operation o=this.op;
      if((o==Operation.None||this.right==null)&&this.left!=null)
      {
    	  Polynom p = new Polynom(this.left.toString());
		return p.f(x);
      }
		
		
    	  
		
		switch (o) {
		//plus(2x,plus(mul(2x,x),x))
		case Plus:
		{
			if(this.left==null)
		        throw new NullPointerException("error left func is null  cannot be null");
			
			if(this.right==null)
			{
				Polynom p = new Polynom(this.left.toString());
				return p.f(x);
				
			}
			

			
			return this.left.f(x)+this.right.f(x);
		
		}
		case Divid:
		{

			if(this.left==null)
		        throw new NullPointerException("error left func is null  cannot be null");
			
			if(this.right==null)
			{
				Polynom p = new Polynom(this.left.toString());
				return p.f(x);
				
			}

			
			if(this.left.f(x)==0)
				throw new ArithmeticException ("cant div by zero");
			return left.f(x)/right.f(x);

			
			    
			}
		
		case Times:
		

			{

				if(this.left==null)
			        throw new NullPointerException("error left func is null  cannot be null");
				
				if(this.right==null)
				{
					Polynom p = new Polynom(this.left.toString());
					return p.f(x);
					
				}
				
				return this.left.f(x)*this.right.f(x);
			
				
				
				
		}
		case Max:
		{if(this.left==null)
	        throw new NullPointerException("error left func is null  cannot be null");
		
		if(this.right==null)
		{
			Polynom p = new Polynom(this.left.toString());
			return p.f(x);
			
		}
		

		
	
		
		return Math.max(left.f(x),left.f(x));

		
				
			}
			
		
		case Comp:
		{		if(this.left==null)
	        throw new NullPointerException("error left func is null  cannot be null");
		
		if(this.right==null)
		{
			Polynom p = new Polynom(this.left.toString());
			return p.f(x);
			
		}
		
		return left.f(this.right.f(x));

		
		
		}
		case Min:

		{

			if(this.left==null)
		        throw new NullPointerException("error left func is null  cannot be null");
			
			if(this.right==null)
			{
				Polynom p = new Polynom(this.left.toString());
				return p.f(x);
				
			}
			
			return Math.min(left.f(x),left.f(x));

			

		}
		case None:{
			if(left==null)
				throw new  RuntimeException("left function is null");
			return(left.f(x));
		}
			
		case Error:return 0;
		
		
		
		
		
		default:{
			System.out.println("invalid operation input"); return 0;
		
			
		}

		
	}
	}

	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub
		ComplexFunction c= new ComplexFunction(this.op,this.left,this.right);
		this.op=Operation.Comp;
		this.left=c;
		this.right=f1;
	}

	@Override
	public function left() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return right;
	}

	@Override
	public Operation getOp()
	{
		return op;
	}
	
	

		
	

	public String toString() {
		String s=toString(this);
		s=s.replaceAll("Times", "mul");
		s=s.replaceAll("Divid", "div");
		s=s.toLowerCase();
		return s;
	}
		

public String toString(ComplexFunction co) {
	if(this.left==null)
    {
    	return("null");
    	
    }
    
    if((this.op==null||this.op==Operation.None||this.right==null)&&this.left!=null)
    	return(this.left.toString());
    if (!(this.left instanceof ComplexFunction)&&!(this.right instanceof ComplexFunction))
    		return(this.op+"("+this.left.toString()+","+this.right.toString()+")");
    else
    		
      
    if(this.left instanceof ComplexFunction&&this.right instanceof ComplexFunction)
    {
    	return(this.op+"("+this.left+","+this.right+")");
    	
    }
    
    if(this.left instanceof ComplexFunction &&!(this.right instanceof ComplexFunction))
    {
    	return(this.op+"("+this.left+","+this.right.toString()+")");
    	
    }
    if(!(this.left instanceof ComplexFunction)&&this.right instanceof ComplexFunction)
    {
    	return(this.op+"("+this.left.toString()+","+this.right+")");
    	
    }
    else
    	return (this.op+"("+this.left.toString()+","+this.right.toString()+")");
        
	}


private static String shelp(String s) {
int c=1;
int c2=0;
int k=0;
String ss=s;
int i=s.indexOf("plus(");

int i1=s.indexOf("div(");

int i2=s.indexOf("mul(");

int i3=s.indexOf("max(");

int i4=s.indexOf("min(");
int i5=s.indexOf("comp(");


if(i!=0&&i1!=0&&i2!=0&&i3!=0&&i4!=0&&i5!=0)
{
	if(s.contains(","))
	{
		int j=s.indexOf(",");
		return s.substring(0,j);
		
	}
	else
		return s.substring(0);
	
}

else
{
	int cc=s.indexOf("(");
	k=cc+1;
	do {
		
			 if(s.charAt(k)=='(')
				 c++;
			 if(s.charAt(k)==')')
				 c--;
			
			
			
			k++;
		
		
			
		
		
				
		
	}while(c>0&&s.contains("("));
		return s.substring(0,k);
}

		
	
		
		
	      
		




}





	
	
}