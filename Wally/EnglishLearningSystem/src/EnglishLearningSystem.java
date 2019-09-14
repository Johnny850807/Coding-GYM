import java.util.Scanner;

public class EnglishLearningSystem {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String userInput;
        VocabularyList englishVocabularyList = new VocabularyList();

        System.out.println("您好，歡迎來到英文單字複習系統 v1.0");
        
        do {
            System.out.println("(1)管理單字(2)進行複習(3)離開");
            userInput = input.nextLine();
            switch (userInput) {
                case "1":
                    manageVocabularys(englishVocabularyList);
                    break;
                case "2":
                    reviewVocabularys(englishVocabularyList);
                    break;
                case "3":
                    System.out.println("使用結束，感謝您的使用");
                    break;
                default:
                    System.out.println("輸入錯誤，請重新輸入");
                    break;
            }
            englishVocabularyList.saveFile();
        } while (!userInput.equals("3"));
    }

    private static void manageVocabularys(VocabularyList englishVocabularyList) {
        System.out.println("(1)新增單字(2)刪除單字(3)返回");
        String userInputOption = input.nextLine();
        switch (userInputOption) {
            case "1":
                System.out.println("請輸入要新增的單字：");
                String userAddVocabulary = EnglishLearningSystem.input.nextLine();
                englishVocabularyList.addVocabulary(userAddVocabulary);
                break;
            case "2":
                System.out.println("請輸入要刪除的單字：");
                String userRemoveVocabulary = EnglishLearningSystem.input.nextLine();
                englishVocabularyList.removeVocabulary(userRemoveVocabulary);
                break;
            case "3":
                System.out.print("返回中");
                try {
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(300);
                        System.out.print(".");
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\n已返回");
                break;
            default:
                System.out.println("輸入錯誤，請重新輸入");
                break;
        }
    }

    private static void reviewVocabularys(VocabularyList englishVocabularyList) {
        if (englishVocabularyList.getVocabularyMap().isEmpty()) {
            System.out.println("請先添加單字");
        } else {
            VocabularyExam englishVocabularyExam = new VocabularyExam(englishVocabularyList);
            englishVocabularyExam.startEnglishExam();
        }
    }
}
