package com.example;

public class SimpleValidator {

    public String validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Umur tidak boleh negatif");
        }
        if (age < 18) {
            return "Belum Dewasa";
        } else if (age <= 65) {
            return "Dewasa";
        } else {
            return "Lansia";
        }
    }

    public double calculateDiscount(int totalBelanja, boolean member) {
        if (totalBelanja < 0) {
            throw new IllegalArgumentException("Total belanja tidak boleh negatif");
        }

        double diskon = 0;

        if (member && totalBelanja >= 100000) {
            diskon = 0.10;
        } else if (totalBelanja >= 50000) {
            diskon = 0.05;
        }

        return totalBelanja * diskon;
    }

    public String classifyGrade(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Nilai harus berada di rentang 0-100");
        }

        if (score >= 90) {
            return "A";
        } else if (score >= 75) {
            return "B";
        } else if (score >= 60) {
            return "C";
        } else if (score >= 40) {
            return "D";
        } else {
            return "E";
        }
    }
}
