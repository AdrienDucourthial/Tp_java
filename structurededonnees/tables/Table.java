package structurededonnees.tables;

import structurededonnees.TableTest;

import java.util.function.Function;

public class Table<E> {
    private static Object[] table;

    public static Table<E> of(Object... arg) {
        table = new Object[arg.length];
        for (int i = 0; i < arg.length; i++) {
            table[i] = arg;
        }
        return (Table<E>) table;
    }

    public int size() {
        return table.length;
    }

    public Group groupBy(Function proj, Function comp) {
        var g = new Group();
        return g;
    }

    public class Group {
        public int keySize() {

        }
    }
}
