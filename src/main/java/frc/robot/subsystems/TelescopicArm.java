package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TelescopicArm extends SubsystemBase{
    private CANSparkMax pivotMotor = new CANSparkMax(Constants.TEL_ARM_PIVOT_ID, MotorType.kBrushless);
    private CANSparkMax elevatorMotor = new CANSparkMax(Constants.TEL_ARM_ELEVATOR_ID, MotorType.kBrushless);

    private RelativeEncoder pivotEncoder = pivotMotor.getEncoder();
    private RelativeEncoder elevatorEncoder = elevatorMotor.getEncoder();

    private int pivotKP = 1;
    private int pivotKI = 0;
    private int pivotKD = 0;
    private double pivotSetPoint =0;
    private PIDController pivotPIDController = new PIDController(pivotKP, pivotKI, pivotKD);

    private int eleKP = 1;
    private int eleKI = 0;
    private int eleKD = 0;
    private double elevatorSetPoint = 0;
    private PIDController elevatorPidController = new PIDController(eleKP, eleKI, eleKD);

    public TelescopicArm(){

    }
    public double getPivotMotorMeasurement(){
        return pivotEncoder.getPosition();
    }
    public double getElevatorMotorMeasuremnet(){
        return elevatorEncoder.getPosition();
    }

    public void setPivotSetpoint(double value){
        this.pivotSetPoint = value;
    }
    public void setElevatorSetpoint(double value){
        this.elevatorSetPoint = value;
    }
    public boolean pivAtSetpoint(){
        return this.getPivotMotorMeasurement() == this.pivotSetPoint;
    }
    public boolean eleAtSetpoint(){
        return this.getElevatorMotorMeasuremnet() == this.elevatorSetPoint;
    }

    @Override
    public void periodic(){

    }

    public double getPivotMotorSpeed(){
        double speed = pivotPIDController.calculate(this.getPivotMotorMeasurement());
        return speed;
    }
    public double getElevatorMotorSpeed(){
        double speed = elevatorPidController.calculate(this.getElevatorMotorMeasuremnet());
        return speed;
    }

    public void manualElevatorUp(){
        if(this.getPivotMotorMeasurement()<Constants.PIVOT_FULLY_EXTENDED_POS){
            elevatorMotor.set(Constants.ELEVATOR_UP_SPEED);
        }
        else{
            elevatorMotor.set(0);
        }
    }
    public void manualElevatorDown(){
        if(this.getPivotMotorMeasurement() > Constants.PIVOT_FULLY_RETRACTED_POS){
            elevatorMotor.set(Constants.ELEVATOR_DOWN_SPEED);
        }
        else{
            elevatorMotor.set(0);
        }
    }
    public void manualRetractElevator(){
        if(this.getElevatorMotorMeasuremnet() > Constants.ELEVATOR_FULLY_RETRACTED_HEIGHT){
            elevatorMotor.set(Constants.ELEVATOR_IN_SPEED);
        }
        else{
            elevatorMotor.set(0);
        }
    }
    public void manualExtendElevator(){
        if(this.getElevatorMotorMeasuremnet() < Constants.ELEVATOR_FULLY_EXTENDED_POS){
            elevatorMotor.set(Constants.ELEVATOR_OUT_SPEED);
        }
        else{
            elevatorMotor.set(0);
        }
    }

    public void goToRetractedPos(){
        this.elevatorSetPoint = Constants.ELEVATOR_FULLY_RETRACTED_HEIGHT;
        this.pivotSetPoint = Constants.PIVOT_FULLY_RETRACTED_POS;

        double eleSpeed = this.getElevatorMotorSpeed();
        double pivSpeed= this.getPivotMotorSpeed();

        elevatorMotor.set(eleSpeed);
        pivotMotor.set(pivSpeed);
    }

  
   public void goToPickUp(){
       this.pivotSetPoint = Constants.PIVOT_PICK_UP_POS;
       this.elevatorSetPoint = Constants.ELEVATOR_PICK_UP_HEIGHT;

       double pivotSpeed = this.getPivotMotorSpeed();
       double elevatorSpeed = this.getElevatorMotorSpeed();

       pivotMotor.set(pivotSpeed);
       elevatorMotor.set(elevatorSpeed);
   }

   public void goToPlaceBottomCone(){
       this.pivotSetPoint = Constants.PIVOT_PLACE_BOTTOM_CONE_POS;
       this.elevatorSetPoint = Constants.ELEVATOR_BOTTOM_CONE_HEIGHT;

       double pivSpeed = this.getPivotMotorSpeed();
       double eleSpeed = this.getElevatorMotorSpeed();

       pivotMotor.set(pivSpeed);
       elevatorMotor.set(eleSpeed);
   }
   public void goToPlaceTopCone(){
       this.pivotSetPoint = Constants.PIVOT_PLACE_TOP_CONE_POS;
       this.elevatorSetPoint = Constants.ELEVATOR_TOP_CONE_HEIGHT;

       double pivSpeed = this.getPivotMotorSpeed();
       double eleSpeed = this.getElevatorMotorSpeed();

       pivotMotor.set(pivSpeed);
       elevatorMotor.set(eleSpeed);
   }
   public void goToPlaceBottomCube(){
       this.pivotSetPoint = Constants.PIVOT_PLACE_BOTTOM_CUBE_POS;
       this.elevatorSetPoint = Constants.ELEVATOR_BOTTOM_CUBE_HEIGHT;

       double pivSpeed = this.getPivotMotorSpeed();
       double eleSpeed = this.getElevatorMotorSpeed();

       pivotMotor.set(pivSpeed);
       elevatorMotor.set(eleSpeed);
   }
   public void goToPlaceTopCube(){
       this.pivotSetPoint = Constants.PIVOT_PLACE_TOP_CUBE_POS;
       this.elevatorSetPoint = Constants.ELEVATOR_PLACE_TOP_CUBE_POS;
       
       double pivSpeed = this.getPivotMotorSpeed();
       double eleSpeed = this.getElevatorMotorSpeed();

       pivotMotor.set(pivSpeed);
       elevatorMotor.set(eleSpeed);
   }

   
}
