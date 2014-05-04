package be.brickbit.devices;

public class Heating extends Device {
    public Heating() {
        super();
    }

    @Override
    protected void appendCommands() {
        commands.put("on", this::turnOn);
        commands.put("off", this::turnOff);
    }

    public void turnOff() {
        System.out.println("Heating turned Off.");
    }

    public void turnOn() {
        System.out.println("Heating turned On.");
    }

}
