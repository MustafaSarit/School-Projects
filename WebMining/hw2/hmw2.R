#  Lecture 2 – HOMEWORK
#
#  GROUP MEMBERS:         
#------------------------------------------------------------------------------------------------------------- 
#
#  NOT NOT NOT: Cevaplarinizi .R uzantili attachment halinde YOLLA-MAYIN, normal bir mesaj yollarcasina, 
#  bana atacaginiz temiz bir mesaj kutusunun icine duz yazi gibi, kopyala yapistirla yerlestirip yollarsaniz sevinirim. 
#  cunku R uzantili her dosyayi yukleyerek acmam gerekiyor..
#-------------------------------------------------------------------------------------------------------------#
#  •	If you like, you can go to: http://tutorials.iq.harvard.edu/R/Rintro/Rintro.html and find similar examples there. 
#     This page is very helpful for your homework.
#  •	There are some examples and information there. You can try them in R just to have fun 
#  •	Our homework is about the households! I would like to know about those households in detail. 
#     In the course of answering this question we will learn to call R functions, install and load packages, 
#     assign values to names, read and write data, and more.
#  •	Our first goal is to read the data into R. In order to do that we need to learn how to call functions, 
#     set out working directory, read as .csv file, and assign the result to a name. Lets get to it.
#-------------------------------------------------------------------------------------------------------------

# HERE ARE YOUR QUESTIONS 
# Please DON'T delete the questions. Just write down your codes in between.
#-------------------------------------------------------------------------------------------------------------
# 1.	First, set your working directory 


# 2.	Go to piazza and download the  hmw2.csv file in your working directory. 
#     You should call it from R and save it as a new data frame called “hmw2” like:
#   hmw2 <- read_csv (…)


# 3.	Create a new column called “total_income” and in that column, 
#     you should calculate the total income of each household.


# 4.	Count the number of households, who does not have any internet.


# 5.	Filter the data to extract only the ones whose total income is 0. 
#     Call the filtered data as a new data frame, called “no_income”


# 6.	Find the mean number of children of those “no_income” households.


# 7.	Using the table() function, tabulate counts of “number_children”, then convert it to proportions.


# 8.	Using by()  function, calculate or show the total income separately for each level of “number_children” variable.


# 9.	Use the subset() function and subset rows from the dataset in which the age_husband is greater than age_wife.


# … And.. something harder …
# 10.	Create a scatter plot for age of wife and age of husband. Calculate their correlation.


# 11.	 Plot the histogram for the number of children

setwd('C:/Users/Mustafa/Desktop/WebMining/hw2') #Q1
hmw2 = read.csv("C:/Users/Mustafa/Desktop/WebMining/hw2/hmw2_a.csv")  #Q2
hmw2["total_income"] <-hmw2$income_husband + hmw2$income_wife   #Q3
row_noInternet = nrow(hmw2[hmw2$internet == "no"])  #Q4
no_income <- hmw2[hmw2$total_income == 0,]   #Q5
meanOfChilNoIncome = mean(no_income$number_children) #Q6
prop.table(table(no_income$number_children)) * 100   #Q7
#by(hmw2, nrow(hmw2), summary)                Q8 I didn't get the question
subset(hmw2, hmw2$age_husband>hmw2$age_wife)  #Q9
plot(hmw2$age_husband, hmw2$age_wife) #Q10
cor(hmw2[,c("age_husband", "age_wife")])  #Q11
