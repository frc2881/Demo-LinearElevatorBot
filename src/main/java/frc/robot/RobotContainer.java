package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;


import static edu.wpi.first.wpilibj.XboxController.Button;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

    XboxController driverController = new XboxController(0);
    XboxController manipulatorController = new XboxController(1);

    private final Drive drive = new Drive();
    private final Elevator elevator = new Elevator();
    private final Intake intake = new Intake();

    private final DriveWithJoysticks driveWithJoysticks = new DriveWithJoysticks(
        drive, 
        () -> getDriverLeftY(),
        () -> -getDriverRightX());

    private final FeedIntake feedIntake = new FeedIntake(
        intake,
        () -> getDriverLeftTrigger(),
        () -> getDriverRightTrigger());

    public RobotContainer() {
    
        configureButtonBindings();
  

    drive.setDefaultCommand(driveWithJoysticks);
    intake.setDefaultCommand(feedIntake);
        /*intake.setDefaultCommand();

        m_Subsystem.setDefaultCommand(
            new RunCommand(
                () -> m_Subsystem.arcadeDrive(
                          m_driverController.getRawAxis(1),
                          m_driverController.getRawAxis(2)),
                          m_Subsystem));*/
    }

    private void configureButtonBindings() {
        new JoystickButton(driverController, Button.kBumperRight.value)
            .whenPressed(() -> drive.setMaxOutput(0.5))
            .whenReleased(() -> drive.setMaxOutput(1));
    
        new JoystickButton(driverController, 1)
            .whileHeld(new Elevate(elevator, 0.2));

        new JoystickButton(driverController, 2)
            .whileHeld(new Elevate(elevator, -0.2));
    }

    private double getDriverLeftX() {
        return(driverController.getRawAxis(0));
    }

    private double getDriverLeftY() {
        return(driverController.getRawAxis(1));
    }

    private double getDriverRightX() {
        return(driverController.getRawAxis(2));
    }

    private double getDriverRightY() {
        return(driverController.getRawAxis(5));
    }

    private double getDriverLeftTrigger() {
        return((driverController.getRawAxis(3) + 1) / 2);
    }

    private double getDriverRightTrigger() {
        return((driverController.getRawAxis(4) + 1) / 2);
    }

    private double getManipulatorLeftX() {
        return(manipulatorController.getRawAxis(0));
    }

    private double getManipulatorLeftY() {
        return(manipulatorController.getRawAxis(1));
    }

    private double getManipulatorRightX() {
        return(manipulatorController.getRawAxis(2));
    }

    private double getManipulatorRightY() {
        return(manipulatorController.getRawAxis(5));
    }

    private double getManipulatorLeftTrigger() {
        return((manipulatorController.getRawAxis(3) + 1) / 2);
    }

    private double getManipulatorRightTrigger() {
        return((manipulatorController.getRawAxis(4) + 1) / 2);
    }
}
