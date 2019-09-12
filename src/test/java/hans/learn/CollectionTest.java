package hans.learn;

import org.junit.Test;

import java.util.HashMap;

public class CollectionTest {

    @Test
    public void testHashMap() {
        Person p = null;
        HashMap<Person, Object> hash = new HashMap<>();
        for (int i=0; i<100000; i++) {
            hash.put(new Person("A"),"1");
            if (i==50000) {
                p = new Person("A");
                hash.put(p,"2");
            }
        }
        long start = System.currentTimeMillis();
        System.out.print("size = " + hash.size()+" val = "+hash.get(p) + " time = ");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(this.name);
//    }
}
