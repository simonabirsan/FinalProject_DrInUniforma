package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import POJO.SearchModel;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SearchDataProvider {

    @DataProvider(name = "searchValidDataProvider")
    public Iterator<Object[]> searchValidDataProvider() throws IOException {
        Collection<Object[]> searchDP = new ArrayList<>();
        File jsonFile = new File("src/test/resources/testData/searchValidTestData.json");

        ObjectMapper objectMapper = new ObjectMapper();
        SearchModel[] searchModels = objectMapper.readValue(jsonFile, SearchModel[].class);

        for (SearchModel searchModel : searchModels)
            searchDP.add(new Object[]{searchModel});
        return searchDP.iterator();
    }

    @DataProvider(name = "searchInvalidDataProvider")
    public Iterator<Object[]> searchInvalidDataProvider() throws IOException {
        Collection<Object[]> searchDP = new ArrayList<>();
        File jsonFile = new File("src/test/resources/testData/searchInvalidTestData.json");

        ObjectMapper objectMapper = new ObjectMapper();
        SearchModel[] searchModels = objectMapper.readValue(jsonFile, SearchModel[].class);

        for (SearchModel searchModel : searchModels)
            searchDP.add(new Object[]{searchModel});
        return searchDP.iterator();
    }
}
