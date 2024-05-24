// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Drivetrain;
import java.util.Map;

public class Tankdrive extends Command {
  private final Drivetrain drivetrain;
  private final double leftThrottle;
  private final double rightThrottle;
  DifferentialDrive differentialDrive;
  Map<CANSparkMax, CANSparkMax> motorFollowerMap;

  /** Creates a new Tankdrive. */
  public Tankdrive(Drivetrain driveTrain, double leftThrottle, double rightThrottle) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = driveTrain;
    this.leftThrottle = leftThrottle;
    this.rightThrottle = rightThrottle;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    setupFollowers();
  }

  public void setupFollowers() {
    
    drivetrain.leftFront.follow(drivetrain.leftBack);
    drivetrain.rightFront.follow(drivetrain.rightBack);
    differentialDrive = new DifferentialDrive(drivetrain.leftFront, drivetrain.rightFront);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive();
  }

  public void drive() {
    differentialDrive.tankDrive(leftThrottle, rightThrottle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
