package be.brickbit.devices;

import org.fusesource.mqtt.client.BlockingConnection;

public class DeviceBuilder {
    public static Device getDevice(String name){
        switch (name){
            case "air conditioning":
                return new Airconditioning();
            case "camera":
            case "selfie":
                return new Camera();
            case "heating":
                return new Heating();
            default:
                return null;
        }
    }
}
