package main;

public abstract class SubjectInputTemplate {

    protected void subjectStatistics() {
        onInputSubject();
        onInputSubjectScore();
        onRestartSubjectStatistics();
    }

    protected abstract void onInputSubject();

    protected abstract void onInputSubjectScore();

    protected abstract void onRestartSubjectStatistics();
}
