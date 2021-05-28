package com.occ.scoring.service.impl;

import com.occ.scoring.service.ScoringAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Praveen Siva
 * <p> Concrete class to implement Scoring Algorithm by First Name</p>
 */

public class ScoringByFirstNameImpl implements ScoringAlgorithm {

    Logger logger = LoggerFactory.getLogger(ScoringByFirstNameImpl.class);

    /**
     * @param names
     * @return Total score
     */
    @Override
    public int getFileScore(List<String> names) {
        logger.info("Executing getFileScore ");
        int totScore = 0;
        int i = 1;
        for (String name : names) {
            totScore = totScore + getScore(name, i++);
        }
        logger.info("Execution completed for getFileScore with total score {}", totScore);

        return totScore;
    }

    /**
     * @param name Name
     * @param i    Position
     * @return Name Score
     */
    @Override
    public int getScore(String name, int i) {
        logger.debug("Executing getScore for {} in the position of {}", name, i);
        int score = 0;
        for (char c : name.toUpperCase().toCharArray()) {
            // Handles special characters or spaces and skip that character
            if ((c - 'A') < 0 || (c - 'A') > 26) continue;
            score = score + (c - 'A') + 1;
        }
        logger.debug("Execution completed for getScore for {} with  score {}", name, i);
        return score * i;
    }
}
