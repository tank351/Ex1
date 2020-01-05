package Ex1;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class params {

@SerializedName("Width")
@Expose
private Integer width;
@SerializedName("Height")
@Expose
private Integer height;
@SerializedName("Resolution")
@Expose
private Integer resolution;
@SerializedName("Range_X")
@Expose
private ArrayList<Double> rangeX = null;
@SerializedName("Range_Y")
@Expose
private ArrayList<Double> rangeY = null;

public Integer getWidth() {
return width;
}

public void setWidth(Integer width) {
this.width = width;
}

public Integer getHeight() {
return height;
}

public void setHeight(Integer height) {
this.height = height;
}

public Integer getResolution() {
return resolution;
}

public void setResolution(Integer resolution) {
this.resolution = resolution;
}

public ArrayList<Double> getRangeX() {
return rangeX;
}

public void setRangeX(ArrayList<Double> rangeX) {
this.rangeX = rangeX;
}

public ArrayList<Double> getRangeY() {
return rangeY;
}

public void setRangeY(ArrayList<Double> rangeY) {
this.rangeY = rangeY;
}

public  String toString()
{
	return ("Width:"+this.width+",\n"+"Height:"+this.height+",\n"+"Resolution:"+this.resolution+",\n"+"Range_X"+this.rangeX+",\n"+"Range_Y"+this.rangeY);
}

}