/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbArm extends SubsystemBase {
  private WPI_TalonSRX motor;

  /**
   * Creates a new ClimbArm.
   */
  public ClimbArm() {
    motor = new WPI_TalonSRX(13);
  }

  public void move(double speed) {
    System.out.println(speed);
    motor.set(-speed);
  }

  public void stop() {
    motor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
