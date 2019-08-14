/** 
 * Assumption:
 * There are a total of 100 tasks are available for employees to do in a month (30days)
 * The tasks will be distributed among 10 employees and will work together to complete the tasks
 * Eg: A task's Start Time is on 1/7/2019 and the End Time is on 30/7/2019. 
 * 	  The deadline for this task will be 30
 */
package main;
import java.util.Random;
public class Test {

	public static void main(String[] args) {

	    Random rand = new Random();
		final int nObject = 100;
		final int nEmployees = 5;
		final int finalJob = 30;
		final int n = 0;
		Data[] data = new Data[nObject];
		Data[] finalData = new Data[finalJob];
		CompareData[] newData = new CompareData[nObject];
		CompareData[] arrangedCompareData = new CompareData[finalJob];
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
		algo.MaxProfitJobList(ValidateData(data, newData,rand, n), data, arrangedCompareData);
		algo.ArrangeDeadline(arrangedCompareData, data, finalData);
		algo.DistributeJobList(finalData, nEmployees);


	}
	public static CompareData[] ValidateData(Data data[], CompareData newData[], Random rand, int n) {
		if (n <= data.length - 1) {
			data[n].id = Integer.toString(n + 1);
			data[n].profit = rand.nextInt(100) + 1;
			data[n].startTime = rand.nextInt(30) + 1;
			data[n].endTime = rand.nextInt(30) + 1;
			data[n].deadline = data[n].endTime;
			
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
