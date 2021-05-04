package co.sp.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;



public class Data {
	
	@Max(50)
	private int da1;
	
    @Size(min=3,max=10)
	private String da2;

	public int getDa1() {
		return da1;
	}

	public void setDa1(int da1) {
		this.da1 = da1;
	}

	public String getDa2() {
		return da2;
	}

	public void setDa2(String da2) {
		this.da2 = da2;
	}
	
	
}
