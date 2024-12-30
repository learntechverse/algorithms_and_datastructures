package com.buland.datastructures.stacks;

import java.util.Locale;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * The java.util.concurrent.LinkedBlockingDeque class is based on a linked list – just like ConcurrentLinkedDeque – but is bounded (has a maximum capacity) and blocking.
 *
 * LinkedBlockingDeque is the deque counterpart to LinkedBlockingQueue and has similar characteristics accordingly:
 *
 *     It is based on a doubly linked list.
 *     Thread safety is guaranteed by a single ReentrantLock shared by all enqueue and dequeue operations (LinkedBlockingQueue, on the other hand, uses two locks – one enqueue lock and one dequeue lock).
 *     Unlike ConcurrentLinkedDeque, the deque's size is stored in a field instead of being calculated by counting the list nodes each time size() is called. Thus, the time complexity of the size() method is O(1).
 *     LinkedBlockingDeque does not offer a fairness policy, i.e., blocking methods are served in undefined order (with a fairness policy, they would be served in the order they blocked).
 *
 * The deque characteristics in detail:
 *    Underlying data structure: Linked list
 *    Thread-safe?: Yes
 *    Blocking/non-blocking: Blocking
 * 	  Fairness policy: Not available
 *    Bounded/unbounded: Bounded
 * 	  Iterator type: Weakly consistent¹
 *
 * ¹ Weakly consistent: All elements that exist when the iterator is created are traversed by the iterator exactly once. Changes that occur after this can, but do not need to, be reflected by the iterator.
 *
 * Here's what happens in the example:
 *
 *     First, we create a LinkedBlockingDeque with a capacity for three elements.
 *     Then we schedule ten dequeue operations that take elements from the deque at random sides every three seconds.
 *     We also plan ten enqueue operations that start only after 3.5 seconds but then insert elements at a random side of the deque at intervals of only one second each.
 *     By starting enqueue operations later, we can see blocking dequeue operations at the beginning.
 *     Since we then insert much faster than we extract, we quickly reach the deque's capacity, therefore blocking enqueue threads.
 *
 * Below is an example taken from https://www.happycoders.eu/algorithms/linkedblockingdeque-java/
 */
public class LinkedBlockingDequeExample {
  private static final long startTime = System.currentTimeMillis();

  public static void main(String[] args) throws InterruptedException {
    BlockingDeque<Integer> deque = new LinkedBlockingDeque<>(3);
    ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);

    // Start reading from the deque immediately, every 3 seconds
    for (int i = 0; i < 10; i++) {
      int delaySeconds = i * 3;
      pool.schedule(() -> dequeue(deque), delaySeconds, TimeUnit.SECONDS);
    }

    // Start writing to the deque after 3.5 seconds (so there are already 2
    // threads waiting), every 1 seconds (so that the deque fills faster than
    // it's emptied, so that we see a full deque soon)
    for (int i = 0; i < 10; i++) {
      int element = i;
      int delayMillis = 3500 + i * 1000;
      pool.schedule(() -> enqueue(deque, element), delayMillis, TimeUnit.MILLISECONDS);
    }

    pool.shutdown();
    pool.awaitTermination(1, TimeUnit.MINUTES);
  }

  private static void enqueue(BlockingDeque<Integer> deque, int i) {
    if (ThreadLocalRandom.current().nextBoolean()) {
      enqueueAtFront(deque, i);
    } else {
      enqueueAtBack(deque, i);
    }
  }

  private static void enqueueAtFront(BlockingDeque<Integer> deque, int element) {
    log("Calling deque.putFirst(%d) (deque = %s)...", element, deque);
    try {
      deque.putFirst(element);
      log("deque.putFirst(%d) returned (deque = %s)", element, deque);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private static void enqueueAtBack(BlockingDeque<Integer> deque, int element) {
    log("Calling deque.putLast(%d) (deque = %s)...", element, deque);
    try {
      deque.putLast(element);
      log("deque.putLast(%d) returned (deque = %s)", element, deque);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private static void dequeue(BlockingDeque<Integer> deque) {
    if (ThreadLocalRandom.current().nextBoolean()) {
      dequeueAtFront(deque);
    } else {
      dequeueAtBack(deque);
    }
  }

  private static void dequeueAtFront(BlockingDeque<Integer> deque) {
    log("    Calling deque.takeFirst() (deque = %s)...", deque);
    try {
      Integer element = deque.takeFirst();
      log("    deque.takeFirst() returned %d (deque = %s)", element, deque);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private static void dequeueAtBack(BlockingDeque<Integer> deque) {
    log("    Calling deque.takeLast() (deque = %s)...", deque);
    try {
      Integer element = deque.takeLast();
      log("    deque.takeLast() returned %d (deque = %s)", element, deque);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private static void log(String format, Object... args) {
    System.out.printf(
        Locale.US,
        "[%4.1fs] [%-16s] %s%n",
        (System.currentTimeMillis() - startTime) / 1000.0,
        Thread.currentThread().getName(),
        String.format(format, args));
  }
}