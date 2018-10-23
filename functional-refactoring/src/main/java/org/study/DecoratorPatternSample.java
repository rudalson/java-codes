package org.study;

import java.util.function.Predicate;

class Applicant {
    public boolean isCredible() {
        return true;
    }

    public int getCreditScore() {
        return 700;
    }

    public int getEmploymentYears() {
        return 10;
    }

    public boolean hasCriminalRecord() {
        return true;
    }
}

interface Evaluator {
    boolean evaluate(Applicant applicant);
}

class QualifiedEvaluator implements Evaluator {
    public boolean evaluate(Applicant applicant) {
        return applicant.isCredible();
    }
}

class EvaluatorChain implements Evaluator {
    private Evaluator next;

    public EvaluatorChain(Evaluator nextEvaluator) {
        next = nextEvaluator;
    }

    public boolean evaluate(Applicant applicant) {
        return next.evaluate(applicant);
    }
}

class CreditEvaluator extends EvaluatorChain {
    public CreditEvaluator(Evaluator next) {
        super(next);
    }

    public boolean evaluate(Applicant applicant) {
        if (applicant.getCreditScore() > 600)
            return super.evaluate(applicant);

        return false;
    }
}

class EmploymentEvaluator extends EvaluatorChain {
    public EmploymentEvaluator(Evaluator next) {
        super(next);
    }

    public boolean evaluate(Applicant applicant) {
        if (applicant.getEmploymentYears() > 0)
            return super.evaluate(applicant);

        return false;
    }
}

class CriminalRecordsEvaluator extends EvaluatorChain {
    public CriminalRecordsEvaluator(Evaluator next) {
        super(next);
    }

    public boolean evaluate(Applicant applicant) {
        if (!applicant.hasCriminalRecord())
            return super.evaluate(applicant);

        return false;
    }
}

public class DecoratorPatternSample {

    public static void evaluateLegacy(Applicant applicant, Evaluator evaluator) {
        String result = evaluator.evaluate(applicant) ? "accepted" : "rejected";
        System.out.println("Result of evaluating applicant: " + result);
    }

    public static void evaluateLambda(Applicant applicant, Predicate<Applicant> evaluator) {
        String result = evaluator.test(applicant) ? "accepted" : "rejected";
        System.out.println("Result of evaluating applicant: " + result);
    }

    public static void codeLegacy(Applicant applicant) {
        evaluateLegacy(applicant,
                new CreditEvaluator(
                        new QualifiedEvaluator()));

        evaluateLegacy(applicant,
                new CreditEvaluator(
                        new EmploymentEvaluator(
                                new QualifiedEvaluator())));

        evaluateLegacy(applicant,
                new CriminalRecordsEvaluator(
                        new EmploymentEvaluator(
                                new QualifiedEvaluator())));

        evaluateLegacy(applicant,
                new CriminalRecordsEvaluator(
                        new CreditEvaluator(
                                new EmploymentEvaluator(
                                        new QualifiedEvaluator()))));
    }

    public static void codeLambda(Applicant applicant) {
        Predicate<Applicant> qualifiedEvaluator = Applicant::isCredible;
        Predicate<Applicant> creditEvaluator = anApplicant -> anApplicant.getCreditScore() > 600;
        Predicate<Applicant> employmentEvaluator = anApplicant -> anApplicant.getEmploymentYears() > 0;
        Predicate<Applicant> crimeCheck = anApplicant -> !anApplicant.hasCriminalRecord();

        // == evaluateLegacy(applicant, new CreditEvaluator(new QualifiedEvaluator()));
        evaluateLambda(applicant,
                qualifiedEvaluator.and(creditEvaluator));

        evaluateLambda(applicant,
                qualifiedEvaluator.and(creditEvaluator).and(employmentEvaluator)
        );

        evaluateLambda(applicant,
                qualifiedEvaluator.and(employmentEvaluator).and(crimeCheck)
        );

        evaluateLambda(applicant,
                qualifiedEvaluator.and(creditEvaluator).and(employmentEvaluator).and(crimeCheck)
        );
    }

    public static void main(String[] args) {
        Applicant applicant = new Applicant();

        codeLegacy(applicant);
        System.out.println();
        codeLambda(applicant);
    }
}
