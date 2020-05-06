package com.company;

public class VideoClass extends DigitalResource {
    private static double percentage;

    public VideoClass(Subject subject, int timeForCreation, double percentage){
        super(subject, timeForCreation);
        this.percentage = percentage;
    }

    @Override
    public double totalTime() {
        double inc = (percentage + 100) / 100;

        if (inc == 0 )
            return super.totalTime();

        return super.totalTime() * inc;
    }

    public void increasePercentage(double num){
        percentage+=num;
    }

    public double getPercentage() {
        return percentage;
    }

    public VideoClass fasterCreation(VideoClass vc1, VideoClass vc2){
        if (vc1.totalTime() > vc2.totalTime())
            return vc2;

        return vc1;
    }

    @Override
    public String toString() {
        return "VideoClass{id=" + this.id +
                ", subject=" + this.subject +
                ", timeForCreation=" + this.timeForCreation +
                ", additionalTime=" + this.additionalTime +
                ", percentage=" + this.percentage +
                ", totalTime=" + this.totalTime() +
                '}';
    }
}
