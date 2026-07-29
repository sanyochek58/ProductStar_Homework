package org.example;

import java.util.Set;

public interface Analytics {

    Set<String> getCategories();
    Integer getAggregationByCategoryAndPlace(String category, String place);
    Integer getTotalCount();

}
