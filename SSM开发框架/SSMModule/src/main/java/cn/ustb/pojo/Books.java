package cn.ustb.pojo;

public class Books {
    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String details;

    public Books() {
    }

    public Books(Integer bookID, String bookName, Integer bookCounts, String details) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookCounts = bookCounts;
        this.details = details;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(Integer bookCounts) {
        this.bookCounts = bookCounts;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookCounts=" + bookCounts +
                ", details='" + details + '\'' +
                '}';
    }

}
