package frc.robot.commands;

import org.w3c.dom.traversal.TreeWalker;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.TelescopicArm;

public class Autonomous extends CommandBase{
    private final TelescopicArm telescopicArm;
    private final Gripper gripper;

    public Autonomous(Gripper gr, TelescopicArm arm){
        gripper = gr;
        telescopicArm = arm;
    }
}
