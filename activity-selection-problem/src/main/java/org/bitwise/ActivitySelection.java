package org.bitwise;

import org.bitwise.comparator.ActivityEndTimeComparator;
import org.bitwise.model.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {
    public List<Activity> perform(List<Activity> activities) {
        if (activities == null || activities.isEmpty()) {
            return Collections.emptyList();
        }

        activities.sort(new ActivityEndTimeComparator());

        List<Activity> selectedActivites = new ArrayList<>();

        selectedActivites.add(activities.get(0));

        for (int i = 0; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);
            Activity lastSelectedActivity = selectedActivites.get(selectedActivites.size() - 1);

            if (currentActivity.getStartTime().compareTo(lastSelectedActivity.getEndTime()) > 0) {
                selectedActivites.add(currentActivity);
            }
        }

        return selectedActivites;
    }
}
