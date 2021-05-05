package org.paypal.comparator;

public interface JsonComparator {

    boolean compareValues(Object expected, Object actual);

    boolean compareFields(String expected, String actual);
}
