package com.stt.challenge.question2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stt.challenge.question2.comparator.CustomComparator;
import com.stt.challenge.question2.model.SortResult;

public class CustomStringSorter {
    
    private static final Collector<CharSequence, ?, String> BRACKET_COLLECTOR = Collectors.joining(", ", "{ ", " }");
    private static final Collector<CharSequence, ?, String> PLAINTEXT_COLLECTOR = Collectors.joining();
    private static final Comparator<? super String> CUSTOM_COMPARATOR = new CustomComparator();
    
    public SortResult sort(String baseString) {
        
        String[] array = baseString.split("");
        
        SortResult sortResult = new SortResult();
        
        sortResult.setOriginal(getStream(array).collect(BRACKET_COLLECTOR));
        sortResult.setSorted(getStream(array).sorted(CUSTOM_COMPARATOR).collect(BRACKET_COLLECTOR));
        sortResult.setFinalString(getStream(array).sorted(CUSTOM_COMPARATOR).collect(PLAINTEXT_COLLECTOR));

        log("Original array: "+sortResult.getOriginal());
        log("Sorted array  : "+sortResult.getSorted());
        log("Final String  : "+sortResult.getFinalString());
        
        return sortResult;
    }
    
    private Stream<String> getStream(String[] stringArray) {
        return Arrays.stream(stringArray);
    }

    protected void log(String string) {
        System.out.println(string);
    }

}
