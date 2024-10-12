package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeRollerSubsystem;

/** Sets the roller speed. */ 
public class RollersCommand extends Command {
    private final IntakeRollerSubsystem rollerSubsystem;
    private double speed;

    /**
     * Sets the rollers to some speed.
     *
     * @param intakeRollerSubsystem The {@link IntakeRollerSubsystem} to set the rollers on.
     * @param speed The speed to set the rollers to.
     */
    public RollersCommand(IntakeRollerSubsystem intakeRollerSubsystem, double speed) {
        this.rollerSubsystem = intakeRollerSubsystem;
        addRequirements(intakeRollerSubsystem);
        this.speed = speed;
    }

    @Override
    public void initialize() {
        rollerSubsystem.setRollSpeeds(speed);
        
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