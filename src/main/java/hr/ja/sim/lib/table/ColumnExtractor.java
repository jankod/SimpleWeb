package hr.ja.sim.lib.table;

public interface ColumnExtractor<M> {
    Object extractValue(M model);
}
