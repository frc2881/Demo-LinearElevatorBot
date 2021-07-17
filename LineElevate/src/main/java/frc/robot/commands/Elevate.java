package frc.robot.commands;

import java.util.function.DoubleSupplier;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Elevate extends CommandBase {
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    double speed;

    private Elevator elevator;
    
    public Elevate(Elevator elevator, double speed) {
        this.speed = speed;

        this.elevator = elevator;

        addRequirements(this.elevator);
    }

    @Override
    public void execute() {

        elevator.setArmSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        elevator.setArmSpeed(0.0);
    }

      @Override
    public boolean isFinished() {
        return false;
    }
}
