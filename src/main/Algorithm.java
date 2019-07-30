package main;

import java.util.Comparator;
import java.util.*;

public class Algorithm {
	public class Sorted implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			CompareData j1 = (CompareData) o1;
			CompareData j2 = (CompareData) o2;
			System.out.println(o1);
			
			if (j1.profit != j2.profit) {
				System.out.println("aT COMPARABLE");
				return j2.profit - j1.profit;
			}

			else {
				System.out.println("aT COMPARABLE");
				return j2.deadline - j1.deadline;
			}

		}

	}

	// Function to print job scheduling
	public void printJobScheduling(Data data[], int n) {
		// Creating object of Sorted class
		
		
		CompareData[] cd = new CompareData[n];
		/////////////////////////////////////////////
		for(int x = 0;x<n;x++) {
			
			cd[x] = new CompareData(data[x].id, data[x].deadline,data[x].profit );
			
		}
		Sorted sorter = new Sorted();
		System.out.println("sort");
		Arrays.sort(cd, sorter);
		
		// Creating TreeSet Object
		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 0; i < n; i++)
			ts.add(i);

		for (int i = 0; i < n; i++) {
			Integer x = ts.floor(data[i].deadline - 1);

			if (x != null) {
				System.out.print(data[i].id + " ");
				ts.remove(x);
			}
		}
	}

	// Recursion to validate the data

	public Data[] ValidateDeadline(Data data[], Data newData[], int n, int newN) {
		if (n <= data.length - 1) {
			if (data[n].endTime % 100 > data[n].deadline) {
				// Error Checking
				// End Time more than deadline
				// Jump to next object and move on the next one
				
				System.out.println("Here Wrong");
				return ValidateDeadline(data, newData, n + 1, newN);
				
			} else if (data[n].endTime % 100 <= data[n].deadline) {
				newData[newN] = data[n];
				System.out.println(data[n].endTime);
				System.out.println("Here Wrong!!!!");
				return ValidateDeadline(data, newData, n + 1, n + 1);
			}
			// Go to next function
			// Exit the this function
			return newData;
		} else {
			System.out.println(newData);
			System.out.println("Out the recursion");
			return newData;
		}

	}
}
