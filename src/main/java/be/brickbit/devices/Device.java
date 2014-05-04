package be.brickbit.devices;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Device {
    protected Map<String, Runnable> commands;

    protected Device() {
        commands = new HashMap<>();
        appendCommands();
    }

    protected abstract void appendCommands();

    public void execute(String command) {
        Runnable method = commands.get(command);
        if(method != null){
            method.run();
        }else{
            System.out.println("Command not recognized.");
        }
    }

    public Set<String> getCommands() {
        return commands.keySet();
    }
}
