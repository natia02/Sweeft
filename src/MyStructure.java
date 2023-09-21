import java.util.HashSet;
import java.util.Set;

public class MyStructure<T> {
    private Set<T> set;

    public MyStructure(){
        this.set = new HashSet<>();
    }

    public void add(T element) {
        set.add(element);

    }

    public void delete(T element) {
        set.remove(element);
    }

    public boolean contains(T element) {
        return set.contains(element);
    }
}
