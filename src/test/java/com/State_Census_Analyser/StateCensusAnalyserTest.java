package com.State_Census_Analyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    private StateCensusAnalyser stateCensusAnalyser;
    private String path = "/Users/manojmansukh/Downloads/IndiaStateCensusData.csv";
    private String Wrong_path = "/Users/manojmansukh/Downloads/IndiaStateCensusData.csv";

    @BeforeAll
    public void setup() {
        stateCensusAnalyser = new StateCensusAnalyser();
    }

    @Test
    void checkDataIsLoaded() throws CustomException{
        int size = stateCensusAnalyser.loadData(path);
        System.out.println(size);
        Assertions.assertEquals(30, size);

    }

    @Test
    public void given_Wrong_file_path_should_return_custom_exception() throws CustomException {
        try {
            stateCensusAnalyser.loadData(Wrong_path);
        } catch (CustomException e) {
            throw new CustomException("Wrong file path");
        }

    }
}
