// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.IntakePivotSubsystem;
import frc.robot.subsystems.IntakeRollerSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * This class is where the bulk of the robot should bPe declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
    private final IntakePivotSubsystem IntakePivotSubsystem;
    private final IntakeRollerSubsystem IntakeRollerSubsystem;
    private final XboxController mechController = new XboxController(2);
    private final JoystickButton aButton = new JoystickButton(mechController, XboxController.Button.kA.value);
    private final JoystickButton bButton = new JoystickButton(mechController, XboxController.Button.kB.value);
    private final JoystickButton leftBumper = new JoystickButton(mechController,
            XboxController.Button.kLeftBumper.value);
    private final JoystickButton rightBumper = new JoystickButton(mechController,
            XboxController.Button.kRightBumper.value);
    private final JoystickButton xButton = new JoystickButton(mechController, XboxController.Button.kX.value);
    private final JoystickButton yButton = new JoystickButton(mechController, XboxController.Button.kY.value);
    private final JoystickButton leftStickButton = new JoystickButton(mechController,
            XboxController.Button.kLeftStick.value);
    private final JoystickButton rightStickButton = new JoystickButton(mechController,
        XboxController.Button.kRightStick.value);

  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    IntakePivotSubsystem = new IntakePivotSubsystem();
    IntakeRollerSubsystem = new IntakeRollerSubsystem();
    configureBindings();
  }

  



  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

    // right trigger moves rollers outwards
    rightBumper.onTrue(new InstantCommand(() -> {IntakeRollerSubsystem.setRollSpeeds(-0.2);}, IntakeRollerSubsystem));

    //left trigger moves rollers inwards
    leftBumper.onTrue(new InstantCommand(() -> {IntakeRollerSubsystem.setRollSpeeds(0.2);}, IntakeRollerSubsystem));

    //b button sets roller speed to 0 (stops them)
    bButton.onTrue(new InstantCommand(() -> {IntakeRollerSubsystem.setRollSpeeds(0);}, IntakeRollerSubsystem));

    //a button intakes note then gets it to AMP position 
    //set position to extended, roll in until amp sensor reached
    //then set position to retracted
    aButton.onTrue(new InstantCommand(() ->  {
      IntakePivotSubsystem.setPosition(1);
      boolean ampSensorState = IntakeRollerSubsystem.getAmpSensor();
      while(!ampSensorState) {
        IntakeRollerSubsystem.setRollSpeeds(0.2);
      }
      IntakeRollerSubsystem.setRollSpeeds(0);
      IntakePivotSubsystem.setPosition(0);

  }, IntakePivotSubsystem));

    //y button moves from amp position to shooter position if note is there
    //if amp sensor true, roll out and move out
    yButton.onTrue(new InstantCommand(() ->  {
      boolean ampSensorState = IntakeRollerSubsystem.getAmpSensor();
      if(ampSensorState) {
        IntakeRollerSubsystem.setRollSpeeds(-0.2);
        IntakePivotSubsystem.setPosition(1);
      }

  }, IntakePivotSubsystem));

    //x button retracts (stores)
    xButton.onTrue(new InstantCommand(() -> {IntakePivotSubsystem.setPosition(0);}, IntakePivotSubsystem)

    );





    



  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
