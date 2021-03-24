/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbingWinch extends SubsystemBase {
  WPI_TalonSRX cim1;
  WPI_VictorSPX cim2;
  WPI_VictorSPX cim3;
  NeutralMode currentMode;

  /**
   * Creates a new ClimbingWinch.
   */
  public ClimbingWinch() {
    currentMode = NeutralMode.Coast;

    cim1 = new WPI_TalonSRX(Constants.MEGA_CIM_1_TALON);
    cim2 = new WPI_VictorSPX(Constants.MEGA_CIM_2_VICTOR);
    cim3 = new WPI_VictorSPX(Constants.MEGA_CIM_3_VICTOR);

    cim1.setNeutralMode(currentMode);
    cim2.setNeutralMode(currentMode);
    cim3.setNeutralMode(currentMode);
  }

  public void move(double speed) {
    cim1.set(speed);
    cim2.set(speed);
    cim3.set(speed);
  }

  public void toggleBreakMode() {
    currentMode = currentMode == NeutralMode.Coast ? NeutralMode.Brake : NeutralMode.Coast;

    cim1.setNeutralMode(currentMode);
    cim2.setNeutralMode(currentMode);
    cim3.setNeutralMode(currentMode);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
