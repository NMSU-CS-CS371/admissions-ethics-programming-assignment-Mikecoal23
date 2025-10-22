// Admissions.java
// Contains the scoring models (Blind vs Aware).

public class Admissions {

    // Blind model (only academic/performance factors)
    public static double blindScore(Applicant app) {
        double score = 0.0;
        score += (app.gpa / 4.0) * 0.4;     // GPA normalized
        score += (app.test / 1600.0) * 0.3;  // Test score normalized
        score += app.extra * 0.1;
        score += app.essay * 0.1;
        score += app.rec * 0.1;
        return score; // final score between 0 and 1
    }

    // Aware model (adds equity and context)
    public static double awareScore(Applicant app) {
        double score = blindScore(app);

        if (app.income < 40000) score += 0.05;     // low-income boost
        if (app.firstGen) score += 0.05;           // first-generation bonus
        if (app.disability) score += 0.03;         // accessibility consideration
        if (app.legacy) score += 0.02;             // legacy advantage
        if (app.local) score += 0.03;              // local preference
        return Math.min(score, 1.0);               // cap score at 1.0
    }

    // MY CUSTOM MODEL
    public static double myScore(Applicant app) {
        double score = 0.0;
        
        score += (app.gpa / 4.0) * 0.35;      // GPA weight (currently 35%)
        score += (app.test / 1600.0) * 0.30;  // Test score weight (currently 25%)
        score += app.extra * 0.10;             // Extracurriculars weight (currently 15%)
        score += app.essay * 0.10;             // Essay quality weight (currently 15%)
        score += app.rec * 0.15;               // Recommendation weight (currently 10%)
        
        if (app.income < 60000) score += 0.05;     // low-income consideration

        if (app.firstGen) score += 0.05;           // first-generation consideration

        if (app.disability) score += 0.03;         // disability consideration
                
        return Math.min(score, 1.0);  // cap score at 1.0
    }
}