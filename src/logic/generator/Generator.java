package logic.generator;

public abstract class Generator {
	
	protected long generateInterval;
	protected Thread thread;
	
	public Generator(long generateInterval) {
		this.generateInterval = generateInterval;
		thread = new Thread(initRunnable());
	}
	
	public abstract Runnable initRunnable();
	
	public void start(){
		thread.start();
	}
	
	public void stop(){
		thread.interrupt();
	}
}
