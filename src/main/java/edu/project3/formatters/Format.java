package edu.project3.formatters;

import edu.project3.analyzer.NginxLogAnalyzer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Format {
    Logger LOGGER = LogManager.getLogger();
    void print(NginxLogAnalyzer logAnalyzer);
}
