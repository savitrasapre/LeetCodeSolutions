import java.util.Map;
import java.util.Map.Entry;

class PairClass<K,V> extends Map.Entry<K,V>
{
    private K key;
    private V value;


    public PairClass(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }

    public V setValue(V newValue)
    {
        V temp = this.value;
        this.value = newValue;
        return temp;
    }

}