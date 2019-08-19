package main;

/**
 * This Class is use to store the data which will be used to sort the data 
 */
public class CompareData {
	String id;
	int deadline;
	int profit;

	public void setId(String id){
		this.id = id;
	}
	public void setCompareData(int deadline, int profit){
		this.deadline= deadline;
		this.profit = profit;
	}
}
