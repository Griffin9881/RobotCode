package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.subsystems.BallShooter;
import frc.robot.constants.BallShooterConstants;

public class MidShootCommand extends CommandBase {
    private Timer timer = new Timer();
    private BallShooter cubeShooter = new BallShooter();

    public MidShootCommand() {
        addRequirements(cubeShooter);
        timer.start();
    }

    @Override
    public void execute() {
        cubeShooter.shoot(BallShooterConstants.kMidShoot);
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
