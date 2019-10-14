/**
 * Clock data type. Write a data type Clock.java that
 * represents time on a 24-hour clock, such as 00:00, 13:30, or
 * 23:59. Time is measured in hours (00–23) and minutes (00–59).
 * To do so, implement the following public API:
 *
 * @author Siva Sankar
 */

public class Clock {
    // Creates a clock whose initial time is h hrs and m min.
    int h;
    int m;
    /**
     * The parameterised constructor will instatiates the object with the values of
     * the parameters h and m to the respective hrs nad min.
     * @param h
     * @param m
     */
    public Clock(int h, int m) {
    		this.h = h;
    		this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.

    public Clock(String s) {
    		String[] arr = s.split(":");
    		this.h = Integer.parseInt(arr[0]);
    		this.m = Integer.parseInt(arr[1]);
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {

    	if(this.h < 10 || this.m < 10){
    		String hr = "";
    		String mn = "";
    		if(this.h < 10){
    			hr += "0" + this.h;
    		}else{
    			hr += this.h;
    		}
    		if(this.m < 10){
    			mn += "0" + this.m;
    		}else{
    			mn += this.m;
    		}
    		return hr +":"+mn;
    	}else{
    		if(this.h == 24){
    		this.h = 0;
	    	}
	    	else if(this.m == 60){
	    		this.h += 1;
	    		this.m = 0;
	    	}
	    	return this.h +":"+ this.m;
	    }
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
    	if(this.h < that.h){
    		return true;
    	}
    	else if(this.h == that.h && this.m < that.m){
    		return true;
    	}
    	return false;
    }

    private void check() {

    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
    	if(this.m >= 59){
    		this.h += 1;
    		this.m = 0;
    	}else{
    		this.m += 1;
    	}
    }

    // Adds Δ min to the time on this clock.
    public void toc(int delta) {
    	if(delta < 0){
    		return;
    	}
    	int tem = this.m+delta;
    	if(tem == 60){
    		this.h += 1;
    		if(this.h == 24){
    			this.h = 0;
    		}
    		this.m = 0;
    		return;
    	}
    	else if( tem <= 59){
    		this.m += delta;
    	}else{
    		int hrs = delta/60;
    		if(this.h == 23 && hrs == 1){
    			this.h = 0;
    		}else if(this.h+hrs <= 23){
    			this.h += hrs;
    		}else if (this.h + hrs == 24) {
    			this.h = 0;
    		}else{
    			this.h += hrs%24;
    		}
    		int minRem = delta - (60*hrs);
    		this.m += minRem;
    	}
   	}

    // Test client (see below).
    public static void main(String[] args) {
       Clock clock = new Clock("09:30");
    }
}
