package main;

import java.util.Comparator;

import java.util.*;
import java.time.*;

public class Algorithm {

	// Sort the Profit from Highest to Lowest
	public class SortedProfit implements Comparator<Object> {
		@Override
		public int compare(Object o1, Object o2) {
			CompareData j1 = (CompareData) o1;
			CompareData j2 = (CompareData) o2;

			if (j1.profit != j2.profit) {
				return j2.profit - j1.profit;
			}

			else {
				return j2.deadline - j1.deadline;
			}
		}
	}

	// Sort deadline from Highest to Lowest
	public class SortDeadline implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			CompareData j1 = (CompareData) o1;
			CompareData j2 = (CompareData) o2;

			if (j1.deadline != j2.deadline) {
				return j2.deadline - j1.deadline;
			}

			else {
				return j2.profit - j1.profit;
			}
		}
	}

	/**
	 * Sort the data from highest to lowest profit Use treeset to find the greatest
	 * profit joblist and put the not profitable job into queueList
	 * 
	 **/
	@SuppressWarnings("rawtypes")
	public void SortData(CompareData[] compareData, Data[] data, CompareData[] arrangedJobList,
			CompareData[] arrangedQueueList) {
		int counter = 0;
		int queueCounter = 0;
		// Creating object of SortedProfit class
		SortedProfit sortProfit = new SortedProfit();

		// Sort the cd.profit from highest to lowest
		Arrays.sort(compareData, sortProfit);

		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 0; i < data.length; i++)
			ts.add(i);
		try {
			for (int i = 0; i < data.length; i++) {
				Integer x = ts.floor(compareData[i].deadline - 1);

				if (x != null) {
					// Add to Max Profit Job List
					arrangedJobList[counter++] = compareData[i];
					ts.remove(x);
				} else {
					// Add to Queue Job List
					arrangedQueueList[queueCounter++] = compareData[i];
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown  :" + e);
		} catch (NullPointerException e) {
			System.out.println("Exception thrown  :" + e);
		}
	}

	/**
	 * Display the MaxProfitJobList from lowest to highest deadline with
	 * sortDeadline Date is instantiate with the time from the local computer
	 */
	@SuppressWarnings("rawtypes")
	public void MaxProfitJobList(CompareData[] arrangedCompareData, Data[] data, Data[] finalData) {
		// Sort the Deadline from highest to lowest
		SortDeadline sortDeadline = new SortDeadline();
		Arrays.sort(arrangedCompareData, sortDeadline);

		int counterFinalData = 0;

		// Instantiate the local Date
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();

		System.out.println("==========================");
		System.out.println("|Maximized Profit Joblist|");
		System.out.println("===============================================================");
		System.out.println("| Job ID |" + " Deadline|" + "   Profit (RM) | " + "  StartDate |   " + "  EndDate |");
		System.out.println("===============================================================");
		try {
			for (int x = arrangedCompareData.length - 1; x >= 0; x--) {
				for (int z = 0; z < data.length; z++) {
					if (data[z].id == arrangedCompareData[x].id) {
						System.out.printf("|%7s |%8d | %10d.00 | %4d/%d/%4d | %4d/%d/%4d |", data[z].id,
								data[z].deadline, data[z].profit, data[z].startDate, month, year, data[z].endDate,
								month, year);

						finalData[counterFinalData] = data[z];
						counterFinalData++;
					}
				}
				System.out.println();
			}
			System.out.println("===============================================================");
		}

		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown  :" + e);
		} catch (NullPointerException e) {
			System.out.println("Exception thrown  :" + e);
		}
	}

	/*
	 * List Out the MaximumJobList Which will be distributed evenly to the employees
	 * Undistributed Joblist will be put into a new row
	 */
	@SuppressWarnings("rawtypes")
	public void DistributeJobList(Data[] finalData, int nEmployees) {
		int empId = 1;
		int counter = 0;
		int unassignedJobNo = finalData.length - finalData.length % nEmployees;
		int noMaxJob = finalData.length / nEmployees;
		System.out.println();
		System.out.println("=====================");
		System.out.println("|Distributed Joblist|");
		System.out.println("=======================================================");
		System.out.println("|Employee ID |                  Job ID                 |");
		System.out.println("=======================================================");
		System.out.printf("|%11s |", empId);

		try {
			for (int x = 0; x < finalData.length; x++) {
				if (counter == noMaxJob && empId <= nEmployees) {
					if (x >= unassignedJobNo) {
						System.out.println();
						System.out.println("========================================================");
						System.out.println("| Unassigned Job: ");
						System.out.print("|");
					} else {
						counter = 0;
						System.out.println();
						System.out.printf("|%11s |", ++empId);
					}
				}
				System.out.printf(" %3s |", finalData[x].id);
				counter++;
			}
			System.out.println();
			System.out.println("========================================================");
			System.out.println();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown  :" + e);
		} catch (NullPointerException e) {
			System.out.println("Exception thrown  :" + e);
		}
	}

	/**
	 * List the job in the queueList Date is instantiate with the time from the
	 * local computer
	 */
	@SuppressWarnings("rawtypes")
	public void ListQueueJob(Data[] data, CompareData[] queueCompareData) {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		System.out.println("===============");
		System.out.println("|Queue Joblist|");
		System.out.println("===============================================================");
		System.out.println("| Job ID |" + " Deadline|" + "   Profit (RM) | " + "  StartDate |   " + "  EndDate |");
		System.out.println("===============================================================");

		try {
			for (int x = queueCompareData.length - 1; x >= 0; x--) {
				for (int z = 0; z < data.length; z++) {
					if (data[z].id == queueCompareData[x].id) {
						System.out.printf("|%7s |%8d | %10d.00 | %4d/%d/%4d | %4d/%d/%4d |", data[z].id,
								data[z].deadline, data[z].profit, data[z].startDate, month, year, data[z].endDate,
								month, year);
					}
				}
				System.out.println();
			}
			System.out.println("===============================================================");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown  :" + e);
		} catch (NullPointerException e) {
			System.out.println("Exception thrown  :" + e);
		}
	}
}
