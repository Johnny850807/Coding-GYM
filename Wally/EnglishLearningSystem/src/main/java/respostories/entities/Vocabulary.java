package respostories.entities;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static config.Constants.DEFAULT_UPDATE_DATE;

/**
 * @author i19
 */
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Vocabulary implements Serializable {

    @NonNull
    private String word;

    private Map<PartOfSpeech, List<Definition>> definitions = new LinkedHashMap<>();

    public String getWord() {
        return word;
    }

    public Map<PartOfSpeech, List<Definition>> getDefinitions() {
        return definitions;
    }

    public Definition getDefinition(PartOfSpeech partOfSpeech) {
        Random random = new Random();
        List<Definition> definition = definitions.get(partOfSpeech);
        return definition.get(random.nextInt(definition.size()));
    }

    public void addDefinition(PartOfSpeech partOfSpeech, String definition) {
        if (!definitions.containsKey(partOfSpeech)) {
            definitions.put(partOfSpeech, new ArrayList<>());
        }
        definitions.get(partOfSpeech).add(new Definition(definition));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getWord()).append(":\n");
        for (PartOfSpeech partOfSpeech : definitions.keySet()) {
            sb.append("====   ").append(partOfSpeech).append("   ====\n");
            for (Definition definition : definitions.get(partOfSpeech)) {
                sb.append("    ").append(definition.getDefinition()).append("\n");
            }
        }
        return sb.toString();
    }

    public enum PartOfSpeech {
        //單字詞性
        NOUN, PRONOUN, VERB, AUXILIARY_VERB, ADJECTIVE,
        ADVERB, CONJUNCTION, PREPOSITION, ARTICLE, INTERJECTION
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class Definition {

        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @NonNull
        private String definition;

        private LocalDate updateDate = LocalDate.parse(DEFAULT_UPDATE_DATE, formatter);

        public Definition(String definition, String updateDate) {
            setDefinition(definition);
            setUpdateDate(updateDate);
        }

        public String getDefinition() {
            return definition;
        }

        public void setDefinition(String definition) {
            this.definition = definition;
        }

        public String getStringUpdateTime() {
            return Optional.ofNullable(updateDate)
                    .map(createTime -> createTime.format(formatter))
                    .orElse(LocalDate.now().format(formatter));
        }

        public LocalDate getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = LocalDate.parse(updateDate, formatter);
        }

        public void setDefaultUpdateTime() {
            this.updateDate = LocalDate.parse(DEFAULT_UPDATE_DATE, formatter);
        }

        public String getDefaultUpdateTime() {
            return DEFAULT_UPDATE_DATE;
        }

    }
}
