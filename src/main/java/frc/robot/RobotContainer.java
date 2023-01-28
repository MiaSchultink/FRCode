// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.sql.Driver;

import edu.wpi.first.cscore.CameraServerJNI.TelemetryKind;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Autonomous;
import frc.robot.commands.CloseGripper;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ManualElevatorRetract;
import frc.robot.commands.ManualExtendElevator;
import frc.robot.commands.OpenGripper;
import frc.robot.commands.PickUp;
import frc.robot.commands.PlaceBottomCone;
import frc.robot.commands.PlaceBottomCube;
import frc.robot.commands.PlaceTopCone;
import frc.robot.commands.PlaceTopCube;
import frc.robot.commands.RetractElevator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.TelescopicArm;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Gripper gripper = new Gripper();
  private final TelescopicArm telescopicArm = new TelescopicArm();

  private final Autonomous autonomous = new Autonomous(gripper, telescopicArm);
  private final OpenGripper openGripper = new OpenGripper(gripper);
  private final CloseGripper closeGripper = new CloseGripper(gripper);
  private final PickUp pickUp = new PickUp(gripper, telescopicArm);
  private final ManualElevatorRetract manualElevatorRetract = new ManualElevatorRetract(telescopicArm);
  private final ManualExtendElevator manualExtendElevator = new ManualExtendElevator(telescopicArm);
  private final RetractElevator retractElevator = new RetractElevator(telescopicArm);
  private final PlaceBottomCube placeBottomCube = new PlaceBottomCube(gripper, telescopicArm);
  private final PlaceBottomCone placeBottomCone = new PlaceBottomCone(gripper, telescopicArm);
  private final PlaceTopCube placeTopCube = new PlaceTopCube(gripper,  telescopicArm);
  private final PlaceTopCone placeTopCone = new PlaceTopCone(gripper, telescopicArm);

  private final XboxController driveController = new XboxController(Constants.DRIVER_CONTROLLER_PORT);
  private final XboxController copilotController = new XboxController(Constants.COPILOT_CONTROLLER_PORT);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    final JoystickButton driveX = new JoystickButton(driveController,XboxController.Button.kX.value);
    final JoystickButton driveA = new JoystickButton(driveController,XboxController.Button.kA.value);
    final JoystickButton driveY = new JoystickButton(driveController,XboxController.Button.kY.value);
    final JoystickButton driveB = new JoystickButton(driveController, XboxController.Button.kB.value);
    final JoystickButton driveLB = new JoystickButton(driveController, XboxController.Button.kLeftBumper.value);
    final JoystickButton driveRB = new JoystickButton(driveController, XboxController.Button.kRightBumper.value);
    final JoystickButton driveLeftStick = new JoystickButton(driveController, XboxController.Button.kLeftStick.value);
    final JoystickButton driveRighStick = new JoystickButton(driveController, XboxController.Button.kRightStick.value);

    final JoystickButton coX = new JoystickButton(copilotController,XboxController.Button.kX.value);
    final JoystickButton coA = new JoystickButton(copilotController,XboxController.Button.kA.value);
    final JoystickButton coY = new JoystickButton(copilotController,XboxController.Button.kY.value);
    final JoystickButton coB = new JoystickButton(copilotController, XboxController.Button.kB.value);
    final JoystickButton coLB = new JoystickButton(copilotController, XboxController.Button.kLeftBumper.value);
    final JoystickButton coRB = new JoystickButton(copilotController, XboxController.Button.kRightBumper.value);
    final JoystickButton coLeftStick = new JoystickButton(copilotController, XboxController.Button.kLeftStick.value);
    final JoystickButton coRighStick = new JoystickButton(copilotController, XboxController.Button.kRightStick.value);

    coA.whileHeld(placeBottomCube);
    coB.whileHeld(placeBottomCone);
    coX.whileHeld(placeTopCube);
    coY.whileHeld(placeTopCone);
    coRB.whileHeld(closeGripper);
    coLB.whileHeld(openGripper);
    coRB.and(coLB.whenPressed(pickUp));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autonomous;
  }
}
