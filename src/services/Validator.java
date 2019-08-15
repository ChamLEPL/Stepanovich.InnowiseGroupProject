package services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator implements Serializable {
    public List<String> generateValidList(List<String> mobilePhones){
        List<String> validList = new ArrayList<>();
        for (String item : mobilePhones){
            if (isValidMobile(item)){
                validList.add(item);
            }
        }
        return validList;
    }
    private Matcher generateRegexForMobile(String input){
        Pattern patternForMobile = Pattern.compile("375\\d{2} \\d{7}");
        Matcher matcherForValidMobile = patternForMobile.matcher(input);
        return  matcherForValidMobile;
    }

    public boolean isValidMobile(String input){
        Matcher matcherForValidMobile = generateRegexForMobile(input);
        return matcherForValidMobile.matches();

    }

    private Matcher generateRegexForEmail(String input){
        Pattern patternForEmail = Pattern.compile("\\w{3,7}@\\w{5}.\\w{3}");
        Matcher matcherForValidEmail = patternForEmail.matcher(input);
        return  matcherForValidEmail;
    }

    public boolean isValidEmail(String input){
        Matcher matcherForValidEmail = generateRegexForEmail(input);
        return matcherForValidEmail.matches();
    }
}
