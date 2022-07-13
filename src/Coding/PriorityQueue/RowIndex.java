package Coding.PriorityQueue;

public class RowIndex {
    public int rowNo;
    public int index;
    public int value;

    public RowIndex(int rowNo, int index, int value) {
        this.rowNo = rowNo;
        this.index = index;
        this.value = value;
    }

    @Override
    public String toString() {
        return "RowIndex{" +
                "rowNo=" + rowNo +
                ", index=" + index +
                ", value=" + value +
                '}';
    }
}
