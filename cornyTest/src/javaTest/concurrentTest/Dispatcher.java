package javaTest.concurrentTest;

import java.util.Set;

/**
 * ���⳵�����ָ࣬�ӳ��⳵�ĵ���
 * @author corny
 *
 */
public class Dispatcher {
	private final Set<Taxi> taxis;//���⳵����
	private final Set<Taxi> availableTaxis;///���ó��⳵����
	
	public Dispatcher(Set<Taxi> taxis , Set<Taxi> availableTaxis){
		this.taxis = taxis;
		this.availableTaxis = availableTaxis;
	}

	public synchronized  void notifyAvailable(Taxi taxi) {
		availableTaxis.add(taxi);
	}
	
	/**
	 * ��ð�����ǰ���⳵����������
	 * @return
	 */
	public synchronized void getImage(){
		for(Taxi t: taxis)
			t.getLocation();
	}

}