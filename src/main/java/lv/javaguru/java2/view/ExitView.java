package lv.javaguru.java2.view;

public class ExitView implements ConsoleView {
    @Override
    public void execute() {
        System.exit(0);
    }
}
