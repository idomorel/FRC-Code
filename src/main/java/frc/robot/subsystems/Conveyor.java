/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Conveyor extends SubsystemBase {
  Spark top;
  Spark bottom;

  /**
   * Creates a new Conveyor.
   */
  public Conveyor() {
    top = new Spark(Constants.CONVEYOR_TOP);
    bottom = new Spark(Constants.CONVEYOR_BOTTOM);
  }

  public void move(double speed) {
    top.set(speed * 0.7);
    bottom.set(speed);
  }

  public void stop() {
    top.stopMotor();
    bottom.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
