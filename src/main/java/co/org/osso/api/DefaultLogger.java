package co.org.osso.api;

import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;

@Component
public class DefaultLogger implements Logger {

    @Override
    public void log(String message) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        InetAddress ip = null;
        long threadId = Thread.currentThread().getId();

        try {
            ip = InetAddress.getLocalHost();
            message = timestamp + "  JAAR-INFO [" + threadId + "] " + ip + ": " + message;
            System.out.println(message);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
