package main;

import java.util.Comparator;
import java.util.*;
import java.time.*;

public class Algorithm {

	public class Sorted implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			CompareData j1 = (CompareData) o1;
			CompareData j2 = (CompareData) o2;

			// System.out.println("compare data 1 profit :"+ j1.profit );

			if (j1.profit != j2.profit) {

				// System.out.println(j2.profit - j1.profit);
				return j2.profit - j1.profit;
			}

			else {
				// System.out.println("aT COMPARABLE2222222222222");
				return j2.deadline - j1.deadline;
			}
		}
	}

	public class SortDeadline implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			CompareData j1 = (CompareData) o1;
			CompareData j2 = (CompareData) o2;

			// System.out.println("compare data 1 profit :"+ j1.profit );

			if (j1.deadline != j2.deadline) {

				// System.out.println(j2.profit - j1.profit);
				return j2.deadline - j1.deadline;
			}

			else {
				// System.out.println("aT COMPARABLE2222222222222");
				return j2.profit - j1.profit;
			}
		}
	}

	public void MaxProfitJobList(CompareData[] compareData, Data[] data, CompareData[] arrangedCompareData,
			CompareData[] queueCompareData) {
		int counter = 0;
		int queueCounter = 0;

		// Creating object of Sorted class
		Sorted sorter = new Sorted();

		// Sort the cd.profit from highest to lowest
		Arrays.sort(compareData, sorter);

		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 0; i < data.length; i++)
			ts.add(i);

		for (int i = 0; i < data.length; i++) {
			Integer x = ts.floor(compareData[i].deadline - 1);

			if (x != null) {
				//Add to Max Profit Joblist
				arrangedCompareData[counter++] = compareData[i];
				ts.remove(x);
			} else {
				//Add to Queue List
				queueCompareData[queueCounter++] = compareData[i];
			}
		}
	}

	public void ArrangeDeadline(CompareData[] arrangedCompareData, Data[] data, Data[] finalData) {
		// Sort the Deadline from highest to lowest
		SortDeadline sortDeadline = new SortDeadline();
		Arrays.sort(arrangedCompareData, sortDeadline);
		int counterFinalData = 0;
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();

		System.out.println("==========================");
		System.out.println("|Maximized Profit Joblist|");
		System.out.println("=======================================================");
		System.out.println("| ID |" + " Deadline|" + "   Profit | " + "  StartDate |   " + "  EndDate |");
		System.out.println("=======================================================");
		for (int x = arrangedCompareData.length - 1; x >= 0; x--) {
			for (int z = 0; z < data.length; z++) {
				if (data[z].id == arrangedCompareData[x].id) {
					System.out.printf("|%3s |%8d | %5d.00 | %4d/%d/%4d | %4d/%d/%4d |", data[z].id, data[z].deadline,
							data[z].profit, data[z].startDate, month, year, data[z].endDate, month, year);

					finalData[counterFinalData] = data[z];
					counterFinalData++;
				}
			}
			System.out.println();
		}
		System.out.println("=======================================================");
	}

	public void DistributeJobList(Data[] finalData, int nEmployees) {
		int empId = 1;
		int counter = 0;
		System.out.println();
		System.out.println("=====================");
		System.out.println("|Distributed Joblist|");
		System.out.println("=======================================================");
		System.out.println("|Employee ID |                  Job ID                 |");
		System.out.println("=======================================================");
		System.out.printf("|%11s |", empId);
		for (int x = 0; x < finalData.length; x++) {
			// System.out.print(" ");
			if (counter == 6 && empId <= nEmployees) {
				counter = 0;
				System.out.println();
				System.out.printf("|%11s |", ++empId);
			}
			System.out.printf(" %3s |", finalData[x].id);
			counter++;
		}
		System.out.println();
		System.out.println("========================================================");

	}

	public void ListQueueJob(Data[] data, CompareData[] queueCompareData) {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		System.out.println("===============");
		System.out.println("|Queue Joblist|");
		System.out.println("=======================================================");
		System.out.println("| ID |" + " Deadline|" + "   Profit | " + "  StartDate |   " + "  EndDate |");
		System.out.println("=======================================================");
		for (int x = queueCompareData.length - 1; x >= 0; x--) {
			for (int z = 0; z < data.length; z++) {
				if (data[z].id == queueCompareData[x].id) {
					System.out.printf("|%3s |%8d | %5d.00 | %4d/%d/%4d | %4d/%d/%4d |", data[z].id,
							data[z].deadline, data[z].profit, data[z].startDate, month, year,
							data[z].endDate, month, year);

				}
			}
			System.out.println();
		}
		System.out.println("=======================================================");

	}

}
