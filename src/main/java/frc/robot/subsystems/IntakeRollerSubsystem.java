// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//1 = clockwise, -1 = counterclockwise

package frc.robot.subsystems;

import static frc.robot.Constants.IntakeConstants;

import javax.imageio.plugins.tiff.TIFFDirectory;


import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.networktables.BooleanPublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** The subsystem that controls the rollers on the intake. */
public class IntakeRollerSubsystem extends SubsystemBase {
    private final CANSparkMax frontMotors;
    //private final TalonSRX integrationMotor;
    private final DigitalInput frontSensor;
    private final DigitalInput rockwellSensor;
    private final DigitalInput ampSensor;
    // private ColorSensorV3 colorSensor;

    private boolean prevFrontSensorValue = false;

    /** 
     * Subsystem controls the front, middle, and integration rollers for the intake.
     */
    public IntakeRollerSubsystem() {
        frontMotors = new CANSparkMax(IntakeConstants.FRONT_MOTOR_ID, MotorType.kBrushless);
        frontMotors.setIdleMode(IdleMode.kBrake);
        frontMotors.setInverted(true);
        frontSensor = new DigitalInput(3);
        rockwellSensor = new DigitalInput(4);
        ampSensor = new DigitalInput(5);

        // colorResetTimer = new Timer();
        // colorResetTimer.start();
    }



    /**
     * Gets the front sensor value.
     *
     * @return The current measurement of the front sensor.
     */
    public boolean getFrontSensorValue() {
        return !frontSensor.get();
    }

    /**
     * Gets the back sensor value.
     *
     * @return The current measurement of the back sensor.
     */
    public boolean getRockwellSensorValue() {
        return !rockwellSensor.get();
    }

    /**
     * sets the speed for the front and integration rollers.
     *
     * @param frontSpeed The speed for the front rollers.
     * @param integrationSpeed The speed for the integration rollers.
     */
    public void setRollSpeeds(double frontSpeed) {
        frontMotors.set(frontSpeed);
        
    }

    public boolean getAmpSensor() {
        return ampSensor.get();
    }

    @Override
    public void periodic() {
    }
}
