import java.util.*;

public class HashMapSolution<K,V> {
    private static final int SIZE = 16;
    private ArrayList<List<Map.Entry<K, V>>> map;

    public HashMapSolution(){
        map = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            map.add(new LinkedList<>());
        }
    }

    private int toIndex(Object key){
        return(key.hashCode()&(SIZE-1));
    }

    private class entrySet extends AbstractSet<Map.Entry<K, V>> {

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new entrySetIter();
        }

        @Override
        public int size() {
            return HashMapSolution.this.size();
        }

        private class entrySetIter implements Iterator<Map.Entry<K, V>>{
            private int currIndex;
            private ListIterator<Map.Entry<K, V>> iter;

            entrySetIter(){
                iter = map.get(0).listIterator();
                currIndex = 0;
            }
            @Override
            public boolean hasNext() {
                if (iter.hasNext())
                {
                    return true;
                }
                for (int i = currIndex + 1; i < SIZE; i++) {
                    if(!map.get(i).isEmpty()){
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Entry<K, V> next() {
                if (iter.hasNext()){
                    return iter.next();
                }
                while (++currIndex < SIZE) {
                    List<Map.Entry<K, V>> curr = map.get(currIndex);
                    if(!curr.isEmpty()){
                        iter = curr.listIterator();
                        return(iter.next());
                    }
                }
                iter = null;
                throw new NoSuchElementException();
            }
        }
    }

    private class keySet extends AbstractSet<K>{

        @Override
        public Iterator<K> iterator() {
            return new keySetIter();
        }

        @Override
        public int size() {
            return HashMapSolution.this.size();
        }
        private class keySetIter implements Iterator<K>{
            private  Iterator<Entry<K, V>> iter = new entrySet().iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public K next() {
                return iter.next().getKey();
            }
        }
    }

    private class values extends AbstractCollection<V>{

        @Override
        public Iterator<V> iterator() {
            return new valueIter();
        }

        @Override
        public int size() {
            return HashMapSolution.this.size();
        }
        private class valueIter implements Iterator<V>{

            private  Iterator<Entry<K, V>> iter = new entrySet().iterator();
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
        int ret = 0;
        for (List<Entry<K, V>> list : map) {
            ret += list.size();
        }
        return ret;
    }

    @Override
    public boolean isEmpty() {
        for (List<Entry<K, V>> list : map) {
            if(!list.isEmpty()){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        for(Entry<K, V> curr : map.get(toIndex(key))){
            if(curr.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<Entry<K, V>> list : map) {
            for(Entry<K, V> curr : list){
                if(curr.getValue().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for(Entry<K,V> curr : map.get(toIndex(key))){
            if(curr.getKey().equals(key)){
                return (curr.getValue());
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int i = toIndex(key);
        for(Entry<K,V> curr : map.get(i)){
            if(curr.getKey().equals(key)){
                return (curr.setValue(value));
            }
        }
        map.get(i).add(new Pair<>(key, value));
        return null;
    }

    @Override
    public V remove(Object key) {
        List<Map.Entry<K, V>> currList = map.get(toIndex(key));
        for(Entry<K,V> curr : currList){
            if(curr.getKey().equals(key)){
                V ret = curr.getValue();
                currList.remove(curr);
                return ret;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(Entry<? extends K, ? extends V> e : m.entrySet()){
            put(e.getKey(),e.getValue());
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i <SIZE; i++) {
            map.get(i).clear();
        }
    }

    @Override
    public Set<K> keySet() {
        return new keySet();
    }

    @Override
    public Collection<V> values() {
        return new values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new entrySet();
    }
}
