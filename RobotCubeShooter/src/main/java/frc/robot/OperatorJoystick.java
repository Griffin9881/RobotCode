package frc.robot;

import frc.robot.libraries.XboxController1038;
import frc.robot.commands.FastShootCommand;
import frc.robot.commands.MidShootCommand;
import frc.robot.commands.SlowShootCommand;
import frc.robot.commands.FeedInCommand;
import frc.robot.commands.FeedOutCommand;
import frc.robot.constants.IOConstants;

public class OperatorJoystick extends XboxController1038 {
    private static OperatorJoystick instance;

    public static OperatorJoystick getInstance() {
        if (instance == null) {
            instance = new OperatorJoystick();
        }
        return instance;
    }

    private OperatorJoystick() {
        super(IOConstants.kOperatorControllerPort);

        yButton
                .onTrue(new FastShootCommand());

        xButton
                .onTrue(new MidShootCommand());

        aButton
                .onTrue(new SlowShootCommand());

        rightTrigger
                .whileTrue(new FeedInCommand());

        rightBumper
                .whileTrue(new FeedOutCommand());
    }
}
