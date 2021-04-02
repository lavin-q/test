package com.qhm.collection.selfMap;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Description : 自实现HashMap  //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-31 10:54  //时间
 */
public class SelfHashMap<K,V> extends AbstractMap<K,V>  implements Map<K,V>, Cloneable, Serializable {

    static int initialCapacity = 1<<31;
    public static HashMap<String, Object> map = new HashMap<>(initialCapacity);
    int x = 1 ,y = 2;
    public static void main(String[] args) {
        System.out.println(initialCapacity);
       /* int qaaa = hash("qaaa");
        System.out.println(qaaa);*/
       //测试HashMap最大初始化容量
        System.out.println("a");

    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }



   public static int hash(Object key) {
        int h;
       h = key.hashCode();
       int i = h >>> 16;
       return (key == null) ? 0 : (h ) ^ (i);
    }

}


class B {
    private void a() {
        System.out.println("1");
    }

    public void c() {
        this.a();
    }


}

class C extends B {
    public void d() {
        c();
    }
}
