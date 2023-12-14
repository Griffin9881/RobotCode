package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.BallShooterConstants;

public class BallShooter extends SubsystemBase {

    private CANSparkMax shooterMotor = new CANSparkMax(BallShooterConstants.kShooterMotorPort, MotorType.kBrushless);
    private CANSparkMax feederMotor = new CANSparkMax(BallShooterConstants.kFeederMotorPort, MotorType.kBrushless);
    RelativeEncoder shooterEncoder = shooterMotor.getEncoder();

    private static BallShooter instance;

    public static BallShooter getInstance() {
        if (instance == null) {
            instance = new BallShooter();
        }
        return instance;
    }

    public BallShooter() {
        shooterMotor.restoreFactoryDefaults();
        feederMotor.restoreFactoryDefaults();

        shooterMotor.setIdleMode(IdleMode.kCoast);
        feederMotor.setIdleMode(IdleMode.kBrake);

        feederMotor.burnFlash();
        shooterMotor.burnFlash();
    }

    public double getVelocity() {
        return shooterEncoder.getVelocity();
    }

    public double getShooterSpeed() {
        return shooterMotor.get();
    }

    public void shoot(double speed) {
        shooterMotor.set(speed);
    }

    public void feed(double speed) {
        feederMotor.set(speed);
    }

    public void stopShooter() {
        shooterMotor.stopMotor();
    }

    public void stopFeeder() {
        feederMotor.stopMotor();
    }
}
