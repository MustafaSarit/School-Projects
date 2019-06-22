# -----------------   MUGLA SITKI KOCMAN UNIVERSITESI BILGISAYAR MUHENDISLIGI BOLUMU  ---------

# NOTES:
# Please use "<-"  sign but not "=" to assign objects
# Please write as simple as possible
# You can write some explanation in words, as comments
# GOOD LUCK!

# ---------------------------------------------------------------------------------------------
# ------------------------------------  PART 1-  (ÖÇ-1) ---------------------------------------
# ---------------------------------------------------------------------------------------------

# 1. (5p) Set your working directory and then download and use libraries XML, httr, ggplot2
setwd("C:/Users/Mustafa/Desktop/WebMining/midterm")
install.packages("XML")
install.packages("httr")
install.packages("ggplot2")
install.packages("rvest")
library(XML)
library(httr)
library(ggplot2)
library(lubridate)
library('rvest')

# ---------------------------------------------------------------------------------------------
# 2. (10p) Go to: https://www.sahibinden.com/otomobil/mugla and then order the table 
#    according to date (newest first)
#    extract that data for the automobiles in Mugla (only the ones in the first page) 
#    Call the final data frame as: mugla_1
tables <- GET ("https://www.sahibinden.com/otomobil/mugla?sorting=date_desc")

mugla_1 <- readHTMLTable (rawToChar (tables$content), which=1 )

# ---------------------------------------------------------------------------------------------
# 3. (5p) Remove the unnecessary rows and columns in your data frame and call it mugla_2
mugla_2 <- mugla_1
mugla_2 <- mugla_2[,-1]#empty 1. column
mugla_2 <- mugla_2[,-8]#empty 8. column
mugla_2 <- mugla_2[-5,]#remove empty rows 4 and 5
mugla_2 <- mugla_2[-4,]
colnames(mugla_2) <- c("Ilan Basligi", "Yil", "KM", "Renk", "Fiyat", "Ilan Tarihi", "Ilce/Semt")



# ---------------------------------------------------------------------------------------------
# 4. (10p) Convert the variables into the correct format
# (numeric, integer, character, factor, ...) do not change the name "mugla_2"
mugla_2$`Ilan Basligi` <- as.character(mugla_2$`Ilan Basligi`)
mugla_2$KM <- gsub("\\.","",mugla_2$KM)
mugla_2$Fiyat <- gsub("\\.","",mugla_2$Fiyat)
mugla_2$Fiyat <- gsub("TL","",mugla_2$Fiyat)
mugla_2$Fiyat <- as.numeric(mugla_2$Fiyat)
mugla_2$`Ilan Tarihi` <- mdy(mugla_2$`Ilan Tarihi`)


# ---------------------------------------------------------------------------------------------
# 5. (10p) Now we are ready to write a function to scrap (extract) the remaining pages
#    Write a function which scraps and then combines the first 10 pages
#    Use Sys.sleep(2) here
#    Your data must be in correct format at the end (as your data in step 4)
#    Call this data frame as: mugla_10
mugla_10 <- data.frame()
for(i in 1:10){
  num = 0
  tables <- GET (paste("https://www.sahibinden.com/otomobil/mugla?pagingOffset=", num, "&sorting=date_desc", sep = ""))
  
  temp <- readHTMLTable (rawToChar (tables$content), which=1 )
  temp <- temp[,-1]#empty 1. column
  temp <- temp[,-8]#empty 8. column
  temp <- temp[-5,]#remove empty rows 4 and 5
  temp <- temp[-4,]
  colnames(temp) <- c("Ilan Basligi", "Yil", "KM", "Renk", "Fiyat", "Ilan Tarihi", "Ilce/Semt")
  temp$`Ilan Basligi` <- as.character(temp$`Ilan Basligi`)
  temp$KM <- gsub("\\.","",temp$KM)
  temp$Fiyat <- gsub("\\.","",temp$Fiyat)
  temp$Fiyat <- gsub("TL","",temp$Fiyat)
  temp$Fiyat <- as.numeric(temp$Fiyat)
  temp$`Ilan Tarihi` <- mdy(temp$`Ilan Tarihi`)
  mugla_10 <- rbind(mugla_10, temp)
  num = num + 20
  Sys.sleep(2)
  
}


# ---------------------------------------------------------------------------------------------
# 6. (10p) Draw a boxplot for mugla_10,
#    Keep the variable "Yıl" as a factor 
#    x axis is the last 10 years and y axis is the price of the automobiles

tenyear <- c(2019,2018,2017,2016,2015,2014,2013,2012,2011,2010,2009)
last_ten_years <- mugla_10[which(mugla_10$Yil>2009)]
ggplot(last_ten_years, eas(last_ten_years))

