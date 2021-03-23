package com.State_Census_Analyser;
import com.opencsv.bean.CsvBindByName;

public class CSVStateCensusAnalyser {

    @CsvBindByName
    public String State;

    @CsvBindByName(column = "Population",required = true)
    public long Population;

    @CsvBindByName(column = "AreaInSqKm",required = true)
    public long AreaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm",required = true)
    public long DensityPerSqKm;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public long getPopulation() {
        return Population;
    }

    public void setPopulation(long population) {
        Population = population;
    }

    public long getAreaInSqKm() {
        return AreaInSqKm;
    }

    public void setAreaInSqKm(long areaInSqKm) {
        AreaInSqKm = areaInSqKm;
    }

    public long getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public void setDensityPerSqKm(long densityPerSqKm) {
        DensityPerSqKm = densityPerSqKm;
    }


    @Override
    public String toString() {
        return "CSVStateCensusAnalyser{" +
                "State='" + State + '\'' +
                ", Population=" + Population +
                ", AreaInSqKm=" + AreaInSqKm +
                ", DensityPerSqKm=" + DensityPerSqKm +
                '}';
    }
}