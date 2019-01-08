package co.org.osso.api;

public class DefaultLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
