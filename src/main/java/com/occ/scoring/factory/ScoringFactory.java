package com.occ.scoring.factory;

import com.occ.scoring.exception.NoScoringAlgorithmFoundException;
import com.occ.scoring.exception.NoSortingAlgorithmFoundException;
import com.occ.scoring.service.ScoringAlgorithm;
import com.occ.scoring.service.SortingAlgorithm;
import com.occ.scoring.service.impl.ScoringByFirstNameImpl;
import com.occ.scoring.service.impl.SortingByAlphabetImpl;
import com.occ.scoring.util.ScoringConstants;

/**
 * @author Praveen Siva
 * <p> Factory class for creating sorting and scoring algorithms </p>
 * <p> This class needs to be enhanced to handle/ initialize additional scoring or scoring objects </p>
 */

public class ScoringFactory {
    private ScoringFactory() {

    }

    /**
     * @param algorithmType
     * @return Scoring Algorithm Instance
     * @throws NoScoringAlgorithmFoundException
     */
    public static ScoringAlgorithm getScoringAlgorithm(String algorithmType) throws NoScoringAlgorithmFoundException {
        ScoringAlgorithm scoringAlgorithm = null;
        if (algorithmType.equalsIgnoreCase(ScoringConstants.SCORING_TYPE_FIRST_NAME))
            scoringAlgorithm = new ScoringByFirstNameImpl();
        else
            throw new NoScoringAlgorithmFoundException("Scoring algorithm implementation is not available for " + algorithmType);

        return scoringAlgorithm;
    }

    /**
     * @param algorithmType
     * @return Sorting algorithm instance
     * @throws NoSortingAlgorithmFoundException
     */
    public static SortingAlgorithm getSortingAlgorithm(String algorithmType) throws NoSortingAlgorithmFoundException {
        SortingAlgorithm sortingAlgorithm = null;
        if (algorithmType.equalsIgnoreCase(ScoringConstants.SORTING_TYPE))
            sortingAlgorithm = new SortingByAlphabetImpl();
        else
            throw new NoSortingAlgorithmFoundException("Sorting algorithm implementation is not available for " + algorithmType);

        return sortingAlgorithm;
    }
}
