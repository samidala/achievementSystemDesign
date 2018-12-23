package com.techdisqus.domain;

import com.techdisqus.exception.ValidationException;

/**
 * abstract statistics.
 */
public abstract class AbstractStatistics {

    protected static class AbstractStatisticsBuilder{
        protected static void isValidInput(long input) throws ValidationException {
            if(input < 0){
                throw new ValidationException("Invalid input");
            }
        }
    }

}
