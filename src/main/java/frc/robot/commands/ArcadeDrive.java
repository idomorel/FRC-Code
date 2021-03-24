/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class ArcadeDrive extends CommandBase {
  private final DriveBase drive;
  private final Joystick leftJoytick;
  private final Joystick rightJoytick;
  private double forward;
  private double rotation;
  private double sensitivity;

  /**
   * Creates a new ArcadeDrive.
   */
  public ArcadeDrive(DriveBase subsystem, Joystick leftDriverStick, Joystick rightDriverStick) {
    // Use addRequirements() here to declare subsystem dependencies.
    drive = subsystem;
    leftJoytick = leftDriverStick;
    rightJoytick = rightDriverStick;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean arcadeDrive = true;

    sensitivity = (leftJoytick.getRawAxis(3) * -0.5) + 0.5;
    if (arcadeDrive) {
      forward = -leftJoytick.getY() * sensitivity;
      rotation = rightJoytick.getX() * sensitivity;
      drive.arcadeDrive(forward, rotation);
    } else {
      double rSpeed = (rightJoytick.getY() * -1) * sensitivity;
      double lSpeed = (leftJoytick.getY() * -1) * sensitivity;

      drive.tankDrive(lSpeed, rSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
