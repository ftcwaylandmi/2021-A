package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "RBAutonomous", group = "11846")
public class RBAutonomous extends LinearOpMode {
    private ElapsedTime myruntime = new ElapsedTime();
    private Robot myrobot = new Robot();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "I am booting up. Almost there");
        telemetry.update();

        myrobot.initHW(hardwareMap); // You forgot to init hardware

        waitForStart();
        myruntime.reset();

        myrobot.DriveForwardEncodersByInches(40,0.5);
        myrobot.wait(2000);
        myrobot.TurnWithEncodersByDegrees(-45,0.5);
        myrobot.wait(1000);
        myrobot.DriveForwardEncodersByInches(-38,0.5);
        myrobot.wait(2000);
        myrobot.spinCarouselLeft(0.5);
        myrobot.wait(4000);
        myrobot.spinCarouselLeft(0);
        myrobot.DriveForwardEncodersByInches(6,0.5);
        myrobot.wait(500);
        myrobot.TurnWithEncodersByDegrees(90,0.5);
        myrobot.wait(2000);
        myrobot.DriveForwardEncodersByInches(18,0.5);
        myrobot.wait(1000);

    }
}
