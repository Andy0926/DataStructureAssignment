package main;

import java.util.Comparator;
import java.util.*;

public class Algorithm {
    public class Sorted implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Data j1 = (Data) o1;
            Data j2 = (Data) o2;

            if (j1.profit != j2.profit)
                return j2.profit - j1.profit;
            else
                return j2.deadline - j1.deadline;
        }

    }

    // Function to print job scheduling
    public void printJobScheduling(Data data[], int n) {
        // Creating object of Sorted class
        Sorted sorter = new Sorted();

        Arrays.sort(data, sorter);

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
        if (n <= data.length) {
            if (data[n].endTime > data[n].deadline) {
                // Error Checking
                // End Time more than deadline
                // Jump to next object and move on the next one
                return ValidateDeadline(data, newData, n + 1, newN);
            } else if (data[n].endTime < data[n].deadline) {
                data[n] = newData[newN];
                return ValidateDeadline(data, newData, n + 1, n + 1);
            }
            // Go to next function
            // Exit the this function
            return data;
        }
        else
        	return data;
    }
}
