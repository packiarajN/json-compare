package org.paypal.comparator.matcher;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Set;

import org.paypal.comparator.CompareMode;
import org.paypal.comparator.JsonComparator;

public class JsonMatcher extends AbstractJsonMatcher {

    public JsonMatcher(JsonNode expected, JsonNode actual, JsonComparator comparator,
                       Set<CompareMode> compareModes) {
        super(expected, actual, comparator, compareModes);
    }

    @Override
    public void matches() throws MatcherException {
        if (isJsonObject(expected) && isJsonObject(actual)) {
            new JsonObjectMatcher(expected, actual, comparator, compareModes).matches();
        } else if (isJsonArray(expected) && isJsonArray(actual)) {
            new JsonArrayMatcher(expected, actual, comparator, compareModes).matches();
        } else if (isJsonText(expected) && isJsonText(actual)) {
            new JsonTextMatcher(expected, actual, comparator, compareModes).matches();
        } else {
            throw new MatcherException("Different JSON types");
        }
    }
}
