/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */

package sirop;

import java.util.Iterator;
import java.util.List;

/**
 * Crée un iterable à partir de plusieurs autres iterables (eux-mêmes rangés dans un iterable)
 * @author olojkine
 * @param <T> Type of the elements of the Iterable of the iterable
 */
public class IterableOfIterables<T> implements Iterable {
  private Iterable<Iterable<T>> iterable;
  public IterableOfIterables(Iterable<Iterable<T>> iterable) {
    this.iterable = iterable;
  }

  @Override
  public Iterator iterator() {
    return new IteratorOfIterables(this.iterable);
  }
}

class IteratorOfIterables <T> implements Iterator{
  private final Iterator<Iterable<T>> elems;
  private Iterator<T> curIterator;
  
  /**
   * @param iterable An iterator that yields other iterators
   */
  public IteratorOfIterables(Iterable<Iterable<T>> iterable) {
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
