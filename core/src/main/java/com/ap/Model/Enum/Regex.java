package com.ap.Model.Enum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regex {
    EMAIL("^([a-zA-Z0-9]([a-zA-Z0-9-._]*[a-zA-z0-9])?)@([a-zA-Z0-9]([a-zA-Z0-9-]*[a-zA-Z0-9])?)\\.([a-zA-Z0-9-]+[a-zA-Z0-9])$"),
    USERNAME("^[a-zA-Z0-9-]+$"),

    ;
    private final Pattern pattern;

    Regex(String regex){
        pattern = Pattern.compile(regex);
    }

    public Matcher getMatcher(String input){
        Matcher matcher = this.pattern.matcher(input);
        if (matcher.matches()){
            return matcher;
        }
        return null;
    }
}
