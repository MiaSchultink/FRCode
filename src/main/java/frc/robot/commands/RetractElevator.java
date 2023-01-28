package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TelescopicArm;

public class RetractElevator extends CommandBase {
    
    private final TelescopicArm telescopicArm;

    public RetractElevator(TelescopicArm arm){
        telescopicArm = arm;
    }
    
    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        telescopicArm.goToRetractedPos();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
