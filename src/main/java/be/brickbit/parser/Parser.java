package be.brickbit.parser;

import be.brickbit.devices.Device;
import be.brickbit.devices.DeviceBuilder;
import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.QoS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Checks a given text on commands by voice
 */
public class Parser {
    private List<String> possibleDevices;
    BlockingConnection connection;

    public Parser(List<String> somePossibleDevices, BlockingConnection someBlockingConnection) {
        possibleDevices = somePossibleDevices;
        connection = someBlockingConnection;
    }

    public Parser(List<String> somePossibleDevices){
        this(somePossibleDevices, null);
    }

    public Parser() {
        this(new ArrayList<>(), null);
    }

    public void parseCommand(String text){
        possibleDevices.stream().filter(text::contains).forEach(deviceName -> findDeviceAndExecute(text, deviceName));
    }

    private void findDeviceAndExecute(String text, String deviceName) {
        Device device = DeviceBuilder.getDevice(deviceName);
        if (device != null) {
            executeDeviceCommand(text, device);
        } else {
            System.out.println("Device Not Found.");
        }
    }

    private void executeDeviceCommand(String text, Device someDevice) {
        someDevice.getCommands().stream().filter(command -> text.contains(" " + command + " ")).forEach(command -> {
            try {
                sendMessage(someDevice.getName(), command);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void sendMessage(String deviceName, String command) throws Exception {
        String commandString = deviceName + ":" + command;
        connection.publish("broker", commandString.getBytes(), QoS.AT_LEAST_ONCE, false);
    }
}
