package com.State_Census_Analyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    private StateCensusAnalyser stateCensusAnalyser;;
    private String Correct_Path="/Users/manojmansukh/Downloads/IndiaStateCensusData.csv";
    private String Wrong_Path="/Users/manojmansukh/Downloads/IndiaStateCensusData.csv";
    private String Wrong_file_type="/Users/manojmansukh/Downloads/IndiaStateCensusData.csv";


    @BeforeAll
    public void setup() {
        stateCensusAnalyser = new StateCensusAnalyser();
    }

    @Test
    public void to_check_if_data_is_loaded() throws CustomException {
        int numofEnteries = stateCensusAnalyser.loadData(Correct_Path);
        Assertions.assertEquals(29, numofEnteries);
    }

    @Test
    public void given_Wrong_file_path_should_return_custom_exception() throws CustomException{
        try{
            stateCensusAnalyser.loadData(Wrong_Path);
        }catch (CustomException e){
            System.out.println(e.type);
            Assertions.assertEquals(CustomException.ExceptionType.Wrong_File,e.type);
        }
    }

    @Test
    public void given_wrong_file_type_should_throw_custom_exception() throws CustomException{
        try{
            stateCensusAnalyser.loadData(Wrong_file_type);
        }catch (CustomException e){
            System.out.println(e.type);
            Assertions.assertEquals(e.type,CustomException.ExceptionType.Wrong_File_Type);
        }
    }

    @Test
    public void given_wrong_delimiter_should_throw_custom_exception(){
        try{
            stateCensusAnalyser.loadData(Correct_Path);
        }catch (CustomException e){
            System.out.println(e.type);
            Assertions.assertEquals(e.type, CustomException.ExceptionType.Wrong_File_Delimiter);
        }
    }

}
