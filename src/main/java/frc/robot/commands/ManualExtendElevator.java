package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TelescopicArm;

public class ManualExtendElevator extends CommandBase{
    private final TelescopicArm telescopicArm;

    public ManualExtendElevator(TelescopicArm arm){
        telescopicArm = arm;
    }

    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        telescopicArm.manualExtendElevator();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
