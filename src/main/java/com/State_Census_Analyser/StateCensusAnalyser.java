package com.State_Census_Analyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StateCensusAnalyser {

    public int loadData(String path) throws CustomException {
        if(path.contains(".csv"))
        {
            int numofEnteries=0;
            try{
                Reader reader= Files.newBufferedReader(Paths.get(path));
                CsvToBean<CSVStateCensusAnalyser> csvToBean=new CsvToBeanBuilder(reader)
                        .withType(CSVStateCensusAnalyser.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                Iterator<CSVStateCensusAnalyser> csvStateCensusAnalyserIterator=csvToBean.iterator();
                Iterable<CSVStateCensusAnalyser> iterator=()  -> csvStateCensusAnalyserIterator;
                return (int) StreamSupport.stream(iterator.spliterator(), false).count();
            }catch (IOException e){
                throw new CustomException(e.getMessage(), CustomException.ExceptionType.Wrong_File);
            }catch (RuntimeException e){
                throw new CustomException(e.getMessage(), CustomException.ExceptionType.Wrong_File_Delimiter);
            }
        }
        else{
            throw new CustomException("Wrong file type it should be .csv type", CustomException.ExceptionType.Wrong_File_Type);
        }
    }
}
