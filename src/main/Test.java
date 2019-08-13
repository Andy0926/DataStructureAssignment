package main;
import java.util.Random;
public class Test {

	public static void main(String[] args) {

	    Random rand = new Random();
		final int nObject = 200;
		final int n = 0;
		Data[] data = new Data[nObject];
		CompareData[] newData = new CompareData[nObject];
		Algorithm algo = new Algorithm();
        
		// data[0] = new Data('a', 2, 70, 100, 200); 
        // data[1] = new Data('b', 10, 4, 900, 1000); 
        // data[2] = new Data('c', 3, 70, 200, 300); 
        // data[3] = new Data('d', 2, 80, 100, 200); 
        // data[4] = new Data('e', 2, 90, 100, 200); 
        
		for (int x = 0; x < nObject; x++) {
			int startTime = rand.nextInt(30) + 1;
			int endTime = rand.nextInt(30) + 1;
			data[x] = new Data(Integer.toString(x + 1), endTime, rand.nextInt(100) + 1, startTime, endTime);
		}
		System.out.println("ID  "+"Deadline "+"Profit "+"StartTime "+"EndTime");
		algo.printJobScheduling(ValidateData(data, newData,rand, n), nObject, data);
        

	}
	public static CompareData[] ValidateData(Data data[], CompareData newData[], Random rand, int n) {
		if (n <= data.length - 1) {
			data[n].startTime = rand.nextInt(30) + 1;
			data[n].endTime = rand.nextInt(30) + 1;
			data[n].id = Integer.toString(n + 1);
			data[n].profit = rand.nextInt(100) + 1;

			if (data[n].startTime > data[n].endTime) {
				return ValidateData(data, newData, rand, n);
			} else {
				newData[n] = new CompareData(data[n].id, data[n].endTime, data[n].profit);
				// System.out.println("Correct Data");
				return ValidateData(data, newData, rand, n + 1);
			}
		}
		return newData;
	}

}
