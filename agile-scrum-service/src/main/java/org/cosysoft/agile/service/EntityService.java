/**
 *
 */
package org.cosysoft.agile.service;

import java.util.List;

/**
 *
 * @author Bluesky
 * @param <E>
 */
public interface EntityService<E> {

    int count();

    void update(E e);

    void add(E e);

    void remove(E e);

    List<E> findAll();

}
