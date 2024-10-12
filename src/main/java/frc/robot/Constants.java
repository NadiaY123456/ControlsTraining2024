// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  /** Constants for the intake subsystems. */
  public static class IntakeConstants {
    public static final int PIVOT_MOTOR_ID = 16;
    public static final int FRONT_MOTOR_ID = 17;
    public static final double OUT_ROLL_SPEED = -0.2;
    public static final double IN_ROLL_SPEED = 0.2;
    
    public static final double PIVOT_P = 1; //old 2.5
    public static final double PIVOT_I = 0;
    public static final double PIVOT_D = 0;
    public static final double PIVOT_CONVERSION_FACTOR = 0.2142;

}
}
