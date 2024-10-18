package calculator;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    private final CalculatorModel calculatorModel;
    private final CalculatorView calculatorView;

    public Application(CalculatorModel calculatorModel, CalculatorView calculatorView) {
        this.calculatorModel = calculatorModel;
        this.calculatorView = calculatorView;
    }

    public void run() {
        ArrayList<String> separate = new ArrayList<>(Arrays.asList(",", ":"));
        String str = calculatorView.input();
        if (calculatorModel.CustomDiscrimination(str)) {
            separate.add(calculatorModel.CustomExtraction(str));
            calculatorView.output(calculatorModel.sumCalculator(str.substring(str.indexOf("\\n") + 2), separate));
        } else {
            calculatorView.output(calculatorModel.sumCalculator(str, separate));
        }
    }

    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorView calculatorView = new CalculatorView();
        Application app = new Application(calculatorModel, calculatorView);
        app.run();

    }
}
