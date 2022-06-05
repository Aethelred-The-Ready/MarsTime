public class MarsTime {
	private double mTime = 0;
	private double mDate = 0;
	
	public MarsTime(double mDT) {
		mTime = mDT % 1.0;
		mDate = mDT - mTime;
	}
	
	public static MarsTime curTime() {
		long eTime = System.currentTimeMillis();
		double mDT = (eTime / 1000.0 + (37 + 32.184)) / 88775.244147 + 34127.2954262;
		return new MarsTime(mDT);
	}
	
	public String getDateString() {
		double workingDate = mDate;
		int y = 0;
		workingDate -= 28081.1622 + 164.06627557386111111;
		for(;workingDate > 668.5991;y++)
			workingDate -= 668.5991;
		return String.format("%04d-%03d", y, (int)Math.floor(workingDate));
	}
	
	public String getTimeString() {
		double workingTime = mTime * 86400;
		int h = 0, m = 0, s = 0, ms = 0;
		for(;workingTime > 3600;h++)
			workingTime -= 3600;
		for(;workingTime > 60;m++)
			workingTime -= 60;
		for(;workingTime > 1;s++)
			workingTime -= 1;
		ms = (int) Math.floor(workingTime * 1000);
		return String.format("%02d:%02d:%02d.%03d", h, m, s, ms);
	}
	
	public String toString() {
		String tr = getDateString() + "T" + getTimeString();
		return tr;
	}
}