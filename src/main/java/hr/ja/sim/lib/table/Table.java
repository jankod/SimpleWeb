package hr.ja.sim.lib.table;

import hr.ja.sim.lib.Widget;
import j2html.TagCreator;
import j2html.tags.DomContent;
import j2html.tags.specialized.TableTag;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class Table<M> extends Widget {

    @Getter
    private List<TableColumn> columns = new ArrayList<>();

    private ArrayList<M> data;

    public TableColumn<M> addColumn(String label, ColumnExtractor<M> columnExtractor) {
        TableColumn<M> tableColumn = new TableColumn(label, columnExtractor);
        columns.add(tableColumn);
        return tableColumn;
    }

    @Override
    public String html() {
        return null;
    }

    public void setData(M... data) {

    }

    public void setData(ArrayList<M> data) {
        this.data = data;
    }
}
