package com.occ.scoring.controller;

import com.occ.scoring.util.ScoringConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  Please pass the Path variable in all test cases according to file location
 */

class NameScoringControllerTest {

    @Test
    void getNamesScoreFromFile_Test() {
        assertEquals(871198282, NameScoringController.getNamesScoreFromFile("C:\\Practice\\NameScoringAlgorithm\\names.txt", ScoringConstants.DELIMITER, ScoringConstants.SORTING_TYPE, ScoringConstants.SCORING_TYPE_FIRST_NAME));
    }

    @Test
    void getScoreByFirstName_Test() {
        String str = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
        try {
            assertEquals(3194, NameScoringController.getScoreByFirstName(str, ScoringConstants.DELIMITER, ScoringConstants.SORTING_TYPE, ScoringConstants.SCORING_TYPE_FIRST_NAME));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getScoreWithSpecialChars() {
        String str = "\"MAR@#Y\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHO#$N\",\"LYNWOOD\",\"JERE\",\"HAI\"";
        try {
            assertEquals(3194, NameScoringController.getScoreByFirstName(str, ScoringConstants.DELIMITER, ScoringConstants.SORTING_TYPE, ScoringConstants.SCORING_TYPE_FIRST_NAME));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getScoreWithInValidFilePath() {
        assertEquals(-1, NameScoringController.getNamesScoreFromFile("test", ScoringConstants.DELIMITER, ScoringConstants.SORTING_TYPE, ScoringConstants.SCORING_TYPE_FIRST_NAME));
    }

    @Test
    void getScoreWithNullData() {
        try {
            assertEquals(-1, NameScoringController.getScoreByFirstName(null, ScoringConstants.DELIMITER, ScoringConstants.SORTING_TYPE, ScoringConstants.SCORING_TYPE_FIRST_NAME));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getScoreWithSpaces() {
        String str = "\"MAR   @#Y\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO   \",\"SHO#$N\",\"LYNWOOD\",\"JERE\",\"HAI\"";
        try {
            assertEquals(3194, NameScoringController.getScoreByFirstName(str, ScoringConstants.DELIMITER, ScoringConstants.SORTING_TYPE, ScoringConstants.SCORING_TYPE_FIRST_NAME));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void getScoreWithInvalidSorting() {
        String str = "\"MAR   @#Y\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO   \",\"SHO#$N\",\"LYNWOOD\",\"JERE\",\"HAI\"";
        try {
            assertEquals(-1, NameScoringController.getScoreByFirstName(str, ScoringConstants.DELIMITER, ScoringConstants.SORTING_TYPE, "BLABLA"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}