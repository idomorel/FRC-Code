/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AimCommand;
import frc.robot.commands.AimYCommand;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.ConveyorButtonCommand;
import frc.robot.commands.ConveyorCommand;
import frc.robot.commands.FalconCooling;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.ToggleClimbBreak;
import frc.robot.commands.WinchCommand;
import frc.robot.subsystems.ClimbArm;
import frc.robot.subsystems.ClimbingWinch;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.AutonomousCommand;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Joysticks
  Joystick rightDriverStick = new Joystick(Constants.LEFT_DRIVER_STICK);
  Joystick leftDriverStick = new Joystick(Constants.RIGHT_DRIVER_STICK);
  Joystick secondDriverStick = new Joystick(Constants.SECOND_DRIVER_STICK);

  // Joystick buttons
  JoystickButton shooterButton = new JoystickButton(secondDriverStick, 1);
  JoystickButton raiseArmButton = new JoystickButton(secondDriverStick, 12);
  JoystickButton lowerArmButton = new JoystickButton(secondDriverStick, 11);
  JoystickButton winchButton = new JoystickButton(secondDriverStick, 3);
  JoystickButton conveyorButton = new JoystickButton(leftDriverStick, 2);
  JoystickButton xAimButton = new JoystickButton(leftDriverStick, 5);
  JoystickButton yAimButton = new JoystickButton(rightDriverStick, 2);
  JoystickButton toggleFalconCooling = new JoystickButton(secondDriverStick, 7);
  JoystickButton toggleWinchBrake = new JoystickButton(secondDriverStick, 5);

  // The robot's subsystems and commands are defined here...
  public final DriveBase driveBase = new DriveBase();
  private final Shooter shooter = new Shooter();
  private final Conveyor conveyor = new Conveyor();
  private final ClimbingWinch winch = new ClimbingWinch();
  private final ClimbArm climbArm = new ClimbArm();
  private final PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();
  private final AimCommand aimCommand = new AimCommand(driveBase);
  private final AimYCommand aimYCommand = new AimYCommand(driveBase);

  private final ArcadeDrive arcadeDrive = new ArcadeDrive(driveBase, rightDriverStick, leftDriverStick);
  private final ConveyorCommand conveyorCommand = new ConveyorCommand(conveyor, secondDriverStick);
  private final ArmCommand armCommand = new ArmCommand(climbArm, secondDriverStick);
  private final AutonomousCommand autonomousCommand = new AutonomousCommand(driveBase, shooter, conveyor, aimCommand, aimYCommand);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureButtonBindings();
    CommandScheduler.getInstance().setDefaultCommand(driveBase, arcadeDrive);
    CommandScheduler.getInstance().setDefaultCommand(conveyor, conveyorCommand);
    CommandScheduler.getInstance().setDefaultCommand(climbArm, armCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    conveyorButton.whenHeld(new ConveyorButtonCommand(conveyor));
    shooterButton.whileHeld(new ShooterCommand(shooter));
    winchButton.whileHeld(new WinchCommand(winch));
    toggleFalconCooling.whenPressed(new FalconCooling(pneumaticsSubsystem));
    toggleWinchBrake.whenPressed(new ToggleClimbBreak(winch));
    xAimButton.whileHeld(new AimCommand(driveBase));
    yAimButton.whileHeld(new AimYCommand(driveBase));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autonomousCommand;
  }
}
