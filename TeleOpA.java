package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name="TeleOpA", group="11846")
public class TeleOpA extends OpMode{
    Robot myrobot = new Robot();
    double left = 0.00;
    double right = 0.00;
    double carouselleft = 0.00;
    double carouselright = 0.00;
    double intakearm = 0.00;

    @Override
    public void init() {
        myrobot.initHW(hardwareMap);
    }

    @Override
    public void loop() {
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;
        carouselright = gamepad1.right_trigger;
        intakearm = gamepad2.right_stick_y*.9;

        if((gamepad1.left_trigger) > 0){
            myrobot.spinCarouselLeft(1);
        } else {
            myrobot.spinCarouselLeft(0);
        }

        if(gamepad1.a){
            myrobot.ResetEncoders();
        }

        if((gamepad2.x) & (!gamepad2.y)){
            myrobot.intakeOn(1);
        } else if((!gamepad2.x) & (gamepad2.y)){
            myrobot.intakeReverse(1);
        } else {
            myrobot.intakeOff();
        }

        if(gamepad1.right_bumper) {
            myrobot.LeftDrive(left*0.5);
            myrobot.RightDrive(right*0.5);
        } else {
            myrobot.LeftDrive(left);
            myrobot.RightDrive(right);

        }

        telemetry.addData("armEncoderPosition", myrobot.myself.iam.getCurrentPosition());
        telemetry.addData("leftfrontencodercount", myrobot.myself.leftFrontDrive.getCurrentPosition());
        telemetry.addData("leftbackencodercount", myrobot.myself.leftBackDrive.getCurrentPosition());
        telemetry.addData("rightfrontencodercount", myrobot.myself.rightFrontDrive.getCurrentPosition());
        telemetry.addData("rightbackencodercount", myrobot.myself.rightBackDrive.getCurrentPosition());
        telemetry.addData("leftbumper", carouselleft);
        telemetry.addData("rightbumper", carouselright);
        telemetry.addData("arm", intakearm);
        myrobot.spinCarouselRight(carouselright);
        myrobot.ArmDrive(intakearm);
        telemetry.update();

        }
    }