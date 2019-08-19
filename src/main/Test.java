/** 
 * Assumption:
 * There are a total of 100 tasks are available for employees to do in a month (30days)
 * The tasks will be distributed among 2, 3, 5, 6,10 employees and will work together to complete the tasks
 * Eg: A task's Start Time is on 1/7/2019 and the End Time is on 30/7/2019. 
 * 	  The deadline for this task will be 30
 */

package main;

import java.util.Random;

public class Test {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Random rand = new Random();
		final int nJob = 100;
		final int nEmployees = 8;
		final int finalJob = 30;
		final int queueJob = nJob - finalJob;
		final int n = 0;
		Data[] data = new Data[nJob];
		Data[] finalData = new Data[finalJob];
		CompareData[] newData = new CompareData[nJob];
		CompareData[] arrangedCompareData = new CompareData[finalJob];
		CompareData[] queueCompareData = new CompareData[queueJob];
		Algorithm algo = new Algorithm();

		// Create Random object array
		try {
			for (int x = 0; x < nJob; x++) {
				data[x] = new Data<Object>();
				String id = Integer.toString(x + 1);
				data[x].setId(id);
				int profit = rand.nextInt(100) + 1;
				int startDate = rand.nextInt(30) + 1;
				int endDate = rand.nextInt(30) + 1;
				int deadline = endDate;
				data[x].setData(deadline, profit, startDate, endDate);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown  :" + e);
		}

		algo.SortData(ValidateData(data, newData, rand, n), data, arrangedCompareData, queueCompareData);
		algo.MaxProfitJobList(arrangedCompareData, data, finalData);
		algo.DistributeJobList(finalData, nEmployees);
		algo.ListQueueJob(data, queueCompareData);

	}

	/**
	 * Recursion Check the randomized data and make sure it is valid Else
	 * newRandomized will be generated to replace the previous data The validated
	 * data will be put into newData object array to be sorted later
	 */
	public static CompareData[] ValidateData(Data<?> data[], CompareData newData[], Random rand, int n) {
		try {
			if (n <= data.length - 1) {
				String id = Integer.toString(n + 1);
				data[n].setId(id);
				int profit = rand.nextInt(100) + 1;
				int startDate = rand.nextInt(30) + 1;
				int endDate = rand.nextInt(30) + 1;
				int deadline = endDate;
				data[n].setData(deadline, profit, startDate, endDate);

				if (data[n].getStartDate() > data[n].getEndDate()) {
					return ValidateData(data, newData, rand, n);
				} else {
					newData[n] = new CompareData();
					newData[n].setId(id);
					newData[n].setCompareData(deadline, profit);
					return ValidateData(data, newData, rand, n + 1);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown  :" + e);
		} catch (NullPointerException e) {
			System.out.println("Exception thrown  :" + e);
		}
		return newData;
	}
}
