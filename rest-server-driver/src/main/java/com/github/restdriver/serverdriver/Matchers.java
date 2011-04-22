package com.github.restdriver.serverdriver;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import com.github.restdriver.serverdriver.http.response.Response;
import com.github.restdriver.serverdriver.matchers.HasHeader;
import com.github.restdriver.serverdriver.matchers.HasHeaderWithValue;
import com.github.restdriver.serverdriver.matchers.HasResponseBody;
import com.github.restdriver.serverdriver.matchers.HasStatusCode;

/**
 * Class to help easy & fluent use of our matchers.
 *
 * User: mjg
 * Date: 21/04/11
 * Time: 11:46
 */
public final class Matchers {

    private Matchers() {
    }

    public static TypeSafeMatcher<Response> hasStatusCode(int statusCode) {
        return new HasStatusCode(is(statusCode));
    }

    public static TypeSafeMatcher<Response> hasStatusCode(Matcher<Integer> statusCodeMatcher) {
        return new HasStatusCode(statusCodeMatcher);
    }

    public static TypeSafeMatcher<Response> hasResponseBody(Matcher<String> bodyMatcher) {
        return new HasResponseBody(bodyMatcher);
    }

    public static TypeSafeMatcher<Response> hasHeader(String name) {
        return new HasHeader(name);
    }

    public static TypeSafeMatcher<Response> hasHeaderWithValue(String name, Matcher<String> valueMatcher) {
        return new HasHeaderWithValue(name, valueMatcher);
    }

}
