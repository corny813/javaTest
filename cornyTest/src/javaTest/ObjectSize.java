package javaTest;

import java.io.Serializable;

public class ObjectSize {

	public static void main(String args[]){
		DataObject data=new DataObject();
		
		int id = 141592653;
		double time=System.currentTimeMillis();
		double tag_val=3.14159265358;
		
		DataObject data1=new DataObject(id,tag_val);
		int size = data.toString().length();
		int size1= data1.toString().length();
		
//		System.out.println(size+":"+size1);
//		System.out.println((time+"").length());
		String message =id+""+time+""+tag_val+"key:sdfsdabsdfsfdfsdfsdfsdfghjk";
		System.out.println(message+""+message.length());
	}
}



class DataObject implements Serializable {

	private static final long serialVersionUID = 2476140391638320314L;
	
	private int tag_no;
	private double time;
	private double tag_val;

	public DataObject() {
		
	}

	public DataObject(int no,double t){
		this.tag_no=no;
		this.time=t;
	}

	public DataObject(int no,double t,double val){
		this.tag_no=no;
		this.time=t;
		this.tag_val=val;
	}

	public String toString() {
		return tag_no+","+time+","+tag_val;
	}


	public int getTag_no() {
		return tag_no;
	}


	public void setTag_no(int tag_no) {
		this.tag_no = tag_no;
	}


	public double getTime() {
		return time;
	}


	public void setTime(double time) {
		this.time = time;
	}


	public double getTag_val() {
		return tag_val;
	}


	public void setTag_val(double tag_val) {
		this.tag_val = tag_val;
	}

}