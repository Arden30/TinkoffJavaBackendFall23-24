package edu.project3.utils;

import edu.project3.analyzer.NginxLogAnalyzer;
import edu.project3.formatters.Format;
import edu.project3.formatters.FormatADOC;
import edu.project3.formatters.FormatMD;
import edu.project3.parsers.LogParser;
import edu.project3.parsers.ParametersParser;
import java.util.List;
import java.util.Map;

public class ProgramRunner {
    private final String[] args;

    public ProgramRunner(String[] args) {
        this.args = args;
    }

    public void run() {
        ParametersParser parametersParser = new ParametersParser(args);
        Map<Option, String> parameters = parametersParser.parse();

        LogParser logParser = new LogParser(parameters.get(Option.PATH));
        List<LogRecord> list = logParser.parseAllLogs();

        NginxLogAnalyzer logAnalyzer = new NginxLogAnalyzer(list, parameters);

        Format formatMD = new FormatMD();
        Format formatADOC = new FormatADOC();

        if (parameters.containsKey(Option.FORMAT)) {
            if ("adoc".equals(parameters.get(Option.FORMAT))) {
                formatADOC.print(logAnalyzer);
            } else {
                formatMD.print(logAnalyzer);
            }
        } else {
            formatMD.print(logAnalyzer);
        }
    }
}
