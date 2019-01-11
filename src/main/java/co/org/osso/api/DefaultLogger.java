package co.org.osso.api;

import org.springframework.stereotype.Component;

@Component
public class DefaultLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
