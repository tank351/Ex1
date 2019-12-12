package Ex1;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;
public class Functions_GUI implements functions{
	Collection <function> f  = new ArrayList <function>();
	private function f1;
	Iterator<function> it;
	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, 
			Color.ORANGE, Color.red, Color.GREEN, Color.PINK}; 
	
	public Functions_GUI()
	{
		this.f=new ArrayList<function>();
	}
	@Override
	public void initFromFile(String file) throws IOException {
		function l =  new ComplexFunction();
int c=0;
		String line ="";



		try {

			BufferedReader br = new BufferedReader(new FileReader(file));


			while ((line = br.readLine()) != null) {
			line=line.replaceAll(" ", "");
				 if(line.length() >0&&line!="\r\n"&&line!="\n") 
				 { 
   
					
			ComplexFunction co= new ComplexFunction();
			co=(ComplexFunction)co.initFromString(line);
			f.add(co);
				 
				 
				 }
			}
			
			br.close();
		
			
		}

		catch(IOException e){

			e.printStackTrace();

		}
	}
	@Override
	public void saveToFile(String file) throws IOException {
		try {
			File ff= new File(file);
			if(!ff.exists())
				ff.createNewFile();
			PrintWriter f0 = new PrintWriter(file);
			it = f.iterator();
			while(it.hasNext()) {
				f1 = it.next();
				f0.println(f1.toString()+"\n");
			}
			f0.close();
			}catch (Exception e) {
				// TODO: handle exception
				throw(e);
			}
		
	}	
	
		
	

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub
		it = f.iterator();
		DrawScales(width,height,rx,ry,resolution);
		RangePoints(rx,ry);
		Draw(rx,resolution);
	}
	private void Draw(Range rx,int resolution) {
		// TODO Auto-generated method stub
		int n =resolution;
		int j=0;
		double[] x = new double[n+1];
		double[][] y= new double[f.size()][n+1];
		double rx1 = rx.get_max()-rx.get_min();
		x[0]=rx.get_min();
		int c = 1 ;
			while(c < n+1) {
				x[c] = x[c-1]+rx1/n;
				c++;
			}
			while(it.hasNext()) {
				function f = it.next();
			for(int i=1;i<n+1;i++) {
				y[j][i] = f.f(x[i]);

			}
			int co = new Random().nextInt(Colors.length);
			for( int i = 0 ; i < n; i++) {
				StdDraw.setPenRadius(0.003);
				StdDraw.setPenColor(Colors[co]);
				StdDraw.line(x[i], y[j][i], x[i+1], y[j][i+1]);
			}
			j++;
			}
	}
	private void RangePoints(Range rx,Range ry) {
		// TODO Auto-generated method stub
		for(int x=(int) ry.get_min();x<=ry.get_max();x=x+1) {
			StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			StdDraw.setPenRadius(0.001);
			StdDraw.line(rx.get_min(), x, rx.get_max(), x);
			StdDraw.setPenRadius(0.003);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(-0.07,x, Integer.toString(x));
		}

		for(int y=(int) rx.get_min();y<=rx.get_max();y=y+1) {
			StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			StdDraw.setPenRadius(0.001);
			StdDraw.line(y, ry.get_min(), y, ry.get_max());
			StdDraw.setPenRadius(0.003);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(y, -0.4, Integer.toString(y));
		}
		
	}
	private void DrawScales(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub
		StdDraw.setCanvasSize(width, height);
		StdDraw.setYscale(ry.get_min(),ry.get_max());
		StdDraw.setXscale(rx.get_min(),rx.get_max());
		StdDraw.setPenRadius(0.004);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		
	}
	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub
		BufferedReader br=null;
		Gson gson = new Gson();
		params p=new params();
		try {
			br=new BufferedReader(new FileReader(json_file));
			p=gson.fromJson(br,p.getClass());
			ArrayList <Double>arr= p.getRangeX();
			ArrayList<Double> arr2=p.getRangeY();

			Range rx=new Range(arr.get(0),arr.get(1));
			Range ry=new Range(arr2.get(0),arr2.get(1));

			drawFunctions(p.getWidth(),p.getHeight(),rx,ry,p.getResolution());
			} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		
		}
	}

	@Override
	public boolean add(function e) {
		// TODO Auto-generated method stub
		return f.add(e);	
		
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		// TODO Auto-generated method stub
		it = f.iterator();
		boolean flag = false;
		while(it.hasNext()&&flag) {
			function f1 = it.next();
		flag = add(f1);
		}
		return flag;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		it = f.iterator();
		while(it.hasNext()) {
			 it.remove();;
		}
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		boolean flag = true;
		it = f.iterator();
		while(it.hasNext()&&flag) {
			f1 =it.next();
			if(o.equals(f1)) {
				flag = false;
			}
		}
		return !flag;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean flag = true;
		it = f.iterator();
		int counter=0;
		Iterator<?> it1 = c.iterator();
		while(it1.hasNext()&&flag) {
			if(counter>0) {
			counter=0;
			flag = true;
			while(it.hasNext()) {
			f1 =it.next();
			if(f1.equals(it1.next())) {
				counter++;
			}	
		}
			}else {
			flag =false;
		}
		}
		return flag;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return f.size()==0;
	}

	@Override
	public Iterator<function> iterator() {
		// TODO Auto-generated method stub
		it = f.iterator();
		return it;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		it = f.iterator();
		boolean flag = false;
		while(it.hasNext()&&!flag) {
			if(it.next().equals(o)) {
				it.remove();
				flag = true;
			}else {
				flag = false;
			}
		}
	return flag;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return f.removeAll(c);	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return f.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] arr = new Object[f.size()];
		it = f.iterator();
		int c = 0;
		while(it.hasNext()) {
			f1 = it.next();
			arr[c++] = f1;
		}
		return arr;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public Polynom get(int i) {
		// TODO Auto-generated method stub
		it = f.iterator();
		function save = null;
		while(it.hasNext()&&i >= 0) {
			f1 = it.next();
			if(i==0) {
				save = f1;
			}
			i--;
		}
		return (Polynom) save;
	}

	public void drawFunctions() {
		// TODO Auto-generated method stub
		int width = 1000;
		int height = 600;
		Range rx = new Range(-15, 15);
		Range ry = new Range(-10, 10);
		int res = 200;
		drawFunctions(width, height, rx, ry, res);
		
	}
}