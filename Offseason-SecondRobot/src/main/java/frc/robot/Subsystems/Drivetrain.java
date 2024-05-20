// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

  CANSparkMax leftMaster;
  CANSparkMax leftSlave;
  CANSparkMax rightMaster;
  CANSparkMax rightSlave;
  DifferentialDrive m_drivetrain;

  MotorController m_test;

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    leftMaster = new CANSparkMax(1, MotorType.kBrushless);
    leftSlave = new CANSparkMax(2, MotorType.kBrushless);
    rightMaster = new CANSparkMax(3, MotorType.kBrushless);
    rightSlave = new CANSparkMax(4, MotorType.kBrushless);

    m_drivetrain = new DifferentialDrive(leftMaster, rightMaster);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Command drive(double moveThrottle, double turnThrottle) {
    return run(() -> m_drivetrain.arcadeDrive(moveThrottle, turnThrottle));
  }

}
