package Ex1;

public class hoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Functions_GUI f= new Functions_GUI();
		ComplexFunction co= new ComplexFunction();
		co=(ComplexFunction)co.initFromString("plus(-x^4+2.4x^2+3.1,-1.2999999999999998x+5)");
		f.add(co);
		co=(ComplexFunction)co.initFromString("plus(x+1,2)");
		f.add(co);
		co=(ComplexFunction)co.initFromString("div(plus(-x^4+2.4x^2+3.1,-1.2999999999999998x+5),-x^4+2.4x^2+3.1)");
		f.add(co);
		co=(ComplexFunction)co.initFromString("-x^4+2.4x^2+3.1");
		f.add(co);
		co=(ComplexFunction)co.initFromString("-1.2999999999999998x+5");
		f.add(co);
		co=(ComplexFunction)co.initFromString("max(max(max(max(plus(-x^4+2.4x^2+3.1,-1.2999999999999998x+5),plus(x+1,2)),div(plus(-x^4+2.4x^2+3.1,-1.2999999999999998x+5),-x^4+2.4x^2+3.1)),-x^4+2.4x^2+3.1),-1.2999999999999998x+5)");
		f.add(co);
		co=(ComplexFunction)co.initFromString("min(min(min(min(plus(-x^4+2.4x^2+3.1,-1.2999999999999998x+5),plus(x+1,2)),div(plus(-x^4+2.4x^2+3.1,-1.2999999999999998x+5),-x^4+2.4x^2+3.1)),-x^4+2.4x^2+3.1),-1.2999999999999998x+5)");
		f.add(co);
		f.drawFunctions("GUI_params.txt");

	}

}
