/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class AutonomousCommand extends CommandBase {
  private Timer timer;

  private DriveBase driveBase;
  private Shooter shooter;
  private AimCommand aimCommand;
  private Conveyor conveyor;
  private AimYCommand aimYCommand;

  /**
   * Creates a new AutonomousCommand.
   */
  public AutonomousCommand(DriveBase driveBase, Shooter shooter, Conveyor conveyor, AimCommand aimCommand, AimYCommand aimYCommand) {
    addRequirements(driveBase);
    addRequirements(shooter);
    addRequirements(conveyor);
    this.driveBase = driveBase;
    this.shooter = shooter;
    this.conveyor = conveyor;
    this.aimCommand = aimCommand;
    this.aimYCommand = aimYCommand;

    timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if (timer.get() < 0.50) {
    //   driveBase.arcadeDrive(-0.50, 0);
    //   System.out.println("driving");
    // }
    // if (timer.get() > 0.50 && timer.get() < 1.74){
    //   //CommandScheduler.getInstance().run();
    //   CommandScheduler.getInstance().schedule(aimYCommand);
    //   //driveBase.arcadeDrive(0.50, 0);
    //   System.out.println("started aim x command");
    // }
    // System.out.println("sonethinggkjksghirlkdjhk");
    // if (timer.get() > 1.75 && timer.get() < 8.00){
    //   //CommandScheduler.getInstance().run();
    //   System.out.println("driven");
    //   driveBase.arcadeDrive(0.50, 0);
      
      // CommandScheduler.getInstance().cancel(aimYCommand);
      // System.out.println("finished aim x command");
    // }
    // while (timer.get() > 3.00 && timer.get() < 3.50){
    //   driveBase.arcadeDrive(0.50, 0);
    // }
    if (timer.get() < 0.75) {
     driveBase.arcadeDrive(-0.75, 0);
     System.out.println("driving");
    } else if (timer.get() < 1.75) {
    CommandScheduler.getInstance().schedule(aimYCommand);
    System.out.println("started aim y command");
    // } else if (timer.get() < 3.00) {
    // CommandScheduler.getInstance().cancel(aimYCommand);
    // System.out.println("finished aim y command");
    } else if (timer.get() < 2.00) {
    CommandScheduler.getInstance().schedule(aimCommand);
    System.out.println("started aim x command");
    shooter.shoot();
    // } else if (timer.get() < 4.25) {
    // CommandScheduler.getInstance().cancel(aimCommand);
    // System.out.println("finished aim x command");
    // shooter.shoot();
    } else if (timer.get() < 4.00) {
      System.out.println("shooter.shoot");
      shooter.shoot();
      conveyor.move(1);
    }
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stop();
    conveyor.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() > 10.00;
  }
}
