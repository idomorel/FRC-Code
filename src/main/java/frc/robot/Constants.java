/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final int DRIVETRAIN_LEFT_FRONT_TALON = 3;
  public static final int DRIVETRAIN_LEFT_BACK_TALON = 4;
  public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 1;
  public static final int DRIVETRAIN_RIGHT_BACK_TALON = 2;

  public static final int SHOOTER_TOP_VICTOR = 7;
  public static final int SHOOTER_BOTTOM_VICTOR = 8;

  public static final int CONVEYOR_BOTTOM = 0;
  public static final int CONVEYOR_TOP = 1;

  public static final int LEFT_DRIVER_STICK = 0;
  public static final int RIGHT_DRIVER_STICK = 1;
  public static final int SECOND_DRIVER_STICK = 2;

  public static final int CLIMB_ARM_SPARK = 1;
  public static final int CLIMB_SLIDER_TALON = 13;
  public static final int MEGA_CIM_1_TALON = 11;
  public static final int MEGA_CIM_2_VICTOR = 10;
  public static final int MEGA_CIM_3_VICTOR = 9;

  public static final double TOP_SHOOTER_SPEED = 1;
  public static final double BOTTOM_SHOOTER_SPEED = 1;

  public static final int PCM_ID = 12;
}
