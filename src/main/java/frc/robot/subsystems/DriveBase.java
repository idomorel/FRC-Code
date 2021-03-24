/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveBase extends SubsystemBase {
  /**
   * Creates a new driveBase.
   */
  // driveBase.setDefaultCommand(new arcadeDrive());

  private WPI_TalonFX leftMotor1;
  private WPI_TalonFX leftMotor2;
  private WPI_TalonFX rightMotor1;
  private WPI_TalonFX rightMotor2;
  private SpeedControllerGroup leftMotors;
  private SpeedControllerGroup rightMotors;

  private DifferentialDrive differentialDrive;

  public DriveBase() {
    leftMotor1 = new WPI_TalonFX(Constants.DRIVETRAIN_LEFT_FRONT_TALON);
    leftMotor2 = new WPI_TalonFX(Constants.DRIVETRAIN_LEFT_BACK_TALON);
    rightMotor1 = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHT_FRONT_TALON);
    rightMotor2 = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHT_BACK_TALON);

    leftMotor2.set(ControlMode.Follower, Constants.DRIVETRAIN_LEFT_FRONT_TALON);
    rightMotor2.set(ControlMode.Follower, Constants.DRIVETRAIN_RIGHT_FRONT_TALON);

    // rightMotor1.setInverted(true);
    // rightMotor2.setInverted(true);

    // leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
    // rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);

    // differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

    differentialDrive = new DifferentialDrive(leftMotor1, rightMotor1);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(Math.copySign(moveSpeed * moveSpeed, moveSpeed), rotateSpeed * 0.6, false);
  }

  public void tankDrive(double rSpeed, double lSpeed) {
    differentialDrive.tankDrive(lSpeed, rSpeed, true);

    // lSpeed = Math.copySign(lSpeed * lSpeed, lSpeed);
    // rSpeed = Math.copySign(rSpeed * rSpeed, rSpeed);

    // lSpeed *= 21777.0666;
    // rSpeed *= 21777.0666;

    // System.out.println(lSpeed);
    // System.out.println(rSpeed);

    // leftMotor1.set(ControlMode.PercentOutput, lSpeed);
    // rightMotor1.set(ControlMode.PercentOutput, -rSpeed);

    // System.out.println(leftMotor1.getMotorOutputPercent());
    // System.out.println(rightMotor1.getMotorOutputPercent());
  }

  public void limelightMove(double speed, double turn) {
    differentialDrive.arcadeDrive(speed, turn);
  }
  
  public void stop() {
    leftMotor1.stopMotor();
    rightMotor1.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
