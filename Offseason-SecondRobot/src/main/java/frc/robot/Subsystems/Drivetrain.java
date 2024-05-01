// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;

public class Drivetrain extends SubsystemBase {

  TalonFX leftMaster; 
  TalonFX leftSlave; 
  TalonFX rightMaster; 
  TalonFX rightSlave; 
  DifferentialDrive m_drivetrain;

  MotorController m_test;

  

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    leftMaster = new TalonFX(0);
    leftSlave = new TalonFX(1);
    rightMaster = new TalonFX(2);
    rightSlave = new TalonFX(3);

    DifferentialDrive m_drivetrain = new DifferentialDrive(
    (double output) -> {
        leftMaster.set(output);
        leftSlave.set(output);
    },
    (double output) -> {
        rightMaster.set(output);
        rightSlave.set(output);
    });

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Command drive(double moveThrottle, double turnThrottle) {
    return run(() -> m_drivetrain.arcadeDrive(moveThrottle, turnThrottle));  
  }

}
