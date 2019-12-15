package pflb.homework.first;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IMessage<T>>
{
    private static class MyHashMap<K,V> extends HashMap<K,V> {
        @Override
        public V get(Object key){
            V temp = super.get(key);
            try {
                if (temp == null) temp = (V) Collections.emptyList();
            } catch (ClassCastException e) {}
            return temp;
        }
    }
    private Map<String, List<T>> mailBox;
    public MailService(){
        mailBox = new MyHashMap<>();
    }
    @Override
    public void accept(IMessage<T> t){
        if(mailBox.containsKey(t.getTo())) {
            List<T> val;
            val = mailBox.get(t.getTo());
            val.add(t.getContent());
            mailBox.put(t.getTo(), val);
        } else {
            List<T> val;
            val = new LinkedList<>();
            val.add(t.getContent());
            mailBox.put(t.getTo(), val);
        }
    }
    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}