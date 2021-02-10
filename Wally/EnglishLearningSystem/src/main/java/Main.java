import views.EnglishLearningSystem;
import presenters.impl.EnglishLearningPresenterImpl;
import respostories.impl.EnglishLearningFileRepository;

/**
 * @author - wally55077@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        EnglishLearningSystem englishLearningSystem =
                new EnglishLearningSystem(System.in,
                        new EnglishLearningPresenterImpl(
                                new EnglishLearningFileRepository()));
        englishLearningSystem.start();
    }
}
