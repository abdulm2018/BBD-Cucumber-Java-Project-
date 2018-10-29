package com.shiftedtech.qa.script;


import com.shiftedtech.qa.framework.utils.RegexArrayMatcher;
import com.shiftedtech.qa.framework.utils.RegexMatcher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.collection.IsEmptyCollection;

/**
 * Created by MOHSEN on 09/21/18.
 */
public class HamcrestTest {
//    https://objectpartners.com/2013/09/18/the-benefits-of-using-assertthat-over-other-assert-methods-in-unit-tests/
    @Test
    public void testAssertList() {

        List<String> actual = Arrays.asList("a", "b", "c");
        //List<String> expected = Arrays.asList("a", "b", "c");
        String[] exp = {"a", "b", "c"};
        List<String> expected = Arrays.asList(exp);

        //All passed / true

        //1. Test equal.
        assertThat(actual, is(expected));

        //2. If List has this value?
        assertThat(actual, hasItems("b"));

        //3. Check List Size
        assertThat(actual, hasSize(3));

        assertThat(actual.size(), is(3));

        //4.  List order

        // Ensure Correct order
        assertThat(actual, contains("a", "b", "c"));

        // Can be any order
        assertThat(actual, containsInAnyOrder("c", "b", "a"));

        //5. check empty list
        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(new ArrayList<>(), IsEmptyCollection.empty());

    }

    @Test
    public void testAssertListInteger() {

        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        //All passed / true

        //1. Test equal.
        assertThat(actual, is(expected));

        //2. Check List has this value
        assertThat(actual, hasItems(2));

        //3. Check List Size
        assertThat(actual, hasSize(5));

        assertThat(actual.size(), is(5));

        //4.  List order

        // Ensure Correct order
        assertThat(actual, contains(1, 2, 3, 4, 5));

        // Can be any order
        assertThat(actual, containsInAnyOrder(5, 4, 3, 2, 1));

        //5. check empty list
        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(new ArrayList<>(), IsEmptyCollection.empty());

        //6. Test numeric comparisons
        assertThat(actual, everyItem(greaterThanOrEqualTo(1)));

        assertThat(actual, everyItem(lessThan(10)));

    }

    @Test
    public void test_arrayContaining_items() throws Exception {
        // Given
        String[] strings = {"why", "hello", "there"};

        // Then
        assertThat(strings, is(arrayContaining("why", "hello", "there")));
    }
    @Test
    public void test_arrayContainingInAnyOrder_items() throws Exception {
        // Given
        String[] strings = { "why", "hello", "there" };

        // Then
        assertThat(strings, is(arrayContainingInAnyOrder("hello", "there", "why")));
    }

    @Test
    public void test_arrayContaining_matchers() throws Exception {
        // Given
        String[] strings = {"why", "hello", "there"};

        // Then
        assertThat(strings, is(arrayContaining(startsWith("wh"), equalTo("hello"), endsWith("here"))));
    }
    @Test
    public void test_arrayWithSize_exact() throws Exception {
        // Given
        String[] strings = { "why", "hello", "there" };

        // Then
        assertThat(strings, is(arrayWithSize(3)));
    }

    @Test
    public void test_contains_items() throws Exception {
        // Given
        List<String> strings = Arrays.asList("why", "hello", "there");

        // Then
        assertThat(strings, contains("why", "hello", "there"));
    }

    @Test
    public void test_containsInAnyOrder_items() throws Exception {
        // Given
        List<String> strings = Arrays.asList("why", "hello", "there");

        // Then
        assertThat(strings, containsInAnyOrder("hello", "there", "why"));
    }

    @Test
    public void test_equalTo_value() throws Exception {
        // Given
        String testValue = "value";

        // Then
        assertThat(testValue, equalTo("value"));
    }

    @Test
    public void test_equalToIgnoringCase() throws Exception {
        // Given
        String testValue = "value";

        // Then
        assertThat(testValue, equalToIgnoringCase("VaLuE"));
    }
    @Test
    public void test_startsWithCase() throws Exception {
        // Given
        String testValue = "value";

        // Then
        assertThat(testValue, startsWith("va"));
    }
    @Test
    public void test_endsWithCase() throws Exception {
        // Given
        String testValue = "value";

        // Then
        assertThat(testValue, endsWith("ue"));
    }
    @Test
    public void test_ContainsWithCase() throws Exception {
        // Given
        String testValue = "value";

        // Then
        assertThat(testValue, containsString("lu"));
    }

    @Test
    public void test_RegexCase() throws Exception {
        // Given
        String testValue = "value 5";

        // Then
        assertThat(testValue, RegexMatcher.matchesRegex("value \\d"));
        assertThat(testValue, RegexMatcher.matchesRegex("value [1-5]"));
    }

    @Test
    public void test_RegexCase2() throws Exception {
        // Given
        String testValue = "value 5 was valid";

        assertThat(testValue, RegexMatcher.matchesRegex("value .* (is|was) valid"));
    }

    @Test
    public void verifyColorTagListRegex(){
        String[] actualList = {"Reg 6","Black 8", "Green 7"};
        String[] expectedList = {"Reg \\d","Black \\d", "Green \\d"};

        System.out.println("Expected:" + Arrays.toString(expectedList));
        System.out.println("Actual:" + Arrays.toString(actualList));
        assertThat(actualList, RegexArrayMatcher.matchesRegexArray(expectedList));
    }
}
