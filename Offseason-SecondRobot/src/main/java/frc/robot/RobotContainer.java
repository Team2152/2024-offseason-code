// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OIConstants;
import frc.robot.Subsystems.Drivetrain;

public class RobotContainer {

  public Drivetrain m_Drivetrain = new Drivetrain();

  CommandXboxController m_driverController = new CommandXboxController(OIConstants.kDriverControllerPort);
  

  public RobotContainer() {

    configureBindings();

    m_Drivetrain.setDefaultCommand(Commands.run(
      () -> m_Drivetrain.tankDriveCommand(m_driverController.getLeftY(), m_driverController.getRightY()), m_Drivetrain));
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
