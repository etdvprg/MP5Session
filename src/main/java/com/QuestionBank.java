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
        quizManager.addQuestion("In which civilization did the first Olympic games take place?", Arrays.asList("Ancient Greece", "Ancient Rome", "Ancient Egypt", "Ancient Mesopotamia"), 0, Difficulty.EASY);
        quizManager.addQuestion("When did the bombing of Pearl Harbor happen?", Arrays.asList("January 1941", "December 1941", "March 1942", "February 1946"), 1, Difficulty.EASY);
        quizManager.addQuestion("Who was the founder of the Mongol Empire?", Arrays.asList("Chingis Khan", "Genghis Khan", "Shah Rukh Khan", "Hublai Khan"), 1, Difficulty.EASY);
        quizManager.addQuestion("Who is known as the 'Grand Woman of the Revolution' in Philippine history?", Arrays.asList("Melchora Aquino", "Cory Aquino", "Teresa Magbanua", "Gregoria de Jesus"), 0, Difficulty.EASY);
        quizManager.addQuestion("Which city in Metropolitan Manila was not formerly part of the province of Rizal?", Arrays.asList("Pasig", "Taguig", "Valenzuela", "Malabon"), 2, Difficulty.EASY);
        quizManager.addQuestion("Which ancient figure is typically thought of as the 'father' of Western philosophy?", Arrays.asList("Diogenes", "Aristotle", "Plato", "Socrates"), 3, Difficulty.EASY);
        quizManager.addQuestion("Which country was not part of Yugoslavia?", Arrays.asList("Croatia", "Serbia", "Macedonia", "Albania"), 3, Difficulty.EASY);
        quizManager.addQuestion("What is the capital of Kazakhastan?", Arrays.asList("Bishkek", "Astana", "Almaty", "Tashkent"), 1, Difficulty.EASY);
        quizManager.addQuestion("What is the Terracotta Army made from?", Arrays.asList("Stone", "Clay", "Wood", "Straw"), 1, Difficulty.EASY);
        quizManager.addQuestion("What was the first name given to the University of Santo Tomas?", Arrays.asList("Colegio de Sta. Rosa", "Colegio de Santo Tomas", "Colegio de la Nuestra Virgen", "Colegio de Nuestra Señora del Santisimo Rosario"), 3, Difficulty.EASY);

        
        quizManager.addQuestion("Oldest city in the Philippines", Arrays.asList("Manila", "Cebu", "Davao", "Iloilo"), 1, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Where did Napoleon's final defeat happen?", Arrays.asList("Marengo", "Trafalgar", "Waterloo", "Borodino"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("What country occupies the largest area of the Sahara?", Arrays.asList("Libya", "Morocco", "Mauritania", "Algeria"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Who is known as 'The Liberator of Latin America'?", Arrays.asList("Simon Bolivar", "Pedro II", "Augusto Pinochet", "Fidel Castro"), 0, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("In which year, did the Bataan Death March happen in the Philippines?", Arrays.asList("1939", "1942", "1946", "1949"), 1, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("What acquisition of territory by the United States from France occurred in 1803?", Arrays.asList("Texan Acquisition", "Florida Purchase", "Louisiana Purchase", "Mississippi Acquisition"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("How many years did the 100 Years War last?", Arrays.asList("99", "100", "108", "116"), 3, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("What was the first capital of ancient Egypt?", Arrays.asList("Cairo", "Alexandria", "Memphis", "Luxor"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Third largest ocean in the world", Arrays.asList("Atlantic", "Pacific", "Southern", "Indian"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country had a war against Emu(s)?", Arrays.asList("Tonga", "Australia", "New Zealand", "Papua New Guinea"), 1, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country has the most valuable currency in the world?", Arrays.asList("Bahrain", "Zimbabwe", "Kuwait", "Jordan"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country had a potato famine?", Arrays.asList("England", "Scotland", "Ireland", "Wales"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which is not a country in the Middle East?", Arrays.asList("Saudi Arabia", "Dubai", "Jordan", "Iran"), 1, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country has the most islands?", Arrays.asList("Greenland", "the Philippines", "Norway", "Sweden"), 3, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Richest barangay in the Philippines", Arrays.asList("Fort Bonifacio, Taguig", "Ayala Alabang, Muntinlupa", "Forbes Village, Makati", "Bel-Air, Makati"), 3, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country hosts the largest carnival in the world?", Arrays.asList("Mexico", "Jamaica", "Cuba", "Brazil"), 3, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Largest capital city in North America", Arrays.asList("Ottawa", "Washington D.C.", "Mexico", "Santiago"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country will you find the “Spanish Steps”?", Arrays.asList("Spain", "Portugal", "Italy", "France"), 2, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Who invented the Printing Press?", Arrays.asList("Gutenberg", "Bell", "Coster", "Castaldi"), 0, Difficulty.INTERMEDIATE);
        quizManager.addQuestion("Which country has a bear that served in its military in World War II? ", Arrays.asList("Nazi Germany", "Soviet Union", "Poland", "Czechoslovakia"), 2, Difficulty.INTERMEDIATE);

        
        quizManager.addQuestion("First city in the Philippines that developed the system of color-coded jeepneys", Arrays.asList("Olongapo", "Tacloban", "Angeles", "Dagupan"), 0, Difficulty.DIFFICULT);
        quizManager.addQuestion("Second president under the Commonwealth era of the Philippines", Arrays.asList("Roxas", "Quezon", "Quirino", "Osmeña"), 0, Difficulty.DIFFICULT);
        quizManager.addQuestion("These island groups represent the stars on the Philippine flag, except:", Arrays.asList("Luzon", "Visayas", "Mindanao", "Panay"), 2, Difficulty.DIFFICULT);
        quizManager.addQuestion("What did The First Philippine Republic came to be called?", Arrays.asList("Malolos Republic", "Biak-na-Bato Republic", "Sakay Republic", "Luzon Republic"), 0, Difficulty.DIFFICULT);
        quizManager.addQuestion("Tenochtitlan was the capital, of which ancient society?", Arrays.asList("Inca", "Aztec", "Maya", "Olmec"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which African country has the most pyramids?", Arrays.asList("Egypt", "Sudan", "Libya", "Saudi Arabia"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("What country owns the country code top-level domain, .za?", Arrays.asList("Zimbabwe", "South Africa", "Zambia", "South Sudan"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("In which sea would you find the islands of Corsica and Sardinia?", Arrays.asList("Adriatic Sea", "Red Sea", "Tyrrhenian Sea", "Ionian Sea"), 2, Difficulty.DIFFICULT);
        quizManager.addQuestion("Capital city of the province of Quirino", Arrays.asList("Cabarroguis", "Bayambang", "Bayombong", "Dingalan"), 0, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which country has the oldest parliament in the world?", Arrays.asList("United Kingdom", "Iceland", "Ireland", "France"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which countries were signatories in the Treaty of Tordesillas in 1494?", Arrays.asList("Spain and France", "Spain and Portugal", "Portugal and England", "France and England"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which region in the Philippines did the Hukbalahap Rebellion take place?", Arrays.asList("Ilocos Region", "CALABARZON", "Central Luzon", "Bicol Region"), 2, Difficulty.DIFFICULT);
        quizManager.addQuestion("What is the name of the earliest known culture that existed on the island of Japan?", Arrays.asList("Yayoi", "Ainu", "Jomon", "Uji"), 2, Difficulty.DIFFICULT);
        quizManager.addQuestion("Who is known as the 'Man of Blood and Iron'?", Arrays.asList("Napoleon", "Ho Chi Minh", "Bismarck", "Hitler"), 2, Difficulty.DIFFICULT);
        quizManager.addQuestion("During the trans-Atlantic slave trade, which country hosted the highest number of enslaved individuals?", Arrays.asList("Dominican Republic", "United States", "Belize", "Brazil"), 3, Difficulty.DIFFICULT);
        quizManager.addQuestion("Who is known as the 'Father of Algebra'?", Arrays.asList("Euclid", "Pythagoras", "Diopanthus", "Al-Khwarizmi"), 3, Difficulty.DIFFICULT);
        quizManager.addQuestion("Who is often referred to as 'The Black Napoleon' and played a pivotal role in the Haitian Revolution?", Arrays.asList("François-Dominique Toussaint", "Toussaint L'Ouverture", "Henri Christophe", "Jean-Jacques Dessalines"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which Central American country experienced a civil war that lasted from 1979 to 1992, involving conflicts between the government forces and leftist rebels, with significant involvement from the United States and the Soviet Union?", Arrays.asList("Nicaragua", "Guatemala", "El Salvador", "Honduras"), 2, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which European political figure is not a descendant of Queen Victoria?", Arrays.asList("Kaiser Wilhelm II", "Franz Josef I", "King Felipe VI", "King George V"), 1, Difficulty.DIFFICULT);
        quizManager.addQuestion("Which language did not derive from Latin?", Arrays.asList("Romanian", "Basque", "Dalmatian", "Occitan"), 1, Difficulty.DIFFICULT);

    } 
}
