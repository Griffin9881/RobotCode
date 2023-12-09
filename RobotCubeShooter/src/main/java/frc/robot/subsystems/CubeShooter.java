package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CubeShooterConstants;

public class CubeShooter extends SubsystemBase{
        
    private CANSparkMax shooterMotor = new CANSparkMax(CubeShooterConstants.kShooterMotorPort, MotorType.kBrushless);
    private CANSparkMax feederMotor = new CANSparkMax(CubeShooterConstants.kFeederMotorPort, MotorType.kBrushless);
    RelativeEncoder shooterEncoder = shooterMotor.getEncoder();
    RelativeEncoder feederEncoder = feederMotor.getEncoder();

    private static CubeShooter instance;

    public static CubeShooter getInstance() {
        if(instance == null) {
            instance = new CubeShooter();
        }
        return instance;
    }

    public CubeShooter() {
        shooterMotor.restoreFactoryDefaults();
        shooterMotor.burnFlash();
        feederMotor.restoreFactoryDefaults();
        feederMotor.burnFlash();
    }

    public double getVelocity(){
        return shooterEncoder.getVelocity();
    }

    public double getShooterSpeed(){
        return shooterMotor.get();
    }

}
