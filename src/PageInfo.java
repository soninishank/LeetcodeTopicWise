public class PageInfo {
    int page;
    int per_page;
    int total_pages;
    Data[] data;

    public PageInfo(int page, int per_page, int total_pages, Data[] data) {
        this.page = page;
        this.per_page = per_page;
        this.total_pages = total_pages;
        this.data = data;
    }

    public Data[] getData() {
        return data;
    }
}
