package main;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOb = 5;
		Data[] data = new Data[numberOb];
		Data[] newData = new Data[numberOb];
		Algorithm algo = new Algorithm();
        data[0] = new Data('a', 2, 100, 1000, 1100); 
        data[1] = new Data('b', 1, 19, 900, 1000); 
        data[2] = new Data('c', 2, 27, 1400, 1600); 
        data[3] = new Data('d', 1, 25, 1700, 1800); 
        data[4] = new Data('e', 3, 15, 1900, 2000); 
		int n =0, newN =0;
		algo.printJobScheduling(algo.ValidateDeadline(data, newData, n, newN), n);
        

	}

}
