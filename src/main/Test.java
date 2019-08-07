package main;

public class Test {

	public static void main(String[] args) {

	    final int nObject = 5;
		final int n = 0, newN = 0;
		Data[] data = new Data[nObject];
		CompareData[] newData = new CompareData[nObject];
		Algorithm algo = new Algorithm();
        
		data[0] = new Data('a', 2, 70, 100, 200); 
        data[1] = new Data('b', 10, 4, 900, 1000); 
        data[2] = new Data('c', 3, 70, 200, 300); 
        data[3] = new Data('d', 2, 80, 100, 200); 
        data[4] = new Data('e', 2, 90, 100, 200); 
        
		algo.printJobScheduling(algo.ValidateDeadline(data, newData, n, newN), nObject);
        

	}

}
