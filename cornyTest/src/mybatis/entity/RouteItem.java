package mybatis.entity;

/**
 * ·�ɱ�����
 * @author corny
 *
 */
public class RouteItem {

	private int id;	//��������
	
	private String cacheRange;		//�������Χ
	private String cacheMask;		//��������	
	private String timeSeriesRange;	//ʱ�����Χ
	private String timeSeriesMask;	//ʱ������
	
	private String hostIP;		//����IP�����ڷ�Χ��ʱ����
	private String nextDirIP;	//
	private String targetDirIP;	//Ŀ��Ŀ¼IP
	
	private int cost;	//

	public String getCacheRange() {
		return cacheRange;
	}

	public void setCacheRange(String cacheRange) {
		this.cacheRange = cacheRange;
	}

	public String getCacheMask() {
		return cacheMask;
	}

	public void setCacheMask(String cacheMask) {
		this.cacheMask = cacheMask;
	}

	public String getTimeSeriesRange() {
		return timeSeriesRange;
	}

	public void setTimeSeriesRange(String timeSeriesRange) {
		this.timeSeriesRange = timeSeriesRange;
	}

	public String getTimeSeriesMask() {
		return timeSeriesMask;
	}

	public void setTimeSeriesMask(String timeSeriesMask) {
		this.timeSeriesMask = timeSeriesMask;
	}

	public String getHostIP() {
		return hostIP;
	}

	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}

	public String getNextDirIP() {
		return nextDirIP;
	}

	public void setNextDirIP(String nextDirIP) {
		this.nextDirIP = nextDirIP;
	}

	public String getTargetDirIP() {
		return targetDirIP;
	}

	public void setTargetDirIP(String targetDirIP) {
		this.targetDirIP = targetDirIP;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
