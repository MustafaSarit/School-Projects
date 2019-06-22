library("tidyr", lib.loc="~/R/win-library/3.5")
library("tidyverse", lib.loc="~/R/win-library/3.5")
library("tidyselect", lib.loc="~/R/win-library/3.5")
library("readr", lib.loc="~/R/win-library/3.5")



baby.names <- read.csv("C:/Users/Mustafa/Desktop/WebMining/dataSets/babyNames.csv")
am <- filter(baby.names, 
             Year == 1996 & (Name == "Mustafa" | Name == "Mark"))
am
arrange(am, Count)
arrange(am, desc(Count))
george <- filter(baby.names, Name == "George")
arrange(george, desc(Count))


