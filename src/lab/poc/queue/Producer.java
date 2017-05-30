/* Producer - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package lab.poc.queue;

class Producer extends Thread {
	public String name;

	private Queue taskQueue;

	protected int sleepTimeInMills;

	protected boolean active;

	protected int taskCounter = 0;

	public void run() {
		while (active) {
			try {
				Thread.sleep((long) sleepTimeInMills);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			taskCounter++;
			//~~~ Add task to queue.
			taskQueue.put(new Task(name + "." + taskCounter), this);
		}
	}

	public Producer(String p0, Queue p1, int p2, boolean p3) {
		name = p0;
		taskQueue = p1;
		sleepTimeInMills = p2;
		active = p3;
	}
}
