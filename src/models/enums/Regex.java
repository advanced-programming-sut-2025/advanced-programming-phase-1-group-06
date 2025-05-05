package models.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regex {
    EXIT("^\\s*exit\\s+game\\s*"),
    REGISTER("^\\s*register\\s+-u\\s+(?<username>.+)\\s+-p\\s+(?<password>.+)\\s+(?<confirmation>.+)\\s+-n\\s+(?<nickname>.+)\\s+-e\\s+(?<email>.+)\\s+-g\\s+(?<gender>.+)\\s*$"),
    PICK_QUESTION("^\\s*pick\\s+question\\s+-q\\s+(?<questionNumber>.+)\\s+-a\\s+(?<answer>.+)\\s+-c\\s+(?<confirmation>.+)\\s*$"),
    LOGIN("^\\s*login\\s+-u\\s*(?<username>.+)\\s+-p\\s+(?<password>.+)(\\s+?<stay>stay-logged-in)?\\s*$"),
    FORGET("^\\s*forget\\s+password\\s+-u\\s+(?<username>.+)\\s*"),
    USERNAME("^[a-zA-Z0-9-]+$"),
    EMAIL("^([a-zA-Z0-9]([a-zA-Z0-9-._]*[a-zA-z0-9])?)@([a-zA-Z0-9]([a-zA-Z0-9-]*[a-zA-Z0-9])?).([a-zA-Z0-9-]+[a-zA-Z0-9])$"),
    STRONG_PASS("^(?=.{8,}$)" +        // at least 8 chars
            "(?=.*[a-z])" +        // at least one lowercase
            "(?=.*[A-Z])" +        // at least one uppercase
            "(?=.*\\d)"   +        // at least one digit
            "(?=.*[!#$%^&*()=+{}\\[\\]|\\/:;'\",<>?])" + // at least one special
            ".*$"),
//    PASSWORDSPECIAL("?=.*[!#$%^&*()=+{}\\[\\]|\\/:;'\",<>?]"),
//    PASSWORDNUMBER("?=.[0-9]"),
//    PASSWORDLOWERCASE("?=.[a-z]"),
//    PASSWORDUPPERCASE("?=.[A-Z]"),
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
