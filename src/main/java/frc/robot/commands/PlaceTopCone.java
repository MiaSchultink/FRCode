package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.TelescopicArm;

public class PlaceTopCone extends CommandBase{
    private final TelescopicArm telescopicArm;
    private final Gripper gripper;

    public PlaceTopCone(Gripper gr, TelescopicArm arm){
        gripper = gr;
        telescopicArm = arm;
    }

    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        telescopicArm.goToPlaceTopCone();
        gripper.openGripper();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
