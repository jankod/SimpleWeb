package hr.ja.sim.lib.table;

import java.util.Comparator;

public class TableColumn<M> {

    private String label;
    private ColumnExtractor<M> columnExtractor;

    public TableColumn(String label, ColumnExtractor<M> columnExtractor) {
        this.label = label;
        this.columnExtractor = columnExtractor;
    }

    public TableColumn<M> sort(Comparator<M> comparing) {
        return this;
    }
}
