package com.example.designpatterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class ReportBuilder {
    private Report report = new Report();

    public void reset() { report = new Report(); }

    public void setTitle(String t) {
        if (t == null || t.isBlank()) throw new IllegalArgumentException("Title required");
        report.setTitle(t);
    }

    public void setSections(List<String> sections) {
        report.setSections(new ArrayList<>(sections));
    }

    public void setFooter(String f) {
        report.setFooter(f);
    }

    public Report getResult() {
        return report;
    }
}
