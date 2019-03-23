package Server;

import java.io.IOException;

@FunctionalInterface
public interface Worker {
    void process() throws IOException;
}
