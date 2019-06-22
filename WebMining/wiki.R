library("XML", lib.loc="~/R/win-library/3.5")
library("httr", lib.loc="~/R/win-library/3.5")

table = GET("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population")
poptable = readHTMLTable(rawToChar(table$content), which = 1, skip.rows = 1)
poptable

options(digits = 2)
str(poptable)
colnames(poptable)<-c("Rank","Country","Population","Date","Percentage","Source")
poptable[,5] = gsub("%", "", poptable[,5])
poptable[,5] = as.numeric(poptable[,5])
mean(poptable$Percentage)
str(poptable$Population)
