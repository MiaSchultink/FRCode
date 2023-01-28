package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TelescopicArm;

public class ManualElevatorRetract extends CommandBase {
    private final TelescopicArm telescopicArm;

    public ManualElevatorRetract(TelescopicArm arm){
        telescopicArm = arm;
    }

    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        telescopicArm.manualRetractElevator();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
