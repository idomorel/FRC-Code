/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  WPI_VictorSPX topMotor;
  WPI_VictorSPX bottomMotor;

  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    topMotor = new WPI_VictorSPX(Constants.SHOOTER_TOP_VICTOR);
    bottomMotor = new WPI_VictorSPX(Constants.SHOOTER_BOTTOM_VICTOR);

    topMotor.setInverted(true);
  }

  // YEET THE BALLS!
  public void shoot() {    
    topMotor.set(Constants.BOTTOM_SHOOTER_SPEED);
    bottomMotor.set(Constants.BOTTOM_SHOOTER_SPEED);
  }

  public void stop() {
    topMotor.set(0);
    bottomMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
