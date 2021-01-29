package proxy;

public class ReadLogProxy extends Readable {
	private int currentData = 0;
	private int[] data;
	private ReadLog log;
	
	public int[] readData(int totalData) {
		if(log == null) log = new ReadLog();
		
		if(currentData == totalData) return result();
		
		currentData = totalData;
		
		return log.result();
	}
	
	@Override
	protected int[] result() {
		if(data != null)
			return data;
		
		data = log.result();
		currentData = log.getTotalData();
		
		return data;
	}

	@Override
	public int getTotalData() {
		return currentData;
	}

}