---------------------------------------------------------------------------------------------
# 7. (10p) Draw a barchart for mugla_10, where x axis is the colours of cars and 
#    y is the frequency (counts) of those cars.
     
         
ggplot(mugla_10, aes(x = mugla_10$Renk, y = ))
                

# ---------------------------------------------------------------------------------------------
# 8. (14p) If you can do this step, NO NEED to do 8_simple_version, 
#    if you can-not do 8, try 8_simple_version (half points)
#
#    Write a function which scraps the automobile table from ANY city that we require 
#    for the first 10 pages (again order them as the newest date first)
#    Use Sys.sleep(2) here
#    Name the function as: autocity10
#    Call the function you have created for the city "İzmir" and call your data as : city_izmir

autocity10 <- function(city){
  city10 <- data.frame()
  for(i in 1:10){
    num = 0
    tables <- GET (paste("https://www.sahibinden.com/otomobil/mugla",city,"?pagingOffset=", num, "&sorting=date_desc", sep = ""))
    
    temp <- readHTMLTable (rawToChar (tables$content), which=1 )
    temp <- temp[,-1]#empty 1. column
    temp <- temp[,-8]#empty 8. column
    temp <- temp[-5,]#remove empty rows 4 and 5
    temp <- temp[-4,]
    colnames(temp) <- c("Ilan Basligi", "Yil", "KM", "Renk", "Fiyat", "Ilan Tarihi", "Ilce/Semt")
    temp$`Ilan Basligi` <- as.character(temp$`Ilan Basligi`)
    temp$KM <- gsub("\\.","",temp$KM)
    temp$Fiyat <- gsub("\\.","",temp$Fiyat)
    temp$Fiyat <- gsub("TL","",temp$Fiyat)
    temp$Fiyat <- as.numeric(temp$Fiyat)
    temp$`Ilan Tarihi` <- mdy(temp$`Ilan Tarihi`)
    city10 <- rbind(city10, temp)
    num = num + 20
    Sys.sleep(2)
    
  }
}

city_izmir <- autocity10("izmir")


# 8. (7p) (simple_version) note: You don't need to do this step if you already did Question 8
#    Write a function which scraps the automobile table from any "CITY"  
#    that we require (again order them as the newest date first)
#    Use Sys.sleep(2) here
#    Call the name of the function as: autocity1

autocity1 <- function(...
                      
# ---------------------------------------------------------------------------------------------
# ------------------------------------  PART 2-  (ÖÇ-1) ---------------------------------------
# ---------------------------------------------------------------------------------------------

# 9. (14p) Go to the web page:
#    https://www.imdb.com/search/title?count=100&release_date=2018,2018&title_type=feature&page=1&ref_=adv_nxt
#    
#    Write a function which:
#    Takes the page number of weppage as an argument. (above you can see the first page as: page=1)
#    Uses CSS selectors to scrap these info about the filmS: Title, Genre, Rating
#    (Takes only the first genre of each movie)
#    Converts those data to text
#    Converts those text into a good format (factor, numeric, etc), if needed.
#    Removes excess spaces
#    Generates a final data called "movies_df"

grepMovies<-function(Num){
  
  
URL <- paste("https://www.imdb.com/search/title?count=100&release_date=2018,2018&title_type=feature&page=", Num, sep="")
webpage <- read_html(URL)
                       
#scrap title:
title_data_html <- html_nodes(webpage, ".lister-item-header a")
                                                     
title_data <- html_text(title_data_html)
                                                                             
                        
# scrap genre:
genre_data_html <- html_nodes(webpage, ".genre")

genre_data <- html_text(genre_data_html)
                                                                                
gsub(' [A-z ]*', '' , genre_data)
                                                                                                                                   
# format genre:
genre_data<-as.factor(genre_data)
                                                                                                                                   
#scrap ratings:
rating_data_html <- html_nodes(webpage, "strong")

rating_data <- html_text(rating_data_html)
                                                                                                                                                                                           
# format ratings:
rating_data<- as.numeric(rating_data)
                                                                                                                                                                                           
# Generate your dataframe:
movies_df<-data.frame( Title = title_data,
                       Genre = genre_data,
                       Rating = rating_data
                                                                                                                                                                                                                  
)

return(movies_df)
                                                                                                                                                                                           
}

# 10. (12p) Make this process for the first 50 pages
#     Finally present the data as a dataframe table

Num<-c(1:50)

dataset <- data.frame()

for(i in Num){
  temp <- grepMovies(i)
  dataset <- rbind(dataset, temp)
  print(paste("Completed Page ", Num, sep=""))
  Sys.sleep(2)
}

write.table(dataset)

qplot(data = dataset,Rating,fill = Genre,bins = 30)

#    GOOD LUCK!
