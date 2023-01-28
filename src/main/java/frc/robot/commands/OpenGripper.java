package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;

public class OpenGripper extends CommandBase{
    
    private final Gripper gripper;

    public OpenGripper(Gripper gr){
        gripper = gr;
    }
    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        gripper.openGripper();
    }

    @Override
    public boolean isFinished(){
       return false;
    }
}

