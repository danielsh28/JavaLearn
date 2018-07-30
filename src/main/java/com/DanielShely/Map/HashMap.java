package com.DanielShely.Map;


import java.util.*;

public class HashMap<K,V>  implements Map<K,V>{
    public static void main(String[] args) {
        HashMap<String,String> map=new HashMap<>();
    }
    private static final int  SIZE=16;
    private ArrayList<LinkedList<Entry<K,V>>> list= new ArrayList (SIZE);

    public HashMap() {
        int i;
        for (i=0; i<SIZE;++i ){
            list.add(new LinkedList<Entry<K,V>>());


        }
    }

    private class EntrySet extends AbstractSet<Entry<K,V>>{


        @Override
        public Iterator<Entry<K, V>> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        private class EntrySetIter   implements  Iterator<Entry<K,V>>{
            ListIterator<Entry<K,V>> listItr;
            int index ;
            EntrySetIter(){
                listItr= list.get(0).listIterator();
                index=0;
            }

            @Override
            public boolean hasNext() {

                if(listItr.hasNext()  ){
                    return true;
                }

                for (int i=index+1; i<SIZE; ++i){
                    if(list.get(i).isEmpty()==false){
                        return true;
                    }
                }

                return false;
            }

            @Override
            public Entry<K, V> next() {
                if(listItr.hasNext()){
                    return listItr.next();
                }
                while(list.get(index).isEmpty()){

                    ++index;
                }
                list
            }
        }

    }
    private class KeySet extends AbstractSet<K>{
        @Override
        public Iterator<K> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {

        return null;
    }

    @Override
    public V put(K key, V value) {
        Entry pair= new MyPair(key,value);
        int index= key.hashCode()%(SIZE);
        list.get(index).add(pair);
        return value;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
