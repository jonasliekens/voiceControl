package be.brickbit.parser;

import be.brickbit.devices.Device;
import be.brickbit.devices.DeviceBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * Checks a given text on commands by voice
 */
public class Parser {
    private List<String> possibleDevices;

    public Parser(List<String> somePossibleDevices) {
        possibleDevices = somePossibleDevices;
    }

    public Parser() {
        this(Arrays.asList("air conditioning", "heating", "selfie", "camera"));
    }

    public void parseCommand(String text){
        possibleDevices.stream().filter(text::contains).forEach(deviceName -> {
            Device device = DeviceBuilder.getDevice(deviceName);
            if (device != null) {
                device.getCommands().stream().filter(command -> text.contains(
                        " " + command + " ")).forEach(device::execute);
            } else {
                System.out.println("Device Not Found.");
            }
        });
    }
}
