package Ex1;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;
import java.util.Iterator;


public class testfile {
	@Test
	public void filereadsave()
	{
	Functions_GUI fl= new Functions_GUI();
	Functions_GUI fll= new Functions_GUI();
	ComplexFunction ff= new ComplexFunction();
	ff=(ComplexFunction)ff.initFromString("2x+2");
	fl.add(ff);
	ff=(ComplexFunction)ff.initFromString("10x^6+2x+1");

	fl.add(ff);
	try
	{
	fl.saveToFile("cogo.txt");
	fll.initFromFile("cogo.txt");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	Iterator <function> it= fll.iterator();
	Iterator <function> it2= fl.iterator();
	while(it.hasNext()&&it2.hasNext())
	{
		if(!it.next().equals(it2.next()))
		{
			fail("error in readfile or initfrom file should be equals");
		}
		
	}
	}

}
