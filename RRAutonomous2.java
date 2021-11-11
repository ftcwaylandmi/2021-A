package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "RRAutonomous2", group = "11846")
public class RRAutonomous2 extends LinearOpMode {
    private ElapsedTime myruntime = new ElapsedTime();
    private Robot myrobot = new Robot();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "I am booting up. Almost there");
        telemetry.update();

        myrobot.initHW(hardwareMap);

        waitForStart();
        myruntime.reset();

        myrobot.DriveByInches(24);
        myrobot.TurnByDegrees(-100);
        myrobot.DriveByInches(-15);
        myrobot.DriveByInches(51);

    }
}