package com.example.viikko9;

public class Show {

    private String title;
    private String id;
    private String start;
    private String end;
    private String year;
    private String sUrl;
    public Show(){}

    public Show(String name, String id, String start, String end,
                String year, String sUrl){
        this.title = name;
        this.id = id;
        this.start = start;
        this.end = end;
        this.year = year;
        this.sUrl = sUrl;
    }
    public String getId(){
        return title;
    }
    public String getTitle(){
        return id;
    }
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
    public String getYear() {
        return year;
    }
    public String getsUrl() {
        return sUrl;
    }
}

