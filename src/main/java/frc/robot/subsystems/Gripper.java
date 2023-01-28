package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Gripper extends SubsystemBase {
    private CANSparkMax gripperMotor = new CANSparkMax(Constants.GRIPPER_MOTOR_ID, MotorType.kBrushless);
    private int kP = 1;
    private int kI = 0;
    private int kD = 0;
    private int kF = 0;
    private double setpoint =0;

    private RelativeEncoder encoder = gripperMotor.getEncoder();
    private PIDController pid = new PIDController(kP, kI, kD);

    public Gripper(){
     
    }

    private double getMeasurement(){
       return this.encoder.getPosition();
    }

    public void setSetPoint(double value){
        this.setpoint = value;
    }

    @Override
    public void periodic(){

    }

    public double getMotorSpeed(){
        return pid.calculate(this.getMeasurement());
    }
    

    public boolean atSetpoint(double measurment){
        boolean atSet = (measurment==this.setpoint);
        return atSet;
    }

    public void openGripper(){
        double speed =  this.getMotorSpeed();
        this.setpoint = Constants.GRIPPER_OPEN;
        gripperMotor.set(speed);
    }
    public void closeGripper(){
       double speed = this.getMotorSpeed();
       this.setpoint = Constants.GRIPPER_CLOSED;
       gripperMotor.set(-speed);
    }
}
