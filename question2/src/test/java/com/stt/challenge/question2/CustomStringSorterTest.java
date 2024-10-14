package com.stt.challenge.question2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.stt.challenge.question2.model.FormattedResult;

public class CustomStringSorterTest {
    
    private CustomStringSorter sorterUnderTest;
    private FormattedResult result;

    private String baseString;
    private String expectedString;
    
    @Before
    public void setUp() throws Exception {
        sorterUnderTest = new CustomStringSorter();
    }    

    @Test
    public void testSorter_challengeExample() {
        baseString = "My test";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ M, y,  , t, e, s, t }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , M, e, s, t, t, y }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " Mestty";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    // Single Upper char
    @Test
    public void testSorter_whenSingleUpper_shouldPrintItself() {
        baseString = "Z";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ Z }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{ Z }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = "Z";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    @Test
    public void testSorter_whenSingleUpper_andSpaceAtEnd_shouldPrintItself_andSpaceAtStart() {
        baseString = "Z ";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ Z,   }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , Z }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " Z";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    @Test
    public void testSorter_whenSingleUpper_andSpaceAtStart_shouldPrintItself_andSpaceAtStart() {
        baseString = " Z";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{  , Z }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , Z }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " Z";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    
    // Single Lower char
    @Test
    public void testSorter_whenSingleLower_shouldPrintItself() {
        baseString = "b";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ b }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{ b }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = "b";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    @Test
    public void testSorter_whenSingleLower_andSpaceAtEnd_shouldPrintItself_andSpaceAtStart() {
        baseString = "a ";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ a,   }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , a }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " a";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    @Test
    public void testSorter_whenSingleLower_andSpaceAtStart_shouldPrintItself_andSpaceAtStart() {
        baseString = " a";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{  , a }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , a }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " a";
        Assert.assertEquals(expectedString, result.getFinalString());
    }


    // Sorted input
    @Test
    public void testSorter_whenUpperSorted_shouldPrintThemselves() {
        baseString = "ABC";
        result = sorterUnderTest.sort(baseString);

        expectedString = "{ A, B, C }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{ A, B, C }";
        Assert.assertEquals(expectedString, result.getSorted());
    }
    
    @Test
    public void testSorter_whenLowerSorted_shouldPrintThemselves() {
        baseString = "def";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ d, e, f }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{ d, e, f }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = "def";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    
    // Unsorted input
    @Test
    public void testSorter_whenUpperUnsorted_shouldPrintSorted() {
        baseString = "CBA";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ C, B, A }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{ A, B, C }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = "ABC";
        Assert.assertEquals(expectedString, result.getFinalString());
        
        
        baseString = "ZEY";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ Z, E, Y }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{ E, Y, Z }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = "EYZ";
        Assert.assertEquals(expectedString, result.getFinalString());
    }



    // Letters and Spaces
    @Test
    public void testSorter_whenUpperUnsorted_andSpaceAtStart_shouldPrintSorted_andSpaceAtStart() {
        baseString = " ZEY";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{  , Z, E, Y }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , E, Y, Z }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " EYZ";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    @Test
    public void testSorter_whenUpperUnsorted_andSpaceAtEnd_shouldPrintSorted_andSpaceAtStart() {
        baseString = "ZEY ";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ Z, E, Y,   }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , E, Y, Z }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " EYZ";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    @Test
    public void testSorter_whenUpperUnsorted_andSpaceAtMiddle_shouldPrintSorted_andSpaceAtStart() {
        baseString = "DC BA";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ D, C,  , B, A }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , A, B, C, D }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " ABCD";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    @Test
    public void testSorter_whenLowerUnsorted_andSpaceAtMiddle_shouldPrintSorted_andSpaceAtStart() {
        baseString = "dc ba";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ d, c,  , b, a }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , a, b, c, d }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " abcd";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    
    // Uppers before Lowers
    @Test
    public void testSorter_whenNameAndSurname_shouldPrintSorted_spaceAtStart_andUppersBeforeLowers() {
        baseString = "Matheus Queiroz";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ M, a, t, h, e, u, s,  , Q, u, e, i, r, o, z }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , M, Q, a, e, e, h, i, o, r, s, t, u, u, z }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " MQaeehiorstuuz";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    // Camel Case
    @Test
    public void testSorter_whenCamelCase_shouldPrintSorted_andUppersBeforeLowers() {
        baseString = "AbCdE";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ A, b, C, d, E }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{ A, C, E, b, d }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = "ACEbd";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    @Test
    public void testSorter_whenCamelCase_andSpaceAtMiddle_shouldPrintSorted_andUppersBeforeLowers() {
        baseString = "AbC dE";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{ A, b, C,  , d, E }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  , A, C, E, b, d }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " ACEbd";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    // Empties and Spaces
    @Test
    public void testSorter_whenEmpty_shouldPrintOnlyBrackets() {
        baseString = "";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{  }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  }";
        Assert.assertEquals(expectedString, result.getSorted());
    }
    
    @Test
    public void testSorter_whenOnlyOneSpace_shouldPrintItselfBracked() {
        baseString = " ";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{   }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{   }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = " ";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    @Test
    public void testSorter_whenOneOrMoreSpaces_shouldPrintThemselves_withCommaAndBrackets() {
        baseString = "   ";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{  ,  ,   }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  ,  ,   }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = "   ";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
    
    @Test
    public void testSorter_whenManySpacesAmongLetters_shouldPrintSpacesFirst_thenLettersUppersBeforLowers() {
        baseString = "      aA      ";
        result = sorterUnderTest.sort(baseString);
        
        expectedString = "{  ,  ,  ,  ,  ,  , a, A,  ,  ,  ,  ,  ,   }";
        Assert.assertEquals(expectedString, result.getOriginal());
        
        expectedString = "{  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , A, a }";
        Assert.assertEquals(expectedString, result.getSorted());
        
        expectedString = "            Aa";
        Assert.assertEquals(expectedString, result.getFinalString());
    }
}
