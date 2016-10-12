package com.yourtion.Pattern06;

import java.util.*;

/**
 * Created by Yourtion on 12/10/2016.
 */
public class FullGradeReporter extends GradeReporterTemplate {
    @Override
    public String numToLetter(Double grade) {
        if (grade <= 5.0 && grade > 4.0)
            return "A";
        else if (grade <= 4.0 && grade > 3.0)
            return "B";
        else if (grade <= 3.0 && grade > 2.0)
            return "C";
        else if (grade <= 2.0 && grade > 0.0)
            return "D";
        else if (grade == 0.0)
            return "F";
        else
            return "N/A";
    }

    @Override
    protected void printGradeReport(List<String> grades) {
        SortedMap<String, Integer> gradeCounts = new TreeMap<String, Integer>();

        for (String grade : grades) {
            Integer currentGradeCount = gradeCounts.get(grade);
            if (null == currentGradeCount)
                gradeCounts.put(grade, 1);
            else
                gradeCounts.put(grade, currentGradeCount + 1);
        }

        for (Map.Entry<String, Integer> gradeCount : gradeCounts.entrySet()) {
            StringBuffer bar = new StringBuffer();
            for (int i = 0; i < gradeCount.getValue(); i++)
                bar.append("*");
            System.out.printf("%s: %s\n", gradeCount.getKey(), bar);
        }
    }

    public void run() {
        GradeReporterTemplate gradeReporter = new FullGradeReporter();
        List<Double> grades = Arrays.asList( 5.0, 4.0, 4.4, 2.2, 3.3, 3.5 );
        gradeReporter.reportGrades(grades);
    }
}