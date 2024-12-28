package org.bitwise;

import org.bitwise.model.Activity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class ActivitySelectionTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySelectionTest.class);

    private final ActivitySelection activitySelection = new ActivitySelection();

    @Test
    void testCase1() {
        List<Activity> activities = TestCaseFileUtils.loadActivitiesFromFile("test-case-1.json");

        List<Activity> selectedActivities = activitySelection.perform(activities);

        LOGGER.debug(selectedActivities.toString());

        Assertions.assertEquals(3, selectedActivities.size());
    }
}
