package org.bitwise.testcase;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestCaseFileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCaseFileUtils.class);

    public static TestCase loadTestCaseFromFile(String testCaseFile) {
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
            return gson.fromJson(jsonContent, TestCase.class);
        } catch (IOException e) {
            LOGGER.error("Failed loading test case file {}: {}", testCaseFile, e.getMessage());

            throw new RuntimeException("Failed loading test case file " + testCaseFile);
        }
    }
}
