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
public class IterableOfIterables<T> implements Iterable<T> {
  private final Iterable<? extends Iterable<? extends T>> iterable;
  public IterableOfIterables(Iterable<? extends Iterable<? extends T>> iterable) {
    this.iterable = iterable;
  }

  @Override
  public Iterator<T> iterator() {
    return new IteratorOfIterables<T>(this.iterable);
  }
}

class IteratorOfIterables <T> implements Iterator<T>{
  private final Iterator<? extends Iterable<? extends T>> elems;
  private Iterator<? extends T> curIterator;
  
  /**
   * @param iterable An iterator that yields other iterators
   */
  public IteratorOfIterables(Iterable<? extends Iterable<? extends T>> iterable) {
    this.elems = iterable.iterator();
    this.curIterator = this.elems.next().iterator();
  }
  
  private void forward() {
    while (!this.curIterator.hasNext() && this.elems.hasNext()) {
      this.curIterator = this.elems.next().iterator();
    }
  }
  
  @Override
  public T next() {
    this.forward();
    return curIterator.next();
  }

  @Override
  public boolean hasNext() {
    this.forward();
    return this.curIterator.hasNext();
  }

  @Override
  public void remove() {
    this.curIterator.remove();
  }
}
