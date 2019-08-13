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
				// System.out.print("j1 profit: ");
				// System.out.println(j1.profit);
				// System.out.print("j2 profit: ");
				// System.out.println(j2.profit);
				// System.out.print("@@@@");
				// System.out.println(j2.profit - j1.profit);
				return j2.profit - j1.profit;
			}

			else {
				// System.out.println("aT COMPARABLE2222222222222");
				return j2.deadline - j1.deadline;
			}
		}
	}

	public void printJobScheduling(CompareData[] compareData, int nObject, Data[] data) {
		// Creating object of Sorted class

		//Check the data
		// for (int z = 0; z < data.length; z++) {

		// 	System.out.print(data[z].id + "||" + data[z].deadline + "||" + data[z].profit + "||" + data[z].startTime
		// 			+ "||" + data[z].endTime);
		// 	System.out.println();
		// 	System.out.println("====================================================");
		// 	System.out.print(compareData[z].id + "||" + compareData[z].deadline + "||" + compareData[z].profit);
		// 	System.out.println();
		// 	System.out.println("####################################################");
		// }

		Sorted sorter = new Sorted();

		// Sort the cd.profit from highest to lowest
		Arrays.sort(compareData, sorter);

		// Creating TreeSet Object
		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 0; i < nObject; i++)
			ts.add(i);

		for (int i = 0; i < nObject; i++) {
			Integer x = ts.floor(compareData[i].deadline - 1);

			if (x != null) {
				System.out.print(compareData[i].id + " ");

				for (int z = 0; z < data.length; z++) {
					if (data[z].id == compareData[i].id)
						System.out.print(data[z].deadline + "          " + data[z].profit + "  " + data[z].startTime
								+ "       " + data[z].endTime);

				}
				System.out.println();
				ts.remove(x);
			}
		}
	}
}
