package edu.hw6.task3;

import java.nio.file.Files;

public interface MagicNumberFilter extends AbstractFilter {
    static AbstractFilter magicNumber(byte... magic) {
        return path -> {
            byte[] bytes = Files.readAllBytes(path);

            if (magic.length > bytes.length) {
                return false;
            }

            for (int i = 0; i < magic.length; i++) {
                if (magic[i] != bytes[i]) {
                    return false;
                }
            }

            return true;
        };
    }
}
