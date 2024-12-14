package com.example.acegym;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private ArrayList<Training> training;
    private static ArrayList<Plan> plans;

    public Utils() {
        if(training == null){
            training = new ArrayList<>();
            initData();
        }
    }

    private void initData() {
        Training Chest = new Training(
                1,
                "Chest",
                "Exercises focused on developing the chest muscles, particularly the pectorals.",
                "Chest exercises target the pectorals (major and minor), the muscles responsible for pushing movements. These exercises are essential for building upper body strength and increasing muscle mass in the chest region. Key exercises include the bench press, push-ups, and chest fly, which can be performed with dumbbells, barbells, or body weight to vary the intensity.",
                R.drawable.chest);
        training.add(Chest);

        Training Back = new Training(
                2,
                "Back",
                "Exercises that target the back muscles to enhance posture, strength, and overall back development.",
                "Back exercises strengthen the latissimus dorsi, trapezius, rhomboids, and other muscles of the back. These movements improve posture, contribute to overall body strength, and are crucial for functional fitness. Key exercises include pull-ups, lat pulldowns, rows, and deadlifts, which work the upper and lower back and help in developing a strong and balanced posterior chain.",
                R.drawable.bback);
        training.add(Back);

        Training Shoulders = new Training(
                3,
                "Shoulders",
                "Shoulder exercises help develop the deltoids and improve shoulder stability and mobility.",
                "Shoulder exercises primarily target the deltoids, consisting of three parts: front, middle, and rear deltoids. Strong shoulders are essential for a wide range of upper body movements and can help prevent injuries. Common exercises include the shoulder press, lateral raises, and front raises, which engage the deltoid muscles and improve strength and range of motion for overhead movements.",
                R.drawable.shoulders);
        training.add(Shoulders);

        Training Arms = new Training(
                4,
                "Arms",
                "Focuses on building the biceps and triceps, contributing to arm strength and definition.",
                " Arm exercises focus on the muscles of the upper arms, primarily the biceps and triceps. These exercises improve both strength and aesthetics, with exercises such as bicep curls, tricep dips, and hammer curls. Developing arm strength is essential for improving overall upper body performance and increasing muscle mass in the arms.",
                R.drawable.arms);
        training.add(Arms);

        Training Legs = new Training(
                5,
                "Legs",
                "Exercises aimed at strengthening the lower body muscles, including the quadriceps, hamstrings, and glutes.",
                "Leg exercises are essential for building strength, power, and endurance in the lower body. These exercises target the quadriceps, hamstrings, glutes, and calves. Squats, lunges, and leg presses are key exercises that enhance leg strength, stability, and mobility. Strong legs are essential for overall athletic performance and functional movements such as walking, running, and jumping.",
                R.drawable.leg);
        training.add(Legs);

        Training core = new Training(
                6,
                "Core",
                "Exercises that strengthen the muscles of the abdominal region, improving posture and stability.",
                "Core exercises focus on the muscles of the abdomen, lower back, and obliques. These exercises are important for improving posture, balance, and overall stability. Core strength is essential for almost every movement pattern in fitness, as well as preventing injuries. Planks, crunches, and Russian twists are key exercises that help in toning and strengthening the core muscles.",
                R.drawable.core);
        training.add(core);

        Training cardio = new Training(
                7,
                "Cardio",
                "Exercises that elevate the heart rate and improve cardiovascular fitness, often engaging the whole body.",
                "Cardio exercises are designed to improve the efficiency of the heart and lungs, as well as burn fat. These exercises increase heart rate, stamina, and endurance. Full-body cardio exercises such as jump rope, burpees, and mountain climbers engage multiple muscle groups and improve cardiovascular health. Cardio is also essential for fat loss, weight management, and overall fitness.",
                R.drawable.cardio);
        training.add(cardio);

    }

    public synchronized static Utils getInstance(){
        if(null == instance ){
            instance = new Utils();
        }
        return instance;
    }

    public ArrayList<Training> getTraining() {
        return training;
    }

    public static boolean addPlan(Plan plan){
        if(null == plans){
            plans = new ArrayList<Plan>();
        }
        return plans.add(plan);
    }
}
