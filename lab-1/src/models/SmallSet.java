package models;

import java.util.*;

public class SmallSet<T> implements Set<T> {
    private T[] values;
    private int[] indexes;

    public SmallSet(int size) {
        values = (T[]) new Object[size];
        indexes = new int[size];
        Arrays.fill(indexes, -1);
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean contains(Object o) {
        if (o != null) {
            int hash = getHashCode(o);

            if (indexes[hash] == -1) {
                System.out.print(o + ":");
                System.out.println(values[hash]);
                return values[hash].equals(o);
            }

            // TODO
            int currentIndex = hash;
            int attempt = 0;
            while (indexes[currentIndex] != -1 && attempt++ < values.length) {
                currentIndex = indexes[currentIndex];
            }
            if (attempt >= size()) {
                return  false;
            }

            return values[currentIndex].equals(o);
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        int hash = getHashCode(t);

        if (values[hash] == null) {
            values[hash] = t;
            return true;
        }

        int currentIndex = hash;
        int attempt = 0;
        while (indexes[currentIndex] != -1 && attempt++ < values.length) {
            currentIndex = indexes[currentIndex];
        }
        if (attempt >= size()) {
            return  false;
        }

        indexes[currentIndex] = findEmptyIndex(currentIndex);
        values[indexes[currentIndex]] = t;

        return true;
    }

    private int findEmptyIndex(int from) {
        for (int i = from % size(); i < size(); i ++) {
            if (values[i] == null) {
                return i;
            }
        }

        return -1;
    }

    private int getHashCode(Object element) {
        int hash = element.hashCode();
        return hash % size();
    }

    @Override
    public boolean isEmpty() {
        return Arrays.stream(values).noneMatch(Objects::nonNull);
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(this.values).iterator();
    }

    @Override
    public Object[] toArray() {
        return this.values;
    }

    @Override
    public <M> M[] toArray(M[] a) {
        return a;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        values = (T[]) new Object[values.length];
        indexes = new int[indexes.length];
    }
}
