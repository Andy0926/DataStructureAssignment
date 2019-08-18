package main;

public class Data<T> { 
    T id; 
    T deadline; 
    T profit; 
    T startDate;
    T endDate;

    // Constructor 

    public void setId(T id){
    	this.id = id;
    }
    
    public void setData(T deadline, T profit, T startDate, T endDate) {
    	 this.deadline = deadline; 
         this.profit = profit; 
         this.startDate = startDate;
         this.endDate = endDate;
    }
    public int getStartDate() {
    	return (int) startDate;
    }
    public int getEndDate() {
    	return (int) endDate;
    }
} 
