package queueLab;

public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException() {
		super();
	}
	
	public EmptyQueueException(String msg) {
		super(msg);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 490157278046208017L;

}