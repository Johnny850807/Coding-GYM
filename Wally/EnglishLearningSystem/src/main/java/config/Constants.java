package config;

/**
 * @author - wally55077@gmail.com
 */
public interface Constants {

    String CONFIG_FILE_PATH = "config.yml";

    String $ = "$";
    String SLASH = "/";
    String EMPTY = "";
    String COLON = ":";
    String BRACES = "{}";
    String COMMA = ",";
    String DOT = ".";
    String EXCLAMATION = "!";
    String SPACE = " ";
    String NEXT_LINE = "\n";
    String LEFT_PARENTHESES = "(";
    String RIGHT_PARENTHESES = ")";

    String FIRST = "1";
    String SECOND = "2";
    String THIRD = "3";

    String FIRST_OPTION = LEFT_PARENTHESES + FIRST + RIGHT_PARENTHESES;
    String SECOND_OPTION = LEFT_PARENTHESES + SECOND + RIGHT_PARENTHESES;
    String THIRD_OPTION = LEFT_PARENTHESES + THIRD + RIGHT_PARENTHESES;

    String OPENING = "您好，歡迎來到英文單字複習系統 v1.0";
    String INPUT_INVALID_ANSWER = "輸入錯誤";
    String YOUR_VOCABULARY = "您的單字：";
    String INPUT_ADD_VOCABULARY = "請輸入要新增的單字：";
    String INPUT_DELETE_VOCABULARY = "請輸入要刪除的單字：";
    String VOCABULARY_NOT_FOUND = "錯誤，找不到該單詞。";
    String VOCABULARY_ALREADY_EXIST = "錯誤，該單詞已存在。";
    String ADD_VOCABULARY_ERROR = "錯誤，無法加入該單字。";
    String DELETE_VOCABULARY_ERROR = "錯誤，無法刪除該單字。";
    String INPUT_QUESTION_ANSWER = "請輸入答案";
    String INPUT_QUESTION_ANSWER_ERROR = "錯誤，剩下" + BRACES + "次機會。";
    String EXAM_FINISHED = "恭喜你成功了！";
    String EXAM_FAILED = "失敗！請多複習！答案為" + BRACES + "！";
    String VOCABULARY = "單字";
    String PART_OF_SPEECH = "詞性";
    String DEFINITION = "意思";
    String FINISHED = "完成";
    String ANSWER_CORRECT = "答對";
    String START_EXAM = "複習開始";

    String MANGE = FIRST;
    String MANGE_FEATURE_NAME = "管理單字";

    String REVIEW = SECOND;
    String REVIEW_FEATURE_NAME = "進行複習";

    String LEAVE = THIRD;
    String LEAVE_FEATURE_NAME = "離開";
    String TAKE_A_BOW = "歡迎再來。";

    String ADD_VOCABULARY = FIRST;
    String ADD_VOCABULARY_FEATURE_NAME = "新增單字";

    String DELETE_VOCABULARY = SECOND;
    String DELETE_VOCABULARY_FEATURE_NAME = "刪除單字";

    String BACK_LAST_PAGE = THIRD;
    String BACK_LAST_PAGE_FEATURE_NAME = "返回";

    String SLASH_SPLIT = "\\s*" + SLASH + "\\s*";
    String BRACES_SPLIT = "\\{\\}";
    String EQUAL_SPLIT = "=";

    String DEFAULT_UPDATE_DATE = "0001-01-01";
//    String WORD = "Word";
//    String PART_OF_SPEECH = "PartOfSpeech";
//    String DEFINITION = "Definition";
//    String UPDATE_TIME = "UpdateTime";

}
