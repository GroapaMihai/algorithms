package org.bitwise;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.bytebuddy.jar.asm.TypeReference;
import org.bitwise.model.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestCaseFileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCaseFileUtils.class);

    public static List<Activity> loadActivitiesFromFile(String testCaseFile) {
        // Load the resource using the class loader
        ClassLoader classLoader = TestCaseFileUtils.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(testCaseFile)) {
            if (inputStream == null) {
                throw new FileNotFoundException("File not found in src/test/resources: " + testCaseFile);
            }

            // Read the JSON content
            String jsonContent = new String(inputStream.readAllBytes());

            // Parse JSON into TestCase object
            Gson gson = new Gson();
            return gson.fromJson(jsonContent, TypeToken.getParameterized(List.class, Activity.class).getType());
        } catch (IOException e) {
            LOGGER.error("Failed loading test case file {}: {}", testCaseFile, e.getMessage());

            throw new RuntimeException("Failed loading test case file " + testCaseFile);
        }
    }
}
