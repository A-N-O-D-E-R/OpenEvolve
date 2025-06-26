package bio.anode.ale.service;

import java.util.List;

import bio.anode.ale.core.specifications.Operator;

public interface OperatorService {
    List<Operator> getOperators();
 
    void updateOperatorsFromStrings(List<String> var1);
 
    List<String> exportOperatorsToCSV(String var1);
 
    Operator getOperator(String var1);
 }
