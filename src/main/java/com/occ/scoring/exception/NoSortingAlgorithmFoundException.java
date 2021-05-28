package com.occ.scoring.exception;

/**
 * <p> Custom exception class if no suitable sorting algorithm is found</p>
 *
 * @author Praveen Siva
 */

public class NoSortingAlgorithmFoundException extends RuntimeException {
    public NoSortingAlgorithmFoundException(String message) {
        super(message);
    }
}
