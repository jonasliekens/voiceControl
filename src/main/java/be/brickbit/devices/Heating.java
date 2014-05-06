package be.brickbit.devices;

public class Heating extends Device {
    public Heating() {
        super("heating");
    }

    @Override
    protected void appendCommands() {
        commands.add("on");
        commands.add("off");
    }

}
