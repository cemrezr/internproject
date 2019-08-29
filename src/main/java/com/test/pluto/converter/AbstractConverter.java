package com.test.pluto.converter;

import com.test.pluto.populator.Populator;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractConverter<K, V> implements Converter<K, V> {

    private List<Populator<K, V>> populators;

    private Class<V> aClass;

    public Class getaClass() {
        return aClass;
    }

    @Required
    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public V converter(K source) {
        return converter(source,createInstance());
    }

    @Override
    public V converter(K source,V target) {
        final List<Populator<K, V>> list = getPopulators();
        if (Objects.nonNull(list) && !list.isEmpty()) {
            for (final Populator<K, V> populator : list) {
                populator.populate(source, target);
            }
        }
        return target;
    }

    private V createInstance() {
        V target = null;
        try {
            target = (V) aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return target;
    }

    @Override
    public List<V> convertAll(List<K> sources) {
        List<V> targetList = new ArrayList<V>();
        for (K source : sources) {
            V target = converter(source);
            targetList.add(target);
        }
        return targetList;
    }

    public List<Populator<K, V>> getPopulators() {
        return populators;
    }

    @Required
    public void setPopulators(List<Populator<K, V>> populators) {
        this.populators = populators;
    }
}
