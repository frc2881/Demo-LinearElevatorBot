package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase{

private CANSparkMax leftArm;
private CANSparkMax rightArm;

public Elevator(){

    leftArm = new CANSparkMax(5, MotorType.kBrushless);
        leftArm.setInverted(false);
        leftArm.setIdleMode(IdleMode.kBrake);
    
    rightArm = new CANSparkMax(6, MotorType.kBrushless);
        rightArm.setInverted(false);
        rightArm.setIdleMode(IdleMode.kBrake);

}

public void setArmSpeed(double speed){
    leftArm.set(speed*3);
    rightArm.set(speed);
}

}
