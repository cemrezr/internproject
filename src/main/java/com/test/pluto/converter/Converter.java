package com.test.pluto.converter;
import java.util.List;
public interface Converter<K,V> {
    V converter (K source);
    List<V> convertAll(List<K> sources);
}
