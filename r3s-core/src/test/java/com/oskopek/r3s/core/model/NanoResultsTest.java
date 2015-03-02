package com.oskopek.r3s.core.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oskopek on 2/22/15.
 */
public class NanoResultsTest {

    private long CONVERT = 1_000_000_000;

    @Test
    public void getResultTimeTest() {
        NanoResults nr = new NanoResults(CONVERT * 3600 * 1 + CONVERT * 60 * 25 + CONVERT * 59);
        assertEquals("1:25:59.000", nr.getResultTime());

        nr = new NanoResults(CONVERT * 3600 * 1 + CONVERT * 60 * 25 + CONVERT * 61);
        assertEquals("1:26:01.000", nr.getResultTime());

        nr = new NanoResults(CONVERT * 3600 * 1 + CONVERT * 60 * 61 + CONVERT * 59);
        assertEquals("2:01:59.000", nr.getResultTime());

        nr = new NanoResults(CONVERT * 3600 * 1 + CONVERT * 60 * 25 + CONVERT * 30 + CONVERT / 10 * 5);
        assertEquals("1:25:30.500", nr.getResultTime());

        nr = new NanoResults(CONVERT * 3600 * 1 + CONVERT * 60 * 25 + CONVERT * 30 + CONVERT / 100 * 9);
        assertEquals("1:25:30.090", nr.getResultTime());
    }

}
