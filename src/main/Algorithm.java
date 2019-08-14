package main;

import java.util.Comparator;
import java.util.*;

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

	public void MaxProfitJobList(CompareData[] compareData, Data[] data, CompareData[] arrangedCompareData) {
		int counter = 0;
		// Creating object of Sorted class


		Sorted sorter = new Sorted();
		SortDeadline sortDeadline = new SortDeadline();
		// Sort the cd.profit from highest to lowest
		Arrays.sort(compareData, sorter);

		// List out the compareData which is sorted
		// for (int i = 0; i < nObject; i++) {
		// System.out.println(compareData[i].id + "@" + compareData[i].deadline + "@" +
		// compareData[i].profit);
		// }
		// System.out.println("==========================================");

		// Creating TreeSet Object
		//Elliminate the notProfitable Job
		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 0; i < data.length; i++)
			ts.add(i);

		for (int i = 0; i < data.length; i++) {
			Integer x = ts.floor(compareData[i].deadline - 1);

			if (x != null) {
				// System.out.print(compareData[i].id + " ");
				arrangedCompareData[counter++] = compareData[i];
				// for (int z = 0; z < data.length; z++) {
				// 	if (data[z].id == compareData[i].id) {
				// 		System.out.print(data[z].deadline + " " + data[z].profit + " " +
				// 		data[z].startTime
				// 		+ " " + data[z].endTime);
						
				// 	}
				// }
				// System.out.println();
				ts.remove(x);
			}
		}

		// Sort the Deadline from highest to lowest
		Arrays.sort(arrangedCompareData, sortDeadline);
		for (int x = 0; x < arrangedCompareData.length; x++) {
			for (int z = 0; z < data.length; z++) {
				if (data[z].id == arrangedCompareData[x].id) {
					System.out.print(data[z].id + "    " + data[z].deadline + "      " + data[z].profit
							+ "      " + data[z].startTime + "     " + data[z].endTime);
				}
			}
			System.out.println();
		}

	}
}
