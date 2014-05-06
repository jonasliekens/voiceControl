package be.brickbit.devices;

import java.util.*;

public abstract class Device {
    protected List<String> commands;
    private String name;

    protected Device(String someName) {
        commands = new ArrayList<>();
        name = someName;
        appendCommands();
    }

    protected abstract void appendCommands();

    public List<String> getCommands() {
        return commands;
    }

    public String getName() {
        return name;
    }
}
