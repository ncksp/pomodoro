package proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import factory.LogDataFactory;

class ReadLog extends Readable{
	private int totalData = 0;
	private int[] logs = {0,0,0,0,0,0,0};
	private final int MORE_THAN_A_WEEK = 8;
	
	@Override
	protected int[] result() {
		this.readFile();
		return logs;
	}

	private void readFile() {
		try {
			File myObj = new File("log.csv");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				totalData++;
				String[] line = myReader.nextLine().split(",");
				int index = LogDataFactory.convertToDay(line[0]);
				
				if(index == MORE_THAN_A_WEEK) break;
				
				if(index < 0) continue;
				
				logs[index] += 1;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Read Log failed");
			e.printStackTrace();
	    }
	}

	@Override
	protected int getTotalData() {
		return totalData;
	}

}
