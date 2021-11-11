package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "LBAutonomous", group = "11846")
public class LBAutonomous extends LinearOpMode{
    private ElapsedTime myruntime = new ElapsedTime();
    private Robot myrobot = new Robot();

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "I am booting up. Almost there");
        telemetry.update();

        myrobot.initHW(hardwareMap);

        waitForStart();
        myruntime.reset();

        myrobot.DriveForwardEncodersByInches(48, 0.5);
        myrobot.wait(2000);
        myrobot.TurnWithEncodersByDegrees(90, 0.5);
        myrobot.wait(2000);
        myrobot.DriveForwardEncodersByInches(60, 0.5);
        myrobot.wait(3000);
        myrobot.TurnWithEncodersByDegrees(-90, 0.5);
        myrobot.wait(2000);
        myrobot.DriveForwardEncodersByInches(-40,0.5);
        myrobot.wait(2000);
        myrobot.spinCarouselLeft(0.5);
        myrobot.wait(6000);
        myrobot.spinCarouselLeft(0);
        myrobot.DriveForwardEncodersByInches(12,0.5);
        myrobot.wait(1000);
        myrobot.TurnWithEncodersByDegrees(-90,0.5);
        myrobot.wait(2000);
        myrobot.DriveForwardEncodersByInches(124,0.5);
        myrobot.wait(5000);

    }
}