package be.brickbit.devices;

public class Camera extends Device {
    protected Camera() {
        super("camera");
    }

    @Override
    protected void appendCommands() {
        commands.add("selfie");
        commands.add("picture");
    }
}
