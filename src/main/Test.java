/** 
 * Assumption:
 * There are a total of 100 tasks are available for employees to do in a month (30days)
 * The tasks will be distributed among 10 employees and will work together to complete the tasks
 * Eg: A task's Start Time is on 1/7/2019 and the End Time is on 30/7/2019. 
 * 	  The deadline for this task will be 30
 */

 //Generic
 //align output
 //cout at the start of the program
 //start time endtime make it as date format
 //draw line at each data
 //pending list
 //throw exception
package main;
import java.util.Random;
public class Test {

	public static void main(String[] args) {

	    Random rand = new Random();
		final int nObject = 100;
		final int nEmployees = 5;
		final int finalJob = 30;
		final int queueJob = 70;
		final int n = 0;
		Data[] data = new Data[nObject];
		Data[] finalData = new Data[finalJob];
		CompareData[] newData = new CompareData[nObject];
		CompareData[] arrangedCompareData = new CompareData[finalJob];
		CompareData[] queueCompareData = new CompareData[queueJob];
		Algorithm algo = new Algorithm();

		for (int x = 0; x < nObject; x++) {
			data[x] = new Data();
			String id =Integer.toString(x + 1);
			data[x].setId(id);
			int profit = rand.nextInt(100) + 1;
			int startDate = rand.nextInt(30) + 1;
			int endDate =rand.nextInt(30) + 1;
			int deadline  = endDate;
			data[x].setData(deadline, profit, startDate, endDate);
			
		}
		
		algo.MaxProfitJobList(ValidateData(data, newData,rand, n), data, arrangedCompareData, queueCompareData);
		algo.ArrangeDeadline(arrangedCompareData, data, finalData);
		algo.DistributeJobList(finalData, nEmployees);
		algo.ListQueueJob(data, queueCompareData);


	}
	public static CompareData[] ValidateData(Data data[], CompareData newData[], Random rand, int n) {
		if (n <= data.length - 1) {
			String id =Integer.toString(n + 1);
			data[n].setId(id);
			int profit = rand.nextInt(100) + 1;
			int startDate = rand.nextInt(30) + 1;
			int endDate =rand.nextInt(30) + 1;
			int deadline  = endDate;
			data[n].setData(deadline, profit, startDate, endDate);

			if (data[n].getStartDate() > data[n].getEndDate()) {
				return ValidateData(data, newData, rand, n);
			} else {
				newData[n] = new CompareData();
				newData[n].setId(id);
				newData[n].setCompareData(deadline, profit);
				// System.out.println("Correct Data");
				return ValidateData(data, newData, rand, n + 1);
			}
		}
		return newData;
	}
}
