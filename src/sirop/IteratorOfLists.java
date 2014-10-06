/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */

package sirop;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author olojkine
 */
public class IteratorOfLists <T> implements Iterator{
  private final Iterator<Iterable<T>> elems;
  private Iterator<T> curIterator;
  
  /**
   * Creates an iterator out of several iterables
   * @param iterable An iterator that yields other iterators
   */
  public IteratorOfLists(Iterable<Iterable<T>> iterable) {
    this.elems = iterable.iterator();
    this.curIterator = this.elems.next().iterator();
  }
  
  @Override
  public T next() {
    while (!this.curIterator.hasNext()) {
      this.curIterator = this.elems.next().iterator();
    }
    return curIterator.next();
  }

  @Override
  public boolean hasNext() {
    return this.curIterator.hasNext() || this.elems.hasNext();
  }
}
