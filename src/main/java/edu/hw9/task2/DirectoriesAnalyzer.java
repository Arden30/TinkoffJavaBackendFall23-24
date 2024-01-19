package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoriesAnalyzer extends RecursiveTask<AbstractMap.SimpleEntry<List<Path>, Integer>> {
    private final Path root;
    private final int numOfFiles;

    public DirectoriesAnalyzer(Path root, int numOfFiles) {
        this.root = root;
        this.numOfFiles = numOfFiles;
    }

    @Override
    protected AbstractMap.SimpleEntry<List<Path>, Integer> compute() {
        List<Path> dirs;
        try (Stream<Path> paths = Files.list(root)) {
            dirs = paths.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Path> subDirs = new ArrayList<>();
        int files = 0;
        for (Path path: dirs) {
            if (Files.isRegularFile(path)) {
                files++;
            } else if (Files.isDirectory(path)) {
                subDirs.add(path);
            }
        }

        List<DirectoriesAnalyzer> tasks = new ArrayList<>();
        for (Path subdirectory: subDirs) {
            DirectoriesAnalyzer task = new DirectoriesAnalyzer(subdirectory, numOfFiles);
            task.fork();
            tasks.add(task);
        }

        List<Path> res = new ArrayList<>();
        for (var task: tasks) {
            var path = task.join();
            res.addAll(path.getKey());
            files += path.getValue();
        }

        if (files > numOfFiles) {
            res.add(root);
        }

        return new AbstractMap.SimpleEntry<>(res, files);
    }

    public AbstractMap.SimpleEntry<List<Path>, Integer> analyzeDirs() {
        return compute();
    }
}
