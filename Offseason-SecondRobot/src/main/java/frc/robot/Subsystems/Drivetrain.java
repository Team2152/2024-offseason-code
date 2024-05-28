// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

  CANSparkMax leftFront;
  CANSparkMax leftBack;
  CANSparkMax rightFront;
  CANSparkMax rightBack;
  DifferentialDrive m_drivetrain;

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    // Sets new motors.
    leftFront = new CANSparkMax(DriveConstants.LEFT_MASTER_ID, MotorType.kBrushless);
    leftBack = new CANSparkMax(DriveConstants.RIGHT_MASTER_ID, MotorType.kBrushless);
    rightFront = new CANSparkMax(DriveConstants.LEFT_SLAVE_ID, MotorType.kBrushless);
    rightBack = new CANSparkMax(DriveConstants.RIGHT_SLAVE_ID, MotorType.kBrushless);

    leftBack.follow(leftFront);
    rightBack.follow(rightFront);


    m_drivetrain = new DifferentialDrive(leftFront::set, rightFront::set);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void tankDriveCommand(double left_throttle, double right_throttle)  {
    m_drivetrain.tankDrive(left_throttle, right_throttle);
  }



}
