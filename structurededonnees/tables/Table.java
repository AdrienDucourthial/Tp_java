package structurededonnees.tables;

import structurededonnees.TableTest;

import java.util.function.Function;

public class Table<E> {
    private static Object[] table;

    private Table(Object[] table) {
        this.table = table;
    }

    public static <E> Table<E> of(E... arg) {
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] == null) {
                throw new NullPointerException("I don't want null values");
            }
        }
        return new Table<>(arg);
    }

    public int size() {
        return table.length;
    }

    static <E> Group groupBy(Function proj, Comparable comp) {
        var g = new Group();
        var tmp = comp(proj);
        return g;
    }

    public class Group {
        public int[] indexes;
        public int keySize() {
            return indexes.length;
        }
    }
}
