package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.constants.BallShooterConstants;
import frc.robot.subsystems.BallShooter;

public class FeedInCommand extends CommandBase{
    private Timer timer = new Timer();
    private BallShooter cubeShooter = new BallShooter();

    public FeedInCommand() {
        addRequirements(cubeShooter);
        timer.start();
    }

    @Override
    public void execute() {
        cubeShooter.feed(BallShooterConstants.kFeedSpeed);
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(5);
    }

    @Override
    public void end(boolean interrupted) {
        cubeShooter.stopShooter();
    }    
}
