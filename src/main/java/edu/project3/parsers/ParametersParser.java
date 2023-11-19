package edu.project3.parsers;

import edu.project3.utils.Option;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParametersParser {
    private final String[] args;
    private final static Logger LOGGER = LogManager.getLogger();

    public ParametersParser(String[] args) {
        this.args = args;
    }

    public Map<Option, String> parse() {
        Map<Option, String> parameters = new HashMap<>();
        String option = "";
        for (String str : args) {
            if (str.startsWith("--")) {
                option = str.substring(2);
            } else {
                try {
                    parameters.put(Option.valueOf(option.toUpperCase()), str);
                } catch (IllegalArgumentException e) {
                    LOGGER.info("You made a mistake in some --option");
                    System.exit(1);
                }
            }
        }

        return parameters;
    }
}
