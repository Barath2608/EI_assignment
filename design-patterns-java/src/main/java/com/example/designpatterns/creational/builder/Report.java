package com.example.designpatterns.creational.builder;

import java.util.List;

public class Report {
    private String title;
    private List<String> sections;
    private String footer;

    public Report() {}

    public void setTitle(String title) { this.title = title; }
    public void setSections(List<String> sections) { this.sections = sections; }
    public void setFooter(String footer) { this.footer = footer; }

    @Override
    public String toString() {
        return "Report{title='" + title + "', sections=" + sections + ", footer='" + footer + "'}";
    }
}
