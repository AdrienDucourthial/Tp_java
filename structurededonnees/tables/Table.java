package structurededonnees.tables;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Table<E> {
    private List<E> table;

    private Table(E... arg) {
        this.table = Arrays.stream(arg)
                .peek(e -> Objects.requireNonNull(e, "I don't want null values"))
                .collect(Collectors.toList());
    }

    public static <E> Table<E> of(E... arg) {
        return new Table<>(arg);
    }

    public int size() {
        return table.size();
    }

    /*public <K> Group<K, Integer> groupBy(Function<E, K> proj, Comparable<? super E> comp) {
        K key = proj.apply(e);
        var g = new Group<K, Integer>((K) proj, 2);
        return g;
    }*/
    public <K> Group<K, Integer> groupBy(Function<E, K> proj, Comparator<K> comp) {
        Objects.requireNonNull(proj, "Null argument is not accepted");
        Objects.requireNonNull(comp, "Null argument is not accepted");
        Map<K, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < table.size(); i++) {
            E element = table.get(i);
            K key = proj.apply(element);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
        }
        return new Group<>(map, comp);
    }

    public class Group<K, Integer> {
        private Map<K, List<Integer>> groups = new HashMap<>();
        private final Comparator<? super K> comparator;

        public Group(Map<K, List<Integer>> map, Comparator<? super K> comparator) {
            this.groups = map;
            this.comparator = comparator;
        }

        public int keySize() {
            return groups.size();
        }

        public void add(K key, Integer index) {
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(index);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            groups.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(comparator))
                    .forEachOrdered(entry -> {
                        K key = entry.getKey();
                        List<Integer> values = entry.getValue();
                        sb.append(key.toString()).append(": [");
                        for (int i = 0; i < values.size(); i++) {
                            sb.append(values.get(i));
                            if (i < values.size() - 1) {
                                sb.append(", ");
                            } else {
                                sb.append("]");
                            }
                        }
                        sb.append(values.isEmpty() ? "[]" : "");
                        if (!entry.equals(groups.entrySet().stream().sorted(Map.Entry.comparingByKey(comparator)).reduce((first, second) -> second).orElse(null))) {
                            sb.append("\n");
                        }
                    });
            return sb.toString();
        }


    }
}
