package com.occ.scoring;

import com.occ.scoring.controller.NameScoringController;
import com.occ.scoring.util.ScoringConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScoreNames {
    static Logger logger = LoggerFactory.getLogger(ScoreNames.class);

    public static void main(String args[]) {
          if(args.length==0) {
              logger.error("Please provide the file path as command line argument");
              return;
          }
        logger.info("Total score from file is {}",NameScoringController.getNamesScoreFromFile(args[0].trim(), null, ScoringConstants.SORTING_TYPE, ScoringConstants.SCORING_TYPE_FIRST_NAME));
    }
}
