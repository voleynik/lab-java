package lab.poc.queue;

class Consumer extends Thread {
	public String name;

	private Queue taskQueue;

	protected int sleepTimeInMills;

	protected boolean active;

	public void run() {
		Task currentTask = null;
		while (active) {
			try {
				Thread.sleep((long) sleepTimeInMills);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			//~~~ Get task from Queue.
			currentTask = taskQueue.get();
			System.out.println("~ Task: " + currentTask.name + " consumed by:"
					+ name);
		}
	}

	public Consumer(String p0, Queue p1, int p2, boolean p3) {
		name = p0;
		taskQueue = p1;
		sleepTimeInMills = p2;
		active = p3;
	}
}
