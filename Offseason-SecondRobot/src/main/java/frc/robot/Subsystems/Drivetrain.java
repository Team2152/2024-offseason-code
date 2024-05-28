// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.Constants.DriveConstants;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

  private CANSparkMax leftFront;
  private CANSparkMax leftBack;
  private CANSparkMax rightFront;
  private CANSparkMax rightBack;
  private DifferentialDrive m_drivetrain;

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    // Sets new motors.
    leftFront = new CANSparkMax(DriveConstants.leftFront, MotorType.kBrushless);
    leftBack = new CANSparkMax(DriveConstants.leftBack, MotorType.kBrushless);
    rightFront = new CANSparkMax(DriveConstants.rightFront, MotorType.kBrushless);
    rightBack = new CANSparkMax(DriveConstants.rightBack, MotorType.kBrushless);

    SendableRegistry.addChild(m_drivetrain, leftFront);
    SendableRegistry.addChild(m_drivetrain, rightFront);

    leftBack.follow(leftFront);
    rightBack.follow(rightFront);


    m_drivetrain = new DifferentialDrive(leftFront::set, rightFront::set);
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public Command tankDriveCommand(double left_throttle, double right_throttle)  {
    return run(
      () -> m_drivetrain.tankDrive(left_throttle, right_throttle));
  }

}
