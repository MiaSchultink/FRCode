package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;

public class CloseGripper extends CommandBase{
    private Gripper gripper;

    public CloseGripper(Gripper gr){
        gripper = gr;
    }

    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        gripper.closeGripper();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
