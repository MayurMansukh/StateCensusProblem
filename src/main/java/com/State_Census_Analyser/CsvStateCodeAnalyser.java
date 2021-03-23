package com.State_Census_Analyser;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCodeAnalyser {

    @CsvBindByName
    public int SrNo;

    @CsvBindByName(column = "StateName",required = true)
    public String StateName;

    @CsvBindByName(column = "TIN",required = true)
    public int TIN;

    @CsvBindByName(column = "StateCode",required = true)
    public String StateCode;

    public int getSrNo() {
        return SrNo;
    }

    public void setSrNo(int srNo) {
        SrNo = srNo;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public int getTIN() {
        return TIN;
    }

    public void setTIN(int TIN) {
        this.TIN = TIN;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }
}
