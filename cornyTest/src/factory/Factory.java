package factory;

public class Factory {

	public static Object getInstance(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Object obj = null;
		obj = Class.forName(name).newInstance();
		return obj;
	}
}
