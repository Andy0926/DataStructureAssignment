package main;

public class Data<T> { 
    T id; 
    int deadline; 
    int profit; 
    int startDate;
    int endDate;

    public void setId(String id){
    	this.id = (T) id;
    }
    
    public void setData(int deadline, int profit, int startDate, int endDate) {
    	 this.deadline =  deadline;    
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
