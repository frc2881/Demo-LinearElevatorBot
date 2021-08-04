// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;

public class Intake extends SubsystemBase {
  private Spark m_intake;

  /** Creates a new Intake. */
  public Intake() {
    m_intake = new Spark(0);
    m_intake.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakeRun(double speed){
    speed /= 4.0;
    m_intake.set(speed);
  }
}
