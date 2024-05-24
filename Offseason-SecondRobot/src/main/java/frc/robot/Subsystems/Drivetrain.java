// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import java.util.HashMap;
import java.util.Map;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

  public CANSparkMax leftFront;
  public CANSparkMax leftBack;
  public CANSparkMax rightFront;
  public CANSparkMax rightBack;
  public Map<String, CANSparkMax> motorMap;

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    leftFront = new CANSparkMax(DriveConstants.LEFT_MASTER_ID, MotorType.kBrushless);
    leftBack = new CANSparkMax(DriveConstants.RIGHT_MASTER_ID, MotorType.kBrushless);
    rightFront = new CANSparkMax(DriveConstants.LEFT_SLAVE_ID, MotorType.kBrushless);
    rightBack = new CANSparkMax(DriveConstants.RIGHT_SLAVE_ID, MotorType.kBrushless);

    motorMap = new HashMap<String, CANSparkMax>();
    motorMap.put("leftFront", leftFront);
    motorMap.put("rightFront", rightFront);
    motorMap.put("leftBack", leftBack);
    motorMap.put("leftBack", leftBack);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public Map<String, CANSparkMax> getMotors() {
    return motorMap;
  }


}
