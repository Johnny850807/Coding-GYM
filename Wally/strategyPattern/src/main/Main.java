package main;

import subject.Chinese;
import subject.CombinedLanguage;
import subject.English;
import subject.Subject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main extends SubjectInputTemplate {

    private Scanner scanner = new Scanner(System.in);
    private Map<String, Subject> subjectMap = new HashMap<>();
    private String[] subjects = {"國文", "英文", "組合語言"};
    private String[] subjectGrades = {"出席", "作業", "期中", "期末"};
    private Subject subject = null;
    private int resultScore;

    public static void main(String[] args) {
        SubjectInputTemplate main = new Main();
        main.subjectStatistics();
    }

    @Override
    protected void onInputSubject() {
        do {
            try {
                System.out.print("[輸入] 選擇計算總成績科目: (1) 國文 (2) 英文 (3) 組合語言 : ");
                int subjectIndex = Integer.valueOf(scanner.nextLine()) - 1;
                subject = getSubjectBySubjectName(subjects[subjectIndex]);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("[錯誤] 輸入錯誤");
            }
        } while (subject == null);
    }

    private Subject getSubjectBySubjectName(String subjectName) {
        if (!subjectMap.containsKey(subjectName)) {
            Subject subject = null;
            switch (subjectName) {
                case "國文":
                    subject = new Chinese(subjectName);
                    break;
                case "英文":
                    subject = new English(subjectName);
                    break;
                case "組合語言":
                    subject = new CombinedLanguage(subjectName);
                    break;
            }
            subjectMap.put(subjectName, subject);
        }
        return subjectMap.get(subjectName);
    }

    @Override
    protected void onInputSubjectScore() {
        int[] scores = new int[subjectGrades.length];
        for (int subjectIndex = 0; subjectIndex < subjectGrades.length; subjectIndex++) {
            int score = -1;
            do {
                try {
                    System.out.print("[輸入] " + subjectGrades[subjectIndex] + "成績 : ");
                    score = Integer.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("[錯誤] 輸入錯誤");
                }
            } while (score < 0 || score > 100);
            scores[subjectIndex] = score;
        }
        int attendance = scores[0];
        int homeworkGrade = scores[1];
        int midTermResults = scores[2];
        int finalGrade = scores[3];
        System.out.println("[完成] 輸入完畢，請等候計算結果");
        resultScore = subject
                .statistics(attendance, homeworkGrade, midTermResults, finalGrade);
        waitCountingResult(3);
    }

    @Override
    protected void onRestartSubjectStatistics() {
        System.out.println("\n[結果] " + subject.getSubjectName() + " -- " + resultScore);
        subject = null;
        System.out.print("[重新開始] 是否要在計算成績 ? ( Y / N ) : ");
        String restartAnswer = scanner.nextLine().toUpperCase();
        boolean isRestart = restartAnswer.equals("Y") || restartAnswer.isEmpty();
        if (isRestart) {
            System.out.println();
            subjectStatistics();
        }
    }

    private void waitCountingResult(int waitingTime) {
        System.out.print("[計算] 計算中 ");
        for (int i = 0; i < waitingTime; i++) {
            try {
                System.out.print(".");
                Thread.sleep(waitingTime * 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
