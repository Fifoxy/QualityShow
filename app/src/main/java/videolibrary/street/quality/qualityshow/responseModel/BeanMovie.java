package videolibrary.street.quality.qualityshow.responseModel;

import com.google.gson.annotations.SerializedName;

public class BeanMovie {

    @SerializedName("title")
    private String title;
    @SerializedName("overview")
    private String overview;
    @SerializedName("year")
    private String year;
    @SerializedName("images")
    private BeanImages images;
    @SerializedName("ids")
    private BeanIds ids;

    public BeanMovie(String title, String overview, String year, BeanImages images, BeanIds ids) {
        this.title = title;
        this.overview = overview;
        this.year = year;
        this.images = images;
        this.ids = ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BeanImages getImages() {
        return images;
    }

    public void setImages(BeanImages images) {
        this.images = images;
    }

    public BeanIds getIds() {
        return ids;
    }

    public void setIds(BeanIds ids) {
        this.ids = ids;
    }
}
