package Ex1;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Color;
import java.awt.Font;
import java.util.Iterator; 


public class Functions_GUI implements functions{
	Collection<function> functions=new ArrayList<function>();
	public boolean remove(Object f)
	{
		try
		{
		functions.remove(f);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	
	}
	
	public int size()
	{
		return functions.size();
	}
	public boolean add(function c)
	{
		try
		{
		functions.add(c);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	
		
	}
	

	public void saveToFile(String file) throws IOException
	{
		
	}
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution)
	{
		StdDraw.setCanvasSize(width,height);
		StdDraw.line(20, 10, 20, 10);
		StdDraw.line(0, 20,10, 20);
		StdDraw.setPenRadius(0.01);
		double []x = new double[resolution+1];
		double [][]y= new double[functions.size()][resolution+1];
		double m = rx.get_max()-rx.get_min();
		Iterator<function> it = functions.iterator();
		int j =0;
		for(double minx = rx.get_min();minx<rx.get_max();minx++) {
			StdDraw.text(minx, 0.03, Double.toString(minx));
		}
		for(double miny = ry.get_min();miny<ry.get_max();miny++) {
			StdDraw.text(miny, 0.03, Double.toString(miny));
		}
		while(it.hasNext()) {
			function f = (function) it.next();
			for(int i = 0;i <= resolution ; i++ ) {
				x[i]=(m*i)/resolution;
			}
			for(int i =0 ; i <= resolution ; i++) {
				y[j][i] = f.f(x[i]);
				System.out.println(y[j][i]);
			}
			
			for(int i =1 ; i <= resolution; i++) {
				StdDraw.line(x[i-1], y[j][i-1], x[i], y[j][i]);
			}
			j++;
			
		}
		for(int i = 1 ; i <=resolution ; i++) {
			StdDraw.line(x[i-1], y[0][i-1], x[i], y[0][i]);
		}
		
	}
	public void drawFunctions(String json_file)
	{
		BufferedReader br=null;
		Gson gson = new Gson();
		params p=new params();
		try {
			br=new BufferedReader(new FileReader("json_file"));
			p=gson.fromJson(br,p.getClass());
			} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ArrayList <Double>arr= p.getRangeX();
			ArrayList<Double> arr2=p.getRangeY();

			Range rx=new Range(arr.get(0),arr.get(1));
			Range ry=new Range(arr2.get(0),arr2.get(1));

			drawFunctions(p.getWidth(),p.getHeight(),rx,ry,p.getResolution());
		}
		
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<function> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initFromFile(String file) throws IOException {
		// TODO Auto-generated method stub
		
	}


}
