package com.test.pluto.populator;

public interface Populator<K, V> {
    void populate(K source, V target);
}
