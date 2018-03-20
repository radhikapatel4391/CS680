package hw6;

public class Car 
{
	private int price;
	private int year;
	private float milage;
	private int DominationCount;

	public void setDominationCount(int dominationCount) {
		DominationCount = dominationCount;
	}
	public int getDominationCount() {
		return DominationCount;
	}
	public Car(int price, int year, float milage)
	{
		this.price = price;
		this.year = year;
		this.milage = milage;

	}
	public int getPrice()
	{
		return price;
	}

	public int getYear()
	{
		return year;
	}
	public float getMilage()
	{
		return milage;
	}
	
}
