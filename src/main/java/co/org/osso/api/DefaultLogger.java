package co.org.osso.api;

import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;

@Component
public class DefaultLogger implements Logger {
    private final String ip;

    DefaultLogger () {
        InetAddress inetAddress;

        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            inetAddress = null;
        }

        if (inetAddress != null){
            ip = inetAddress.toString();
        } else {
            ip = "";
        }
    }

    @Override
    public void log(String message) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long threadId = Thread.currentThread().getId();

        message = timestamp + "  INFO [" + threadId + "] " + ip + ": " + message;
        System.out.println(message);
    }
}
