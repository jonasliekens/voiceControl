package be.brickbit.comm;

import java.io.Serializable;

public class Command implements Serializable{
    String device;
    String command;

    public String getDevice() {
        return device;
    }

    public void setDevice(String someDevice) {
        device = someDevice;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String someCommand) {
        command = someCommand;
    }
}
