# NameScoringAlgorithm

1. Name Scoring Utility is a utility tool to calculate score of each name from a give file and then aggregate all scores into total score. If file is invalid or path does not exists, program returns -1
2. Run the utility program from the project directory with below mvn command ( please make sure you have maven is installed and its in classpath
    mvn compile exec:java -Dexec.mainClass="com.occ.scoring.ScoreNames" -Dexec.args="src\main\resources\names.txt"
3. This project is capable of taking different kind of sorting and scoring algorithms
4. Create custom algorithms by implementing ScoringAlgorithm and SortingAlgorithm as per needs
5. Refer NameScoringControllerTest for JUnit test cases 
6. Create and refer java docs for more information on each class in this project

Below are the assumptions:

1. If file contains duplicate Names, they will have different positions (sequential) and score will differ
2. Scoring would be calculated only for character a-z and A-Z. All other characters will be ignored
3. Names will always start with alphabets
4. File path and delimiter will be provided as input to utility. If no delimiter is provided, default delimiter will be considered
5. In the case of file does not exists or any exception happens this program would return -1 as total score


    
