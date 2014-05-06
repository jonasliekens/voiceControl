package be.brickbit.devices;

public class Airconditioning extends Device{

    protected Airconditioning() {
        super("air conditioning");
    }

    @Override
    protected void appendCommands() {
        commands.add("on");
        commands.add("off");
    }
}
