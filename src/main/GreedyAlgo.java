package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgo {

	static class Job implements Comparable<Job> {
        char id;
        int deadline;
        int profit;

        @Override
        public int compareTo(Job otherJob) {
            return otherJob.profit - this.profit;
        }

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        GreedyAlgo jobSequencing = new GreedyAlgo();
        ArrayList<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job('a', 2, 100));
        jobs.add(new Job('b', 1, 19));
        jobs.add(new Job('c', 2, 27));
        jobs.add(new Job('d', 1, 25));
        jobs.add(new Job('e', 3, 15));

        Collections.sort(jobs);


        for (Job job : jobs) {
            System.out.println(job.id + " - " + job.profit);
        }
        jobSequencing.printJobSequence(jobs, jobs.size());

    }

    private void printJobSequence(ArrayList<Job> jobs, int size) {
        Boolean[] slots = new Boolean[size];
        Arrays.fill(slots, false);

        int result[] = new int[size];

        for (int i = 0; i < size; i++) {
            for (int j = jobs.get(i).deadline - 1; j >= 0; j--) {
                if (!slots[j]) {
                    result[j] = i;
                    slots[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < jobs.size(); i++) {
            if (slots[i])
                System.out.print(jobs.get(result[i]).id + " -> ");
        }
    }

}
