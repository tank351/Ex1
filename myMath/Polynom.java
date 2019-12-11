package Ex1;


import java.util.Iterator; 

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

import Ex1.Monom;

/**
 * This class represents a Polynom with add, multiply functionality, it also
 * should support the following: 1. Riemann's Integral:
 * https://en.wikipedia.org/wiki/Riemann_integral 2. Finding a numerical value
 * between two values (currently support root only f(x)=0). 3. Derivative
 * 
 * @author Boaz
 *
 */

public class Polynom implements Polynom_able {
	private Comparator<Monom> cmp = new Monom_Comperator();
	private Iterator<Monom> it;
	private ArrayList<Monom> l;
	public static final double EPSILON = 0.0000001;

	/**
	 * Zero (empty polynom)
	 */
	public Polynom() {
		l = new ArrayList<Monom>();

	}

	/**
	 * init a Polynom from a String such as: {"x", "3+1.4X^3-34x",
	 * "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
	 * 
	 * @param s:
	 *            is a string represents a Polynom
	 */
	public Polynom(String s) {
		s=s.replaceAll("\\s+","");
		if(s.charAt(0)=='+')
			s=s.substring(1,s.length());
		String[] terms = s.split("\\+");
		Polynom p1= new Polynom();
		
		for(int i=0;i<terms.length;i++)
		{
			if(terms[i].contains("-"))
			{
				String t= terms[i];
				if(t.charAt(0)!='-')
				{
					String [] terms2=terms[i].split("\\-");
					Monom m1=new Monom(terms2[0]);
					 p1.add(m1);
					for(int j=1;j<terms2.length;j++)
					{
						Monom m2=new Monom("-"+terms2[j]);
						p1.add(m2);
						
						
						
					}
					
				}
				else
				{
				
				String [] terms2=terms[i].split("\\-");
				for(int j=1;j<terms2.length;j++)
				{
					Monom m2=new Monom("-"+terms2[j]);
					p1.add(m2);
					
					
					
				}
				
					
				
				
				}
				
				
			}
			else
			{Monom m2= new Monom(terms[i]);
			p1.add(m2);
			}
			
					
					
		}
		this.l=p1.l;
	l.sort(cmp);
			
	}
	

	public void add(Polynom_able p1) {
		Polynom p = new Polynom();
		p = (Polynom) p1.copy();
		Iterator<Monom> it = p.l.iterator();
		Iterator<Monom> it2 = l.iterator();
		boolean b = true;
		while (it.hasNext()) {
			Monom m = it.next();
			b = true;

			while (it2.hasNext() && b == true) {
				Monom m2 = it2.next();
				if (m.get_power() == m2.get_power()) {
					m2.add(m);
					b = false;
				}
			}

			if (b == true) {
				l.add(m);
				m.Zero();
			}
		}
		l.sort(cmp);
	}

	@Override
	public void add(Monom m1) {
		// TODO Auto-generated method stub
		boolean b = true;
		it = this.l.iterator();
		while (it.hasNext()) {
			Monom m = it.next();
			if (m.get_power() == m1.get_power()) {
				m.add(m1);
				m.Zero();
				b = false;
			}
		}
		if (b == true)
			this.l.add(m1);
		l.sort(cmp);
	}

	@Override
	public void substract(Polynom_able p1) {
		Polynom p = new Polynom();
		p = (Polynom) p1.copy();
		boolean b = true;
		it = l.iterator();
		Iterator<Monom> it3 = p.l.iterator();
		while (it3.hasNext()) {
			Monom m = it3.next();
			b = true;
			while (it.hasNext() && b == true) {
				Monom m2 = it.next();
				if (m2.get_power() == m.get_power()) {
					m2.sub(m);
					m2.Zero();
					b = false;
				}
			}
			if (b == true) {
				l.add(m);
			}
		}
		l.sort(cmp);
	}

