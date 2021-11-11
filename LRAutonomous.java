package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "LRAutonomous", group = "11846")
public class LRAutonomous extends LinearOpMode{
    private ElapsedTime myruntime = new ElapsedTime();
    private Robot myrobot = new Robot();

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "I am booting up. Almost there");
        telemetry.update();

        myrobot.initHW(hardwareMap);

        waitForStart();
        myruntime.reset();

        myrobot.DriveForwardEncodersByInches(40,0.5);
        myrobot.wait(3000);
        myrobot.TurnWithEncodersByDegrees(75,0.5);
        myrobot.wait(2000);
        myrobot.DriveForwardEncodersByInches(-37,0.5);
        myrobot.wait(3000);
        myrobot.spinCarouselRight(0.75);
        myrobot.wait(4000);
        myrobot.spinCarouselLeft(0);
        myrobot.DriveForwardEncodersByInches(5,0.5);
        myrobot.wait(1000);
        myrobot.TurnWithEncodersByDegrees(-75,0.5);
        myrobot.wait(2000);
        myrobot.DriveForwardEncodersByInches(18,0.5);
        myrobot.wait(2000);
        /*myrobot.TurnByDegrees(50);
        myrobot.DriveByInches(124);*/
    }
}