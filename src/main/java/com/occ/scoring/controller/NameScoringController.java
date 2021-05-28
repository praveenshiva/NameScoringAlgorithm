package com.occ.scoring.controller;

import com.occ.scoring.factory.ScoringFactory;
import com.occ.scoring.service.ScoringAlgorithm;
import com.occ.scoring.service.SortingAlgorithm;
import com.occ.scoring.util.ScoringConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

/**
 * @author Praveen Siva
 *
 * <p>Utility class for scoring names from a file
 * This class has to be enhanced with a new method when new sorting or scoring algorithm is added
 * </p>
 */
public class NameScoringController {
    static Logger logger = LoggerFactory.getLogger(NameScoringController.class);

    /**
     * <p> This method takes the file path as parameter and invokes corresponding method to process the score</p>
     *
     * @param path      an absolute path for the file
     * @param delimiter a delimiter to be used to split names
     * @param sorting   Sorting Algorithm to be used
     * @param scoring   Scoring Algorithm to be used
     * @return Final Score
     */
    public static int getNamesScoreFromFile(String path, String delimiter, String sorting, String scoring) {
        logger.info("Reading the file from: " + path);
        File input = new File(path);
        if (!input.isFile()) {
            logger.error("File does not exists in given path {} and returning total score as -1", path);
            return -1;
        }
        String data;
        try (FileReader fileReader = new FileReader(input); BufferedReader reader = new BufferedReader(fileReader)) {
            data = reader.readLine();
            return getScoreByFirstName(data, delimiter, sorting, scoring);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return -1;
        }
    }

    /**
     * <p> This method takes data as a String, uses Factory pattern to initialize corresponding
     * Sorting and Scoring algorithms</p>
     *
     * @param data      Names String with delimiter
     * @param delimiter a delimiter to be used to split names
     * @param sort      Sorting Algorithm to be used
     * @param scoring   Scoring Algorithm to be used
     * @return Final Score
     */
    public static int getScoreByFirstName(String data, String delimiter, String sort, String scoring) throws Exception {
        logger.info("Getting score by first name {} with delimiter {}", data, delimiter);
        int totScore = -1;
        try {
        if (null == data || data.length() == 0)
            return -1;
        if (delimiter == null) {
            logger.warn("Delimiter is not provided hence default delimiter {} will be applied", ScoringConstants.DELIMITER);
            delimiter = ScoringConstants.DELIMITER;
        }
        String[] names = data.substring(1, data.length() - 1).split(delimiter);
        ScoringAlgorithm scoringService = ScoringFactory.getScoringAlgorithm(scoring);
        SortingAlgorithm sorting = ScoringFactory.getSortingAlgorithm(sort);
        if (null == names || names.length == 0)
            logger.warn("No names in the file.. score would be zero");

        sorting.getSortedList(Arrays.asList(names));
        totScore = scoringService.getFileScore(Arrays.asList(names));
        logger.info("Returning the total score : " + totScore); }
        catch(Exception e) {
            logger.error("Exception occurred {}" , e.getMessage());
            throw e;
        }
        return totScore;

    }
}
