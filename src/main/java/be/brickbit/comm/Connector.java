package be.brickbit.comm;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;

import java.net.URISyntaxException;

public class Connector {
    private static final String BROKER_ADDRESS = "http://test:50";
    private MQTT mqtt;

    public Connector() throws URISyntaxException {
        //this.mqtt = new MQTT();
        //mqtt.setHost(BROKER_ADDRESS);
    }

    public BlockingConnection getConnection(){
        return null; //mqtt.blockingConnection();
    }
}
