package mybatis.entity;

/**
 * 路由表项类
 * @author corny
 *
 */
public class RouteItem {

	private int id;	//自增主键
	
	private String cacheRange;		//缓存服务范围
	private String cacheMask;		//缓存掩码	
	private String timeSeriesRange;	//时序服务范围
	private String timeSeriesMask;	//时序掩码
	
	private String hostIP;		//本机IP，当在范围内时返回
	private String nextDirIP;	//
	private String targetDirIP;	//目的目录IP
	
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
