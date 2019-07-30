package main;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOb = 5;
		int n =0, newN =0;
		Data[] data = new Data[numberOb];
		Data[] newData = new Data[numberOb];
		Algorithm algo = new Algorithm();
        
		//id deadline profit
		data[0] = new Data('a', 1, 100, 1000, 100); 
        data[1] = new Data('b', 1, 19, 900, 100); 
        data[2] = new Data('c', 2, 27, 1400, 200); 
        data[3] = new Data('d', 8, 25, 1700, 800); 
        data[4] = new Data('e', 4, 15, 1900, 300); 
        
		System.out.println(".........");
		algo.printJobScheduling(algo.ValidateDeadline(data, newData, n, newN), numberOb);
        

	}

}
