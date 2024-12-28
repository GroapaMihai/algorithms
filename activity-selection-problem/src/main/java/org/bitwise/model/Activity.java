package org.bitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private String name;
    private ActivityTime startTime;
    private ActivityTime endTime;

    @Override
    public String toString() {
        return name;
    }
}
