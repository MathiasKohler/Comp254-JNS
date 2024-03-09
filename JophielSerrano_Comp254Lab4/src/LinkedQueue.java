/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
 * All operations are performed in constant time.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @see SinglyLinkedList
 */
public class LinkedQueue<E> implements Queue<E> {

  /** The primary storage for elements of the queue */
  private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty  list

  /** Constructs an initially empty queue. */
  public LinkedQueue() { }                  // new queue relies on the initially empty list

  /**
   * Returns the number of elements in the queue.
   * @return number of elements in the queue
   */
  @Override
  public int size() { return list.size(); }

  /**
   * Tests whether the queue is empty.
   * @return true if the queue is empty, false otherwise
   */
  @Override
  public boolean isEmpty() { return list.isEmpty(); }

  /**
   * Inserts an element at the rear of the queue.
   * @param element  the element to be inserted
   */
  @Override
  public void enqueue(E element) { list.addLast(element); }

  /**
   * Returns, but does not remove, the first element of the queue.
   * @return the first element of the queue (or null if empty)
   */
  @Override
  public E first() { return list.first(); }

  /**
   * Removes and returns the first element of the queue.
   * @return element removed (or null if empty)
   */
  @Override
  public E dequeue() { return list.removeFirst(); }

  /** Produces a string representation of the contents of the queue.
   *  (from front to back). This exists for debugging purposes only.
   */
  public String toString() {
    return list.toString();
  }

  public void concatenate(LinkedQueue<E> Q2) {
    if (Q2.isEmpty()) {
      return; // Nothing to concatenate
    }

    // Modify the tail of the current queue to point to the head of Q2
    if (!isEmpty()) {
      list.tail.setNext(Q2.list.head);
      list.tail = Q2.list.tail;
      list.size += Q2.list.size;
    } else {
      // If the current queue is empty, simply copy the elements from Q2
      list.head = Q2.list.head;
      list.tail = Q2.list.tail;
      list.size = Q2.list.size;
    }

    // Make Q2 an empty queue
    Q2.list.head = null;
    Q2.list.tail = null;
    Q2.list.size = 0;
  }

  public static void main(String[] args) {
    LinkedQueue<Integer> queue1 = new LinkedQueue<>();
    LinkedQueue<Integer> queue2 = new LinkedQueue<>();

    for (int i = 1; i <= 5; i++) {
      queue1.enqueue(i);
      queue2.enqueue(i + 5);
    }

    System.out.println("Queue 1 before concatenation: " + queue1.first());
    System.out.println("Queue 2 before concatenation: " + queue2.first());

    queue1.concatenate(queue2);

    System.out.println("Queue 1 after concatenation: " + queue1.first());
    System.out.println("Queue 2 after concatenation: " + queue2.first());
  }
}