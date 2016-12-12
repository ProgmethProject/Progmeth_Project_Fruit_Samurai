package thread;

import java.util.ArrayList;
import java.util.List;

import logic.generator.Generator;

public class ThreadHolder {
	public static ThreadHolder instance = new ThreadHolder();
	private List<Thread> threads;
	private List<Generator> bombGenerators;
	private List<Generator> fruitGenerators;
	
	private ThreadHolder(){
		threads = new ArrayList<>();
		bombGenerators = new ArrayList<>();
	}
	
	public List<Thread> getThreads(){
		return threads;
	}
	
}
