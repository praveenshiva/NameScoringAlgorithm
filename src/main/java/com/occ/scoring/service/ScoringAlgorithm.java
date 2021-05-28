package com.occ.scoring.service;

import java.util.List;

/**
 * @author Praveen Siva
 * <p> This interface contains method declarations for scoring implementation </p>
 */

public interface ScoringAlgorithm {
    int getFileScore(List<String> names);

    int getScore(String name, int i);
}
