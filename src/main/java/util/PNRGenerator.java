package util;

import java.util.concurrent.atomic.AtomicLong;

/** Generates unique PNR values within one application run. */
public final class PNRGenerator {
    private static final AtomicLong COUNTER = new AtomicLong(100000);
    private PNRGenerator() { }
    public static String nextPnr() { return "PNR" + COUNTER.incrementAndGet(); }
}
