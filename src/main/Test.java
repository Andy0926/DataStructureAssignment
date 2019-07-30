package main;

public class Test {

	public static void main(String[] args) {

	    final int nObject = 5;
		final int n = 0, newN = 0;
		Data[] data = new Data[nObject];
		CompareData[] newData = new CompareData[nObject];
		Algorithm algo = new Algorithm();
        
		data[0] = new Data('a', 1, 99, 1000, 100); 
        data[1] = new Data('b', 10, 100, 900, 1000); 
        data[2] = new Data('c', 9, 27, 1400, 200); 
        data[3] = new Data('d', 8, 25, 1700, 800); 
        data[4] = new Data('e', 2, 15, 1900, 300); 
        
		algo.printJobScheduling(algo.ValidateDeadline(data, newData, n, newN), nObject);
        

	}

}
