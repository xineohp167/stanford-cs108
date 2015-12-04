FirstWorker.java - this simple example starts up to worker threads, where
  the threads are defined by subclassing the Thread class
  
MiscThread.java - this example illustrates the difference between calling
  run and start.  Never call run directly.
  
RunnableExample.java - instead of subclassing Thread we can support the
  Runnable interface.
  
AnonRunnable.java - often we use an anonymous class for our Runnable.

PairWorker.java - this example illustrates what happens when multiple
  threads try to access the same data.
  
SynchronizedBlock.java - this example shows use of statement level
  synchronization
  
StopWorker.java - this example illustrates use of an interrupt.

SwingThread.java - this example demonstrates good and bad use of threads
  in conjunction with Swing.
  