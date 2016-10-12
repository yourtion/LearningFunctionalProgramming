package com.yourtion.Pattern06;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Yourtion on 12/10/2016.
 */
public class PlusMinusGradeReporter extends GradeReporterTemplate {
    @Override
    protected String numToLetter(Double grade) {
        if (grade <= 5.0 && grade > 4.7)
            return "A";
        else if (grade <= 4.7 && grade > 4.3)
            return "A-";
        else if (grade <= 4.3 && grade > 4.0)
            return "B+";
        else if (grade <= 4.0 && grade > 3.7)
            return "B";
        else if (grade <= 3.7 && grade > 3.3)
            return "B-";
        else if (grade <= 3.3 && grade > 3.0)
            return "C+";
        else if (grade <= 3.0 && grade > 2.7)
            return "C";
        else if (grade <= 2.7 && grade > 2.3)
            return "C-";
        else if (grade <= 2.3 && grade > 0.0)
            return "D";
        else if (grade == 0.0)
            return "F";
        else
            return "N/A";
    }

    @Override
    protected void printGradeReport(List<String> grades) {
        for (String grade : grades) {
            System.out.println("Grade is: " + grade);
        }
    }

    public void run() {
        GradeReporterTemplate gradeReporter = new PlusMinusGradeReporter();
        List<Double> grades = Arrays.asList(5.0, 4.0, 4.4, 2.2, 3.3, 3.5);
        gradeReporter.reportGrades(grades);
    }
}