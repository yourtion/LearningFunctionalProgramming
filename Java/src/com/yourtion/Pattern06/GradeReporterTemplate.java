package com.yourtion.Pattern06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yourtion on 12/10/2016.
 */
public abstract class GradeReporterTemplate {

    public void reportGrades(List<Double> grades) {
        List<String> convertedGrades = new ArrayList<String>();
        for (Double grade : grades) {
            convertedGrades.add(numToLetter(grade));
        }
        printGradeReport(convertedGrades);
    }

    protected abstract String numToLetter(Double grade);

    protected abstract void printGradeReport(List<String> grades);
}
