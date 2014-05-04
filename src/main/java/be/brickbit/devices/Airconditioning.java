package be.brickbit.devices;

public class Airconditioning extends Device{

    protected Airconditioning() {
        super();
    }

    @Override
    protected void appendCommands() {
        commands.put("on", this::turnOn);
        commands.put("off", this::turnOff);
    }

    public void turnOff() {
        System.out.println("Airco turned Off.");
    }

    public void turnOn() {
        System.out.println("Airco turned On.");
    }
}
