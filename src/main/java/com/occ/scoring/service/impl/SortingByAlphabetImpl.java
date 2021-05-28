package com.occ.scoring.service.impl;

import com.occ.scoring.service.SortingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * @author Praveen Siva
 * <p> Concrete class to implement Sorting Algorithm by alphabet</p>
 */

public class SortingByAlphabetImpl implements SortingAlgorithm {
    Logger logger = LoggerFactory.getLogger(SortingByAlphabetImpl.class);

    /**
     * @param names List of Names
     * @return Sorted List
     */

    @Override
    public List<String> getSortedList(List<String> names) {
        logger.info("Executing getSortedList");
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
        return names;
    }
}
