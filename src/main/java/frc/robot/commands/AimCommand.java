/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveBase;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AimCommand extends PIDCommand {
  DriveBase driveBase;
  private Timer timer;
  /**
   * Creates a new AimCommand.
   */
  public AimCommand(DriveBase driveBase) {
    super(
        // new PIDController(0.7, 0.6, 0.1)
        // The controller that the command will use
        new PIDController(1.2*0.6, 1.2/3.0*1.2, 3*1.2*3.0/40),
        // This should return the6 measurement
        () -> {
          // Get the limelight Network Table, which contains the sensor readings for where
          // the target is
          NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
          // Return the target's X position from the Limelight, in degrees, from -27° to
          // 27°
          double error = (-table.getEntry("tx").getDouble(0.0) / 27);
          System.out.println(String.format("%.4g%n", error));
          return error;
        },
        // This should return the setpoint (can also be a constant)
        () -> 0.00,
        // This uses the output
        (double output) -> {
          System.out.println("working");
          driveBase.limelightMove(0, output * 0.6);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    timer = new Timer();
    addRequirements(driveBase);
    this.driveBase = driveBase;
  }

  @Override
  public void initialize() {
    timer.start();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timer.get() > 1.00) {System.out.print("timer:");System.out.println(timer.get());return true;}
    else return false;
    // return false;
  }
}
