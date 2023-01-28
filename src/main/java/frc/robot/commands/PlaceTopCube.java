package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.TelescopicArm;

public class PlaceTopCube extends CommandBase{
    private TelescopicArm telescopicArm;
    private Gripper gripper;

    public PlaceTopCube(Gripper gr,  TelescopicArm arm){
        gripper = gr;
        telescopicArm = arm;
    }
    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        telescopicArm.goToPlaceTopCube();
        gripper.openGripper();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
