package edu.project3.utils;

import java.time.LocalDateTime;

public record LogRecord(String addr,
                        String user,
                        LocalDateTime dateTime,
                        String request,
                        int status,
                        long size,
                        String httpReferrer,
                        String userAgent) {
}
