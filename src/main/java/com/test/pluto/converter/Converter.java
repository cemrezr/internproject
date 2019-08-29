package com.test.pluto.converter;

import java.util.List;

public interface Converter<K, V> {
    V converter(K source);

    abstract V converter(K source, V target);

   public List<V> convertAll(List<K> sources);
}
