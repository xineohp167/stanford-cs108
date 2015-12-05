CountDownLatchExample.java - This example is based on the FirstWorker.java
  demo from last lecture.  Here we increase the number of worker threads.
  Using a CountDownLatch makes coordination between the worker threads and the
  main thread simpler than use of multiple joins.
  
CyclicBarrierExample.java - Similar to CountDownLatchExample and is based on
  the same FirstWorker.java.  In this case we use a CyclicBarrier.  This 
  coordinates all the worker threads.  None of the worker threads will stop
  until all worker threads have completed their work.

CyclicBarrierHandout.java - CyclicBarrier example from handout.

SemaphoreExample.java - Shows coordinated access to resources using Semaphores.
  In this case the resource being accessed is supposed to be a set of three
  printers.  Notice how using semaphores allows us to halt threads until they
  have access to one of the printers.
  
TurnDemo.java - An older example from Professor Parlante showing use of
  Semaphores for turn taking between two threads.
  
ExecutorExample.java - Executors can be used to create a pool of threads.
  Instead of starting threads directly we ask the Executor to execute a task
  using one of the threads in the pool.
  
Unsych_vs_Synch.java - This program shows the speed difference between
  using a synchronized array and an unsychronized array.  You may have
  to play with the TESTNUM constant depending on how fast your processor
  runs.

 