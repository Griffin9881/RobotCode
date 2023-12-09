package frc.robot.subsystems;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Dashboard extends SubsystemBase{
    private CubeShooter cubeShooter = CubeShooter.getInstance();
    
    private final ShuffleboardTab driversTab = Shuffleboard.getTab("Drivers");
    private final ShuffleboardTab controlsTab = Shuffleboard.getTab("Controls");

    private final Field2d field = new Field2d();

    private static Dashboard instance;

    public static Dashboard getInstance() {
        if (instance == null) {
            instance = new Dashboard();
        }
        return instance;
    }

    private Dashboard(){
        super();

        driversTab.addNumber("Shooter Speed", cubeShooter::getVelocity)
            .withPosition(0,0);
        
        driversTab.addNumber("Shooter Power", cubeShooter::getShooterSpeed)
            .withPosition(0,1);

        driversTab.add(field)
            .withPosition(2,1)
            .withSize(4,3)
            .withWidget(BuiltInWidgets.kField);

        controlsTab.add(field)
            .withPosition(2,1)
            .withSize(4,3)
            .withWidget(BuiltInWidgets.kField);

    }

    @Override
    public void periodic() {

    }
}
