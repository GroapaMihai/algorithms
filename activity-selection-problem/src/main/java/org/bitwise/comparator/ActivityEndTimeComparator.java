package org.bitwise.comparator;

import org.bitwise.model.Activity;

import java.util.Comparator;

public class ActivityEndTimeComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        // Null checks
        if (a1 == null && a2 == null) {
            return 0; // Both are null, considered equal
        }
        if (a1 == null) {
            return -1; // Null values come first
        }
        if (a2 == null) {
            return 1; // Non-null values come after null
        }

        // Null check for end times
        if (a1.getEndTime() == null && a2.getEndTime() == null) {
            return 0; // Both end times are null, considered equal
        }
        if (a1.getEndTime() == null) {
            return -1; // Null end time comes first
        }
        if (a2.getEndTime() == null) {
            return 1; // Non-null end time comes after null
        }

        // Actual comparison of end times
        return a1.getEndTime().compareTo(a2.getEndTime());
    }
}
