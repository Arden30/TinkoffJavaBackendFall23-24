package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesAnalyzer extends RecursiveTask<List<Path>> {
    private final Path root;
    private final long minFileSize;
    private final String extension;

    public FilesAnalyzer(Path root, long minFileSize, String extension) {
        this.root = root;
        this.minFileSize = minFileSize;
        this.extension = extension;
    }

    @Override
    protected List<Path> compute() {

        List<Path> dirs;
        try (Stream<Path> paths = Files.list(root)) {
            dirs = paths.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Path> files = new ArrayList<>();
        List<Path> subdirectories = new ArrayList<>();
        for (Path content : dirs) {
            if (Files.isRegularFile(content)) {
                files.add(content);
            } else if (Files.isDirectory(content)) {
                subdirectories.add(content);
            }
        }

        List<Path> requiredFiles = new ArrayList<>();
        for (Path file : files) {
            long fileSize;
            try {
                fileSize = Files.size(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (fileSize >= minFileSize
                && file.getFileName().toString().endsWith(extension)
            ) {
                requiredFiles.add(file);
            }
        }

        List<FilesAnalyzer> tasks = new ArrayList<>();
        for (Path subdirectory : subdirectories) {
            var task = new FilesAnalyzer(subdirectory, minFileSize, extension);
            task.fork();
            tasks.add(task);
        }

        for (var task : tasks) {
            requiredFiles.addAll(task.join());
        }

        return requiredFiles;
    }

    public List<Path> analyzeFiles() {
        return compute();
    }
}
