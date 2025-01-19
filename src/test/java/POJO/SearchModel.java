package POJO;


public class SearchModel {

    private String searchPhrase;

    public SearchModel() {
    }

    public SearchModel(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public String getSearchPhrase() {
        return searchPhrase;
    }

    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    @Override
    public String toString() {
        return "SearchModel: {" +
                "searchPhrase='" + searchPhrase + '\'' +
                '}';
    }
}
