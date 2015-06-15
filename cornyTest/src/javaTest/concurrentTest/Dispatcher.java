package javaTest.concurrentTest;

import java.util.Set;

/**
 * 出租车车队类，指挥出租车的调动
 * @author corny
 *
 */
public class Dispatcher {
	private final Set<Taxi> taxis;//出租车集合
	private final Set<Taxi> availableTaxis;///可用出租车集合
	
	public Dispatcher(Set<Taxi> taxis , Set<Taxi> availableTaxis){
		this.taxis = taxis;
		this.availableTaxis = availableTaxis;
	}

	public synchronized  void notifyAvailable(Taxi taxi) {
		availableTaxis.add(taxi);
	}
	
	/**
	 * 获得包含当前出租车的完整画面
	 * @return
	 */
	public synchronized void getImage(){
		for(Taxi t: taxis)
			t.getLocation();
	}

}