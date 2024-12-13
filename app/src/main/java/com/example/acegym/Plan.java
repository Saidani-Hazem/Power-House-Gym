package com.example.acegym;

import android.os.Parcel;
import android.os.Parcelable;

public class Plan implements Parcelable {

    private String TrainingName, day;
    private int minute;
    private boolean isAccomplished;

    public Plan(String trainingName, String day, int minute, boolean isAccomplished) {
        TrainingName = trainingName;
        this.day = day;
        this.minute = minute;
        this.isAccomplished = isAccomplished;
    }

    protected Plan(Parcel in) {
        TrainingName = in.readString();
        day = in.readString();
        minute = in.readInt();
        isAccomplished = in.readByte() != 0;
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    public String getTrainingName() {
        return TrainingName;
    }

    public void setTrainingName(String trainingName) {
        TrainingName = trainingName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean isAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(boolean accomplished) {
        isAccomplished = accomplished;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "TrainingName='" + TrainingName + '\'' +
                ", day='" + day + '\'' +
                ", minute=" + minute +
                ", isAccomplished=" + isAccomplished +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TrainingName);
        dest.writeString(day);
        dest.writeInt(minute);
        dest.writeByte((byte) (isAccomplished ? 1 : 0));
    }
}
