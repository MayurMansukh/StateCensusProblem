package com.State_Census_Analyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    StateCensusAnalyser censusAnalyser;
    private String State_Census_Correct_Path="/Users/manojmansukh/Downloads/IndiaStateCensusData.csv";
    private String Correct_Path="/Users/manojmansukh/Downloads/IndiaStateCensusData.csv";
    private String Wrong_Path="/Users/manojmansukh/Downloads/IndiaStateCensusData.csv";
    private String Wrong_file_type="/Users/manojmansukh/Downloads/IndiaStateCensusData.txt";
    private String State_Code_Correct_path="\"/Users/manojmansukh/Downloads/IndiaStateCensusData.csv";

    @BeforeAll
    public void setup() {
        censusAnalyser =new StateCensusAnalyser();
    }

    @Test
    public void to_check_if_data_is_loaded() throws CustomException {
        int numofEnteries = censusAnalyser.loadStateCensusData(State_Census_Correct_Path);
        Assertions.assertEquals(29, numofEnteries);
    }

    @Test
    public void given_Wrong_file_path_should_return_custom_exception() throws CustomException{
        try{
            censusAnalyser.loadStateCensusData(Wrong_Path);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assertions.assertEquals(CustomException.ExceptionType.Wrong_File,e.type);
        }
    }

    @Test
    public void given_wrong_file_type_should_throw_custom_exception() throws CustomException{
        try{
            censusAnalyser.loadStateCensusData(Wrong_file_type);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assertions.assertEquals(e.type,CustomException.ExceptionType.Wrong_File_Type);
        }
    }

    @Test
    public void given_wrong_delimiter_should_throw_custom_exception(){
        try{
            censusAnalyser.loadStateCensusData(State_Census_Correct_Path);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assertions.assertEquals(e.type, CustomException.ExceptionType.Wrong_File_Delimiter);
        }
    }

    @Test
    public void given_wrong_header_should_throw_custom_exception(){
        try {
            censusAnalyser.loadStateCensusData(State_Code_Correct_path);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assertions.assertEquals(e.type, CustomException.ExceptionType.Wrong_Header);
        }
    }

    @Test
    public void given_correct_path_should_return_count() throws CustomException {
        int numofEnteries = censusAnalyser.loadStateCodeData(State_Code_Correct_path);
        Assertions.assertEquals(37, numofEnteries);
    }

    @Test
    public void given_wrong_path_should_return_custom_exception() throws CustomException{
        try{
            censusAnalyser.loadStateCodeData(Wrong_Path);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assertions.assertEquals(CustomException.ExceptionType.Wrong_File,e.type);
        }
    }


}
