package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakePivotSubsystem;
import frc.robot.subsystems.IntakeRollerSubsystem;

/** Sets the intake pivot position. */ 
public class Rollers extends Command {
    private final IntakeRollerSubsystem rollerSubsystem;

    /**
     * Sets the intake pivot to a position.
     *
     * @param intakePivotSubsystem The {@link IntakePivotSubsystem} to set the pivot on.
     * @param position The position [0, 1] to set the pivot to. 0 is stowed, 1 is fully extended.
     */
    public Rollers(IntakeRollerSubsystem intakeRollerSubsystem, double position) {
        this.rollerSubsystem = intakeRollerSubsystem;
        addRequirements(intakeRollerSubsystem);
    }

    @Override
    public void initialize() {
        rollerSubsystem.setRollSpeeds(0.2);
        
    }

    @Override
    public void end(boolean interrupted) {
        rollerSubsystem.setRollSpeeds(0);
        
    }

    @Override
    public boolean isFinished() {
        return true;
        
       
    }
}