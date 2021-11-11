package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "RRAutonomous", group = "11846")
public class RRAutonomous extends LinearOpMode{
    private ElapsedTime myruntime = new ElapsedTime();
    private Robot myrobot = new Robot();

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "I am booting up. Almost there");
        telemetry.update();

        myrobot.initHW(hardwareMap);

        waitForStart();
        myruntime.reset();

        myrobot.DriveForwardEncodersByInches(12,0.5);
        myrobot.wait(1000);
        myrobot.TurnWithEncodersByDegrees(90,0.5);
        myrobot.wait(2000);
        myrobot.DriveForwardEncodersByInches(-64,0.5);
        myrobot.wait(3000);
        myrobot.spinCarouselRight(1);
        myrobot.wait(3000);
        myrobot.spinCarouselLeft(0);
        myrobot.DriveForwardEncodersByInches(72,0.5);
        myrobot.wait(3000);
        myrobot.TurnWithEncodersByDegrees(-30,0.5);
        myrobot.wait(1500);
        myrobot.DriveForwardEncodersByInches(56,0.5);
        myrobot.wait(2500);

    }
}