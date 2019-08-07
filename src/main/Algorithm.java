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
				// System.out.println("aT COMPARABLE");
				return j2.profit - j1.profit;
			}

			else {
				// System.out.println("aT COMPARABLE2222222222222");
				return j2.deadline - j1.deadline;
			}
		}
	}

	public void printJobScheduling(CompareData[] compareData, int n) {
		// Creating object of Sorted class

		int counter = 0;

		// Count Number of Data available
		for (int x = 0; x < n; x++) {
			if (compareData[x] != null) {
				counter++;
			}
		}
		
		// System.out.println(counter);

		// Create a new arrayObject with the correct number without the NULL value
		CompareData[] cd = new CompareData[counter];
		for (int x = 0; x < counter; x++) {
			if (compareData[x] != null) {
				// System.out.println("at the for loop");
				cd[x] = new CompareData(compareData[x].id, compareData[x].deadline, compareData[x].profit);
			}
		}
		/*
		Use for Checking
		for(int x = 0; x < counter; x++){
			System.out.println(cd[x].id+"  "+cd[x].deadline+"  "+cd[x].profit);
		}
		*/
		Sorted sorter = new Sorted();

		// System.out.println("sort");
		Arrays.sort(cd, sorter);

		// Creating TreeSet Object
		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 0; i < counter; i++)
			ts.add(i);

		for (int i = 0; i < counter; i++) {
			Integer x = ts.floor(cd[i].deadline - 1);

			if (x != null) {
				System.out.print(cd[i].id + " ");
				ts.remove(x);
			}
		}
	}

	/*
	 * Recursion to validate the data Eliminate the endTime which is more than
	 * deadline Add the validated data into a new DataObject
	 */

	public CompareData[] ValidateDeadline(Data data[], CompareData newData[], int n, int newN) {
		if (n <= data.length - 1) {
			// System.out.println("Divided End Time: " + data[n].endTime / 100);
			if (data[n].endTime / 100 > data[n].deadline) {
				// System.out.println("Wrong Data");
				return ValidateDeadline(data, newData, n + 1, newN);

			} else if (data[n].endTime / 100 <= data[n].deadline) {
				newData[newN] = new CompareData(data[n].id, data[n].deadline, data[n].profit);
				 //System.out.println("Correct Data");
				return ValidateDeadline(data, newData, n + 1, n + 1);
			}
			return newData;
		} else {
			// System.out.println("Out the recursion " + newData.length);
			return newData;
		}

	}
}
