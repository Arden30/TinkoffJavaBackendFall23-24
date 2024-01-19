package edu.hw6.task3;

import java.io.InputStream;
import java.nio.file.Files;
import org.jetbrains.annotations.NotNull;

public interface MagicNumberFilter extends AbstractFilter {
    @NotNull static AbstractFilter magicNumber(byte... magic) {
        return path -> {
            try (InputStream inputStream = Files.newInputStream(path)) {
                byte[] buffer = new byte[magic.length];
                int bytesRead = inputStream.read(buffer);

                if (bytesRead != magic.length) {
                    return false;
                }

                for (int i = 0; i < magic.length; i++) {
                    if (magic[i] != buffer[i]) {
                        return false;
                    }
                }

                return true;
            }
        };
    }
}
