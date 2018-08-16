public class Obj {
    private String bookName;
    private String author;
    private String publishTime;
    private String rank;
    private String price_r;
    private String price_n;
    private String price_s;
    private String commentnum;
    private String imgurl;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPrice_r() {
        return price_r;
    }

    public void setPrice_r(String price_r) {
        this.price_r = price_r;
    }

    public String getPrice_n() {
        return price_n;
    }

    public void setPrice_n(String price_n) {
        this.price_n = price_n;
    }

    public String getPrice_s() {
        return price_s;
    }

    public void setPrice_s(String price_s) {
        this.price_s = price_s;
    }

    public String getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(String commentnum) {
        this.commentnum = commentnum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", rank='" + rank + '\'' +
                ", price_r='" + price_r + '\'' +
                ", price_n='" + price_n + '\'' +
                ", price_s='" + price_s + '\'' +
                ", commentnum='" + commentnum + '\'' +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}
