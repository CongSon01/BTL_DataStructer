package BackTracking;

public class Activity {
	private int start;
	private int finish;

	public Activity(int start, int finish)
	{
		this.start = start; this.finish = finish;
	}

	public int getStart() {return start;}

	public int getFinish() {return finish;}
	
	public String toString() {
		return "(" + start + ", " + finish + ")";
	}
	
}
