package org.bitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityTime implements Comparable<ActivityTime> {
    private int hour;
    private int minute;

    @Override
    public int compareTo(ActivityTime other) {
        // Null check
        if (other == null) {
            throw new NullPointerException("The compared object is null.");
        }

        // Type check (optional, but good for safety if used in mixed contexts)
        if (!(other instanceof ActivityTime)) {
            throw new ClassCastException("The compared object is not an instance of ActivityTime.");
        }

        if (hour == other.hour && minute == other.minute) {
            return 0;
        } if (hour > other.hour || (hour == other.hour && minute > other.minute)) {
            return 1;
        } else {
            return -1;
        }
    }
}
