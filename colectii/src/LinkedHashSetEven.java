import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class LinkedHashSetEven extends LinkedHashSet<Integer> {
    @Override
    public boolean add(Integer e) {
        if(e.intValue() % 2 == 1) {
            return false;
        }
        
        return super.add(e);
    }
}
