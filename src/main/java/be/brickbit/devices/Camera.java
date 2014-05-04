package be.brickbit.devices;

public class Camera extends Device {
    protected Camera() {
        super();
    }

    @Override
    protected void appendCommands() {
        commands.put("selfie", this::takePicture);
        commands.put("picture", this::takePicture);
    }

    public void takePicture() {
        System.out.println("You just took a foto.");
    }
}
