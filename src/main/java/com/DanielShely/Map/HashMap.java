package com.DanielShely.Map;




import javax.swing.text.html.HTMLDocument;
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
            return new EntrySetIter() ;
        }

        @Override
        public int size() {
            return HashMap.this.size();
        }

        private class EntrySetIter   implements  Iterator<Entry<K,V>>{
            Iterator<Entry<K,V>> listItr = list.get(0).listIterator();
            int index = 0 ;

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

                while( ++index< SIZE && list.get(index).isEmpty())
                    if(index==SIZE){
                    throw new NoSuchElementException();
                    }
                listItr= list.get(index).listIterator();
                return listItr.next();


            }
        }

    }
    private class KeySet extends AbstractSet<K>{



        @Override
        public Iterator<K> iterator() {
            return new KeyItr();
        }

        @Override
        public int size() {
            return HashMap.this.size();
        }

        private  class KeyItr implements Iterator<K>{
            private  Iterator<Entry<K, V>>  itr= new EntrySet().iterator();



            @Override
            public boolean hasNext() {
                return (itr.hasNext());
            }

            @Override
            public K next() {
                return (itr.next().getKey());
            }
        }
    }


    private  class values extends AbstractCollection<V>{



        @Override
        public Iterator<V> iterator() {
            return new ValIter();
        }

        @Override
        public int size() {
            return HashMap.this.size();
        }
        private class ValIter implements Iterator<V>{
            private Iterator<Entry<K,V>> iter= new EntrySet().iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public V next() {
                return iter.next().getValue();
            }
        }
    }

    @Override
    public int size() {
        int sum=0;
        for(LinkedList<Entry<K,V>> l:list){
            sum+=l.size();

        }
        return sum;
    }

    @Override
    public boolean isEmpty() {
        for(LinkedList<Entry<K,V>> l:list){
            if(!l.isEmpty()){
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        int index =calculateIndex(key);
        LinkedList<Entry<K,V>> l=list.get(index);
        for(Entry<K,V> e:l){
            if(e.getKey().equals(key)){
                return true;
            }
            return false;
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        for(int i =0; i<SIZE; ++i){
            for(Entry<K, V> l: list.get(i)){
                if(l.getValue().equals(value)){
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public V get(Object key) {
        int index = calculateIndex(key);
        for(Entry<K,V> entry: list.get(index)) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }

        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index= calculateIndex(key);
        for(Entry<K,V> pair: list.get(index) ){
            if(pair.getKey().equals(key)){
                return pair.getValue();
            }
        }

        Entry newPair= new MyPair(key,value);
        list.get(index).add(newPair);
        return value;
    }
        private  int calculateIndex(Object key){
        return (Math.abs(key.hashCode() )%SIZE);
        }

    @Override
    public V remove(Object key) {
        int index= calculateIndex(key);
        V value;
        for (Entry<K,V> e : list.get(index)){
            if(e.getKey().equals(key)){
                value=e.getValue();
                list.get(index).remove(e);
                return(value);

            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<? extends Entry<? extends K, ? extends V>> pairs = m.entrySet();
        for (Entry<? extends K, ? extends V> e:pairs){
            this.put(e.getKey(),e.getValue());

        }


    }

    @Override
    public void clear() {

        for(LinkedList l :list){
            l.clear();
        }

    }

    @Override
    public Set<K> keySet() {
        return new KeySet() ;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new EntrySet();
    }
}
