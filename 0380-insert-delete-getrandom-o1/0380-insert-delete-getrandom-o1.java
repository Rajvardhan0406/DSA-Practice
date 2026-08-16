import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    private List<Integer> values;
    private Map<Integer, Integer> valueToIndex;
    private Random rand;

    public RandomizedSet() {
        values = new ArrayList<>();
        valueToIndex = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) {
            return false;
        }

        valueToIndex.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) {
            return false;
        }

        int targetIdx = valueToIndex.get(val);
        int lastElement = values.get(values.size() - 1);

        values.set(targetIdx, lastElement);
        valueToIndex.put(lastElement, targetIdx);

        values.remove(values.size() - 1);
        valueToIndex.remove(val);

        return true;
    }

    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}