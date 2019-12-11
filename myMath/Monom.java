
package Ex1;

import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real
 * number and a is an integer (summed a none negative), see:
 * https://en.wikipedia.org/wiki/Monomial The class implements function and
 * support simple operations as: construction, value at x, derivative, add and
 * multiply.
 * 
 * @author Boaz
 *
 */
public class Monom implements function {
	public static final Monom ZERO = new Monom(0, 0);
	public static final Monom MINUS1 = new Monom(-1, 0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	private double _coefficient;
	private int _power;

	public static Comparator<Monom> getComp() {
		return _Comp;
	}

	public Monom(double a, int b) {
		this.set_coefficient(a);
		this.set_power(b);
	}

	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() {
		return this._coefficient;
	}

	public int get_power() {
		return this._power;
	}

	/**
	 * this method returns the derivative monom of this.
	 * 
	 * @return
	 */
	public Monom derivative() {
		if (this.get_power() == 0) {
			return getNewZeroMonom();
		}
		return new Monom(this.get_coefficient() * this.get_power(), this.get_power() - 1);
	}

	public double f(double x) {
		double ans = 1;
		double p = this.get_power();
		ans = this.get_coefficient() * Math.pow(x, p);
		return ans;
	}

	public boolean isZero() {
		return this.get_coefficient() == 0;
	}

	// ***************** add your code below **********************
	public Monom(String s) {
	this(init(s));

	}
	public void sub(Monom m) {
		if (m._power == this._power)
			this._coefficient = this._coefficient - m._coefficient;
		else
			System.out.println("the monoms dont have the same powers: " + m._power + "," + this._power);
		return;
	}

	public void multipy(Monom d) {
		if (d.isZero()) {
			this._coefficient = 0;

		}

		else {
			this._coefficient = this._coefficient * d._coefficient;
			this._power = this._power + d._power;
		}

	}

	public void add(Monom m) {
		if (m._power == this._power)
			this._coefficient = this._coefficient + m._coefficient;
		else
			System.out.println("the monoms dont have the same powers: " + m._power + "," + this._power);
		return;
		}

	

	public String toString() {
		String ans = "";
		if(isZero()) ans ="0";
		else {
			ans = ""+this.get_coefficient();
			if(this.get_power()>0) {
				ans += "x";
				if(this.get_power()>1) {
					ans+="^"+this.get_power();
				}
			}
		}
		return ans;
	}
	// you may (always) add other methods.

	// ****************** Private Methods and Data *****************

	private void set_coefficient(double a) {
		this._coefficient = a;
	}

	private void set_power(int p) {
		if (p < 0) {
			throw new RuntimeException("ERR the power of Monom should not be negative, got: " + p);
		}
		this._power = p;
	}

	private static Monom getNewZeroMonom() {
		return new Monom(ZERO);
	}

	

	private static Monom init(String monom) {
		Monom ans = null;
		double coef = 1;
		int pow = 1;
		try {
			monom = monom.toLowerCase();
			int i0 = monom.indexOf("x");
			int i2 = monom.indexOf("-x");
			int i3 = monom.indexOf("x^");
			if(i2>=0) {coef=-1;}
			else {
				if(i0>0) {
					if(monom.substring(0,i0).contains("*"))
					{
						int i4=monom.indexOf("*");
						double c=Double.parseDouble(monom.substring(0,i4));
						if(monom.charAt(i4+1)=='x')
						{
							coef=c;
						}
						else
						{
						double c1=Double.parseDouble(monom.substring(i4+1,i0));
						coef=c1*c;
						}
								
					}
					else
					coef = Double.parseDouble(monom.substring(0,i0));
				}
				if(i0<0) {
					coef = Double.parseDouble(monom.substring(0));
				}
			}
			if(i3>=0) {
				pow = Integer.parseInt(monom.substring(i3+2));
			}
			else {
				if(i0<0)  {pow = 0;}
			}
			ans = new Monom(coef,pow);
		}
		catch(Exception e) {
			System.out.print("invalid input");
		}
		return ans;
	}

	public boolean equals(Object m1) {
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

	public void Zero() {
		if (this._coefficient == 0)
			this._power = 0;
		else
			return;
	}
	
	
	public function copy()
	{
		return new Monom(this.toString());
	}
	
	
	public function initFromString(String s) {
		Monom m = new Monom(s);
		return (Monom)m;
		
	}
	

	
	
	

	

	
}