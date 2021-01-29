package proxy;

public class ReadLog extends Readable{
	private int totalData = 0;
	private int[] logs = new int[7];
	
	@Override
	protected int[] result() {
		this.readFile();
		return logs;
	}

	private void readFile() {
	}

	@Override
	protected int getTotalData() {
		return totalData;
	}

}
