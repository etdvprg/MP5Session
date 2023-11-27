package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuestionBank extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext context = config.getServletContext();

        QuizManager quizManager = (QuizManager) context.getAttribute("quizManager");
        if (quizManager == null) {
            quizManager = new QuizManager();
            initializeQuestions(quizManager);
            context.setAttribute("quizManager", quizManager);
        }
    }

    private void initializeQuestions(QuizManager quizManager) {
        quizManager.addQuestion("Which country neighbors Kazakhstan to the north?", Arrays.asList("Russia", "Tajikistan", "China", "Mongolia"), 0, Difficulty.EASY);
        quizManager.addQuestion("When did World War I begin?", Arrays.asList("1908", "1912", "1914", "1925"), 2, Difficulty.EASY);
        quizManager.addQuestion("What is the capital city of Iceland?", Arrays.asList("Oslo", "Reykjavik", "Stockholm", "Nuuk"), 1, Difficulty.EASY);
        quizManager.addQuestion("Who is the first president of the Philippines?", Arrays.asList("Quezon", "Bonifacio", "Aguinaldo", "Macapagal"), 2, Difficulty.EASY);
        quizManager.addQuestion("Ohio of the Philippines?", Arrays.asList("Cavite", "Bulacan", "Rizal", "Laguna"), 0, Difficulty.EASY);
        quizManager.addQuestion("What is the Philippine province closest to Taiwan?", Arrays.asList("Rizal", "Basilan", "Batanes", "Cagayan"), 2, Difficulty.EASY);
        quizManager.addQuestion("Long-lived empire in world history", Arrays.asList("Incan Empire", "Roman Empire", "British Empire", "Ottoman Empire"), 1, Difficulty.EASY);
        quizManager.addQuestion("What country lies below North Korea?", Arrays.asList("Japan", "South Korea", "Russia", "China"), 1, Difficulty.EASY);
        quizManager.addQuestion("What is the river that flows through the Brazilian rainforest?", Arrays.asList("Yangtze", "Congo", "Nile", "Amazon"), 3, Difficulty.EASY);
        quizManager.addQuestion("Summer Capital of the Philippines", Arrays.asList("Sagada", "Tagaytay City", "Baguio City", "Atok"), 2, Difficulty.EASY);

        quizManager.addQuestion("Oldest city in the Philippines", Arrays.asList("Manila", "Cebu", "Davao", "Iloilo"), 1, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Third largest ocean in the world", Arrays.asList("Atlantic", "Pacific", "Southern", "Indian"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country had a war against Emu(s)?", Arrays.asList("Tonga", "Australia", "New Zealand", "Papua New Guinea"), 1, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country has the most valuable currency in the world?", Arrays.asList("Bahrain", "Zimbabwe", "Kuwait", "Jordan"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country had a potato famine?", Arrays.asList("England", "Scotland", "Ireland", "Wales"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which is not a country in the Middle East?", Arrays.asList("Saudi Arabia", "Dubai", "Jordan", "Iran"), 1, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country has the most islands?", Arrays.asList("Greenland", "the Philippines", "Norway", "Sweden"), 1, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Richest barangay in the Philippines", Arrays.asList("Fort Bonifacio, Taguig", "Ayala Alabang, Muntinlupa", "Forbes Village, Makati", "Bel-Air, Makati"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country hosts the largest carnival in the world?", Arrays.asList("Mexico", "Jamaica", "Cuba", "Brazil"), 3, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Largest capital city in North America", Arrays.asList("Ottawa", "Washington D.C.", "Mexico", "Santiago"), 2, Difficulty.INTERMEDIATE);

        quizManager.addQuestion("These island groups represent the stars on the Philippine flag, except:", Arrays.asList("Luzon", "Visayas", "Mindanao", "Panay"), 3, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which country will you find the “Spanish Steps”", Arrays.asList("Spain", "Portugal", "Italy", "France"), 2, Difficulty.DIFFICULT);
        quizManager.addQuestion("What is the national language of Eritrea?", Arrays.asList("English", "Tigrinya", "Arabic", "None"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which African country has the most pyramids?", Arrays.asList("Egypt", "Sudan", "Libya", "Saudi Arabia"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("What country owns the country code top-level domain, .za?", Arrays.asList("Zimbabwe", "South Africa", "Zambia", "South Sudan"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("In which sea would you find the islands of Corsica and Sardinia?", Arrays.asList("Adriatic Sea", "Red Sea", "Tyrrhenian Sea", "Ionian Sea"), 2, Difficulty.DIFFICULT);
        quizManager.addQuestion("Capital city of the province of Quirino", Arrays.asList("Cabarroguis", "Bayambang", "Bayombong", "Dingalan"), 0, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which country has the oldest parliament in the world?", Arrays.asList("United Kingdom", "Iceland", "Ireland", "France"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which countries were signatories in the Treaty of Tordesillas in 1494?", Arrays.asList("Spain and France", "Spain and Portugal", "Portugal and England", "France and England"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which region in the Philippines did the Hukbalahap Rebellion take place?", Arrays.asList("Ilocos Region", "CALABARZON", "Central Luzon", "Bicol Region"), 2, Difficulty.DIFFICULT);
    }
}