	public double f(double x) {
		double b = 0;
		// TODO Auto-generated method stub
		it = l.iterator();
		while (it.hasNext()) {
			Monom m = it.next();
			b += m.f(x);
		}
		return b;
	}

	@Override
	public void multiply(Polynom_able p1) {
		// TODO Auto-generated method stub
		Polynom p = new Polynom();
		p = (Polynom) p1.copy();
		Polynom p2 = new Polynom();
		Iterator<Monom> it2 = p.l.iterator();
		while (it2.hasNext()) {
			Monom m = it2.next();
			it = l.iterator();
			while (it.hasNext()) {
				Monom m1 = new Monom(it.next());
				m1.multipy(m);
				m1.Zero();
				p2.add(m1);
			}
		}
		this.l = p2.l;
		l.sort(cmp);
	}

	@Override
	 	public boolean equals (Object m1) {

		
		if(!(m1 instanceof function)||m1==null)
			return false;
		int c=0;

		if(m1 instanceof Monom)
		{
			Monom m = (Monom)m1;
		
			for(int i=-100;i<=100;i++)
			{
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
				if(Math.abs(this.f(i)-co.f(i))>EPSILON)
				{
					return false;
				}
				c++;
			}
			
		}
			if(c==201)
				return true;
			else
				return false;
		}

			
	
	

	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub
		if (l.isEmpty())
			return true;
		Monom ZERO = new Monom(0, 0);
		 it = this.l.iterator();
		boolean b = true;
		while (it.hasNext() && b == true) {
			if (it.next().get_coefficient() != ZERO.get_coefficient())
				b = false;

		}
		return b;
	}

	@Override
	public double root(double x0, double x1, double eps) {
		// TODO Auto-generated method stub

		if (f(x0) * f(x1) >= 0) {
			throw new RuntimeException("You have not assumed" + " right x0 and x1");

		}
		double mid = (x1+x0)/2;

		while(Math.abs(x1-x0)>eps)

		{



			if(f(mid)*f(x1)<0) {

				x0 = mid;

				mid = (x1+x0)/2;

			}

			else if(f(mid)*f(x1)>0) {

				x1 = mid;

				mid = (x1+x0)/2;

			}

			else

				return mid;

		}

		return mid;
		}
		// prints value of c upto 4 decimal places
	
	

	@Override
	public function copy() {
		// TODO Auto-generated method stub
		return new Polynom(this.toString());
	}

	@Override
	public Polynom_able derivative() {
		Polynom p = new Polynom();
		Iterator<Monom> it = l.iterator();
		while (it.hasNext()) {
			Monom m = it.next();
			p.add(m.derivative());
		}
		p.l.sort(cmp);
		return p;
	}

	@Override
	public double area(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		double area = 0;

		for (double i = x0; i < x1; i+=eps) {

			if(f(i) > 0)

				area = area + eps * f(i);

		}

		return area;
	}

	@Override
	public Iterator<Monom> iteretor() {
		it = l.iterator();
		return it;
	}

	@Override
	public void multiply(Monom m1) {
		it = l.iterator();
		while (it.hasNext()) {
			Monom m = it.next();
			m.multipy(m1);
		}
	}

	@Override
	public String toString() {
		for (int i = 0; i <l.size(); i++) {

			if(l.get(i).get_coefficient()==0)

				l.remove(i);



		}

		String res=null;

		Polynom p=new Polynom();

		p.l=this.l;

		boolean f=true;

		if(p.isZero())

			return "0";

		Iterator<Monom> it=p.iteretor();

		while(it.hasNext()) {

			Monom m=it.next();

			if(res==null) {

				res=""+m.toString();

			}

			else {
				if(m.get_coefficient()<0)
				res+=m.toString();
				else
					res+="+"+m.toString();
			}

		}

		return res;
	}
	public function initFromString(String s)
	{
		Polynom p= new Polynom(s);
		return (Polynom)p;
	}
	}
