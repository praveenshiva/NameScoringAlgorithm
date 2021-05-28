package com.occ.scoring.exception;

/**
 * <p> Custom exception class if no suitable scoring algorithm is found</p>
 *
 * @author Praveen Siva
 */
public class NoScoringAlgorithmFoundException extends RuntimeException {

    public NoScoringAlgorithmFoundException(String message) {
        super(message);
    }
}
