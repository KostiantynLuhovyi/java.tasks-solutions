package com.lugowoy.tasks.writeProgramUsingBernoulliScheme;

import com.lugowoy.helper.other.GeneratorRandomNumber;

/**
 * Created by Konstantin Lugowoy on 16.11.2017.
 */

public class SchemeBernoulli {

    private static final int MIN_BOUND = -5;
    private static final int MAX_BOUND = 5;

    private int numberOfTests;
    private double valueOfSuccess;

    private boolean[] resultOfTest;

    private int countOfSuccess;
    private int countOfFailure;

    public void setParamToScheme(int numberOfTests, double valueOfSuccess) {
        this.setNumberOfTests(numberOfTests);
        this.setValueOfSuccess(valueOfSuccess);
    }

    private void setValueOfSuccess(double valueOfSuccess) {
        if (valueOfSuccess >= MIN_BOUND && valueOfSuccess <= MAX_BOUND) {
            this.valueOfSuccess = valueOfSuccess;
        } else {
            throw new IllegalArgumentException("The value for determining the result was entered incorrectly.");
        }
    }

    private void setNumberOfTests(int numberOfTests) {
        if (numberOfTests >= 0) {
            this.numberOfTests = numberOfTests;
        } else {
            throw new IllegalArgumentException("The number of tests can not be negative.");
        }
    }

    public void testing() {
        this.resultOfTest = new boolean[this.numberOfTests];
        for (int i = 0; i < numberOfTests; i++) {
            this.resultOfTest[i] = GeneratorRandomNumber.generateDouble(MIN_BOUND, MAX_BOUND) <= this.valueOfSuccess;
        }
    }

    private int getCountOfSuccess() {
        for (boolean resultOfTest : this.resultOfTest) {
            if (resultOfTest) {
                this.countOfSuccess++;
            }
        }
        return this.countOfSuccess;
    }

    private int getCountOfFailure() {
        for (boolean resultOfTest : this.resultOfTest) {
            if (!resultOfTest) {
                this.countOfFailure++;
            }
        }
        return this.countOfFailure;
    }

    public void showResult() {
        System.out.println("Statistics of the performance of tests using the Bernoulli scheme.");
        System.out.println("Number of tests : " + this.numberOfTests);
        System.out.println("Value for determining the success of the test : " + this.valueOfSuccess);
        System.out.println("Success : " + getCountOfSuccess());
        System.out.println("Failure : " + getCountOfFailure());
        System.out.println("Mathematical expectation : " + this.numberOfTests * this.valueOfSuccess);
        System.out.println("Standard deviation : " + Math.sqrt(this.numberOfTests * this.valueOfSuccess * (1 - this.valueOfSuccess)));
    }

}
