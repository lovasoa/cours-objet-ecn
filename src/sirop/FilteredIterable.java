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
public class FilteredIterable<T> implements Iterable<T> {
  private Iterable<T> iterable;
  private Class<? extends T> filterClass;
  public FilteredIterable(Iterable<T> iterable, Class<? extends T> filterClass) {
    this.iterable = iterable;
    this.filterClass = filterClass;
  }

  @Override
  public Iterator<T> iterator() {
    return new FilteredIterator<T>(this.iterable, this.filterClass);
  }
}

class FilteredIterator<T> implements Iterator<T>{
  private Iterator<T> iterator;
  T curElem;
  private Class<? extends T> filterClass;
  
  /**
   * @param iterable An iterator that yields other iterators
   */
  public FilteredIterator(Iterable<T> iterable, Class<? extends T> filterClass) {
    this.iterator = iterable.iterator();
    this.filterClass = filterClass;
    if (this.iterator.hasNext()) this.curElem = this.iterator.next();
  }
  
  private void forward() {
    while (curElem != null && !this.condition(curElem)) {
      curElem = (iterator.hasNext()) ? iterator.next() : null;
    }
  }

  @Override
  public T next() {
    this.forward();
    return this.curElem;
  }

  @Override
  public boolean hasNext() {
    this.forward();
    return (this.curElem != null);
  }

  @Override
  public void remove() {
    this.iterator.remove();
  }

  private boolean condition(T elem) {
    return this.filterClass.isInstance(elem);
  }
}
