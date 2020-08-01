import model.words.WordNotExistException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EnglishWordSystem {

    private MyComparator comparator = new MyComparator();
    private Scanner input = new Scanner(System.in);
    private Date dNow;
    private SimpleDateFormat date;
    private Map<String, Integer> word;
    private WordStore store;
    private Catch crawler;
    private static int MANAGE_WORD = 1;
    private static int REVIEW_WORD = 2;
    private static int ADD_WORD = 1;
    private static int DELETE_WORD = 2;

    public EnglishWordSystem() throws IOException {
        store = new WordStore();
        word = store.getMap();
        crawler = Catch.getInstance();
        date = new SimpleDateFormat("dd");
        dNow = new Date();

        select();
    }

    public void select() {
        int manageWord;
        int number;

        System.out.println("您好，歡迎來到英文單字複習系統 v1.0");
        System.out.println("(1) 管理單字 (2) 進行複習 (3) 離開");
        do {
            number = input.nextInt();

        } while (number < 1 || number > 3);

        if (number == MANAGE_WORD) {
            managerWord();
        } else if (number == REVIEW_WORD) {
            review();
        } else {
            System.out.println("歡迎再來");
            System.exit(0);

        }
    }

    public void managerWord() {
        StringBuilder haveWord;
        int number;

        System.out.println("您的單字：");
        while (true) {
            haveWord = new StringBuilder();
            int count = 0;

            for (Map.Entry<String, Integer> entry : word.entrySet()) {
                haveWord.append(entry.getKey());
                if (word.size() - 1 != count) haveWord.append(",");
                count++;
            }

            System.out.println(haveWord);
            do {
                System.out.println(" (1) 新增單字 (2) 刪除單字 (3) 返回");
                number = input.nextInt();

            } while (number < 1 || number > 3);

            if (number == ADD_WORD) {
                addWord();
            } else if (number == DELETE_WORD) {
                deleteWord();
            } else {
                select();
            }

        }
    }

    public void review() {
        int count = 0;
        int wrongAnswer;
        String inputWord;
        List<Map.Entry<String, Integer>> wordsList = sort();

        System.out.println("複習開始！");
        while (true) {

            wrongAnswer = 3;
            String answer = wordsList.get(count).getKey();
            StringBuilder str = new StringBuilder();

            str.append(answer.substring(0, 1));
            for (int i = 0; i < answer.length() - 2; i++) {
                str.append("_");
            }
            str.append(answer.substring(answer.length() - 1, answer.length()));
            String testWord = str.toString();
            System.out.print(testWord);

            try {
                crawler.searchWordOfTest(answer);
            } catch (WordNotExistException e) {
                e.printStackTrace();
            }

            System.out.println();
            System.out.println("請輸入答案");
            do {
                inputWord = input.next();
                if (!inputWord.equals(answer)) {
                    wrongAnswer--;
                    System.out.println("錯誤，剩下" + wrongAnswer + "次機會。");
                }

                if (wrongAnswer == 0) {
                    System.out.println("失敗！請多複習！答案為" + answer + "!");
                    select();
                }
            } while (!inputWord.equals(answer));

            System.out.println("答對！");
            word.put(answer, Integer.parseInt(date.format(dNow)));
            store.setMap(word);
            store.save();
            count++;
        }

    }

    public void addWord() {
        System.out.println("請輸入要新增的單字");
        String inputWord = input.next();
        try {
            crawler.searchWordPartOfSpeechAndMean(inputWord);
            word.put(inputWord, 1);
            store.setMap(word);
            store.save();
            System.out.println("完成！");

        } catch (WordNotExistException e) {
            e.printStackTrace();
            addWord();
        }
    }

    public void deleteWord() {
        String inputWord;
        System.out.println("請輸入要刪除的單字");
        do {
            inputWord = input.next();
        } while (!word.containsKey(inputWord));

        word.remove(inputWord);
        store.setMap(word);
        store.save();
        System.out.println("完成!");
    }

    public List<Map.Entry<String, Integer>> sort() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(word.entrySet());
        list.sort(comparator);

        return list;
    }
}
