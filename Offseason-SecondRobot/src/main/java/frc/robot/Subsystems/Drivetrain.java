// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.HashMap;
import java.util.Map;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

  public CANSparkMax leftFront;
  public CANSparkMax leftBack;
  public CANSparkMax rightFront;
  public CANSparkMax rightBack;
  private final Map<String, CANSparkMax> motorMap;

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    leftFront = new CANSparkMax(DriveConstants.LEFT_FRONT, MotorType.kBrushless);
    leftBack = new CANSparkMax(DriveConstants.LEFT_BACK, MotorType.kBrushless);
    rightFront = new CANSparkMax(DriveConstants.RIGHT_FRONT, MotorType.kBrushless);
    rightBack = new CANSparkMax(DriveConstants.RIGHT_BACK, MotorType.kBrushless);

    motorMap = new HashMap<String, CANSparkMax>();
    motorMap.put("leftFront", leftFront);
    motorMap.put("rightFront", rightFront);
    motorMap.put("leftBack", leftBack);
    motorMap.put("rightBack", rightBack);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Map<String, CANSparkMax> get_motors() {
    return motorMap;
  }

}
