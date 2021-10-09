package ood.ocp;

import grabber.PsqlStore;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Read {

    public void cfg() throws IOException {
        Properties cfg = new Properties();
        try (InputStream in = PsqlStore.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
    }
}
