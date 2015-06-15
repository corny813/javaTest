package javaTest.concurrentTest;

import java.awt.Point;

/**
 * 出租车类，可被出租车车队调用
 * @author corny
 *
 */
public class Taxi {
	
	private Point location,destination;//包含两个属性：当前位置和目标地
	private final Dispatcher dispatcher;//所属车队
	
	public Taxi(Dispatcher dispatcher){
		this.dispatcher = dispatcher;
	}
	
	public synchronized Point getLocation(){
		return location;
	}
	
	/**
	 * 通过GPS设置出租车位置
	 * @param location
	 */
	public synchronized void setLocation(Point location){
		this.location = location;
		if(location.equals(destination)){
			dispatcher.notifyAvailable(this);
		}
	}
}	