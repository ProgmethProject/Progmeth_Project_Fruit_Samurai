package logic;

import java.util.ArrayList;
import java.util.List;

public class ThreadHolder {
	public static ThreadHolder instance = new ThreadHolder();
	private List<Thread> threads;
	
	private ThreadHolder(){
		threads = new ArrayList<>();
	}
	
	public List<Thread> getThreads(){
		return threads;
	}
	
}
