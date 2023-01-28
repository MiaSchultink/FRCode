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
    public static final int GRIPPER_MOTOR_ID = 1;

    public static final double GRIPPER_CLOSED = 30;
    public static final double GRIPPER_OPEN = 100;

   public static final int TEL_ARM_PIVOT_ID = 13;
   public static final int TEL_ARM_ELEVATOR_ID = 14;

   public static final double PIVOT_PICK_UP_POS = 23.3;
   public static final double PIVOT_PLACE_TOP_CONE_POS = 107.6;
   public static final double PIVOT_PLACE_BOTTOM_CONE_POS = 80.56;
   public static final double PIVOT_PLACE_BOTTOM_CUBE_POS = 45.6;
   public static final double PIVOT_PLACE_TOP_CUBE_POS = 90.5;
   public static final double PIVOT_FULLY_RETRACTED_POS = 0;
   public static final double PIVOT_FULLY_EXTENDED_POS = 100;

   public static final double PIVOT_UP_SPEED = 4.57;
   public static final double PIVOT_DOWN_SPEED = -4.57;

   public static final double ELEVATOR_FULLY_RETRACTED_HEIGHT = 0;
   public static final double ELEVATOR_PICK_UP_HEIGHT = 30.5;
   public static final double ELEVATOR_BOTTOM_CONE_HEIGHT = 50.6;
   public static final double ELEVATOR_TOP_CONE_HEIGHT = 76.8;
   public static final double ELEVATOR_BOTTOM_CUBE_HEIGHT = 25.7;
   public static final double ELEVATOR_PLACE_TOP_CUBE_POS = 89.9;
   public static final double ELEVATOR_FULLY_EXTENDED_POS = 100;

   public static final double ELEVATOR_UP_SPEED = 5.656;
   public static final double ELEVATOR_DOWN_SPEED = -5.656;
   public static final double ELEVATOR_OUT_SPEED = 5.77;
   public static final double ELEVATOR_IN_SPEED = -5.77;

   public static final int DRIVER_CONTROLLER_PORT = 0;
   public static final int COPILOT_CONTROLLER_PORT = 1;
}
