package com.buland.datastructures.stacks;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The following example demonstrates the thread safety of ConcurrentLinkedDeque.
 * Four writing and three reading threads concurrently insert and extract elements from random pages of the deque.
 *
 * You can see how the seven threads insert and remove elements from both sides of the deque. When I ran it, In the third line,
 * you can see how thread 5 got a null return value when it invoked pollLast(). That's because the deque was empty at that point.
 *
 * Here we have learned about the thread-safe linked list-based ConcurrentLinkedDeque and its characteristics.
 */
public class ConcurrentLinkedDequeExample {

  private static final int NUMBER_OF_PRODUCERS = 4;
  private static final int NUMBER_OF_CONSUMERS = 3;
  private static final int NUMBER_OF_ELEMENTS_TO_PUT_INTO_DEQUE_PER_THREAD = 5;
  private static final int MIN_SLEEP_TIME_MILLIS = 500;
  private static final int MAX_SLEEP_TIME_MILLIS = 2000;

  private Deque<Integer> deque;
  private final CountDownLatch producerFinishLatch =
      new CountDownLatch(NUMBER_OF_PRODUCERS);
  private volatile boolean consumerShouldBeStoppedWhenDequeIsEmpty;

  public static void main(String[] args) throws InterruptedException {
    new ConcurrentLinkedDequeExample().runDemo();

    // We'll let the program end when all consumers are finished
  }

  private void runDemo() throws InterruptedException {
    createDeque();
    startProducers();
    startConsumers();
    waitUntilAllProducersAreFinished();

    consumerShouldBeStoppedWhenDequeIsEmpty = true;
  }

  private void createDeque() {
    deque = new ConcurrentLinkedDeque<>();
  }

  private void startProducers() {
    for (int i = 0; i < NUMBER_OF_PRODUCERS; i++) {
      createProducerThread().start();
    }
  }

  private Thread createProducerThread() {
    return new Thread(
        () -> {
          for (int i = 0; i < NUMBER_OF_ELEMENTS_TO_PUT_INTO_DEQUE_PER_THREAD; i++) {
            sleepRandomTime();
            insertRandomElementAtRandomSide();
          }

          producerFinishLatch.countDown();
        });
  }

  private void sleepRandomTime() {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    try {
      Thread.sleep(random.nextInt(MIN_SLEEP_TIME_MILLIS, MAX_SLEEP_TIME_MILLIS));
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private void insertRandomElementAtRandomSide() {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    Integer element = random.nextInt(1000);
    if (random.nextBoolean()) {
      deque.offerFirst(element);
      System.out.printf(
          "[%s] deque.offerFirst(%3d)        --> deque = %s%n",
          Thread.currentThread().getName(), element, deque);
    } else {
      deque.offerLast(element);
      System.out.printf(
          "[%s] deque.offerLast(%3d)         --> deque = %s%n",
          Thread.currentThread().getName(), element, deque);
    }
  }

  private void startConsumers() {
    for (int i = 0; i < NUMBER_OF_CONSUMERS; i++) {
      createConsumerThread().start();
    }
  }

  private Thread createConsumerThread() {
    return new Thread(
        () -> {
          while (shouldConsumerContinue()) {
            sleepRandomTime();
            removeElementFromRandomSide();
          }
        });
  }

  private boolean shouldConsumerContinue() {
    return !(consumerShouldBeStoppedWhenDequeIsEmpty && deque.isEmpty());
  }

  private void removeElementFromRandomSide() {
    if (ThreadLocalRandom.current().nextBoolean()) {
      Integer element = deque.pollFirst();
      System.out.printf(
          "[%s]     deque.pollFirst() = %4d --> deque = %s%n",
          Thread.currentThread().getName(), element, deque);
    } else {
      Integer element = deque.pollLast();
      System.out.printf(
          "[%s]     deque.pollLast()  = %4d --> deque = %s%n",
          Thread.currentThread().getName(), element, deque);
    }
  }

  private void waitUntilAllProducersAreFinished() throws InterruptedException {
    producerFinishLatch.await();
  }
}