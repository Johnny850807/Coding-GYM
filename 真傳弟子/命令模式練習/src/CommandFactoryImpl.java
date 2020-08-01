import Command.*;
import Furniture.Fan;
import Furniture.Light;
import Furniture.Television;

public class CommandFactoryImpl implements CommandFactory {
    private Fan fan;
    private Light light;
    private Television tv;
    private RemoteControl remoteControl;
    private final int LIGHT_ON = 1;
    private final int LIGHT_OFF = 2;
    private final int FAN_SET_LARGE = 3;
    private final int FAN_SET_SMALL = 4;
    private final int TV_CHANGE_CHANNEL = 5;
    private final int UNDO = 6;

    public CommandFactoryImpl(Fan fan, Light light, Television tv,RemoteControl remoteControl) {
        this.fan = fan;
        this.light = light;
        this.tv = tv;
        this.remoteControl = remoteControl;
    }

    @Override
    public Command createControl(int number) throws ControlCantUndoException {
        Command command = null;
        switch (number) {
            case LIGHT_ON:
                command = new OpenLightCommand(light);
                break;
            case LIGHT_OFF:
                command = new CloseLightCommand(light);
                break;
            case FAN_SET_LARGE:
                command = new SetFanWindSpeedToLargeCommand(fan);
                break;
            case FAN_SET_SMALL:
                command = new SetFanWindSpeedToSmallCommand(fan);
                break;
            case TV_CHANGE_CHANNEL:
                command = new TvChangeChannelCommand(tv);
                break;
            case UNDO:
                command = new UndoCommand(remoteControl.getLastUsedCommand());
                break;
        }
        return command;
    }
}
