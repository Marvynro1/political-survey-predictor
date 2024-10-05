# Political Party Affiliation Predictor Survey

## Overview
This program is a simple political survey Java application designed to predict a respondent's political party affiliation. It supports four political parties: Republican, Democrat, Independent, and Libertarian. The prediction is made based on the user’s responses to a series of 10 questions, utilizing Bayes' theorem to calculate the likelihood of each party affiliation.

## How it Works
The program asks the user a series of 10 questions, each with four possible answers. Based on the user's responses, it calculates the likelihood of the user being affiliated with each of the four political parties. The party with the highest likelihood is then presented as the predicted party affiliation.

The likelihood calculations are based on a dataset of survey responses for each political party, stored in text files (`republicanResponses.txt`, `democratResponses.txt`, `independentResponses.txt`, `libertarianResponses.txt`). Each line in these files represents a set of responses to the survey questions.

## Prerequisites
- Java 8 or later
- Git (for version control and pushing to a GitLab repository)

## Setup
1. Clone the repository:

`git clone https://gitlab.com/username/political-party-affiliation-predictor-survey.git`

2. Navigate to the project directory:

`cd political-party-affiliation-predictor-survey`

3. Make sure you have the Java Development Kit (JDK) installed.

## Running the Program
1. Compile the Java code:

`javac PoliticalSurvey.java`

2. Run the compiled Java program:

`java PoliticalSurvey`

3. Answer the survey questions as prompted.

4. View the predicted political party affiliation at the end.
