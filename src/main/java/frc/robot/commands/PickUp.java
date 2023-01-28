package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.TelescopicArm;

public class PickUp extends CommandBase{
    private final Gripper gripper;
    private final TelescopicArm telescopicArm;

    public PickUp(Gripper gr, TelescopicArm arm){
        gripper = gr;
        telescopicArm = arm;
    }

    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        telescopicArm.goToPickUp();
        gripper.closeGripper();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
