library('rvest')
library('ggplot2')
library(stringr)
url <- 'https://www.amazon.com/s?i=computers-intl-ship&bbn=16225007011&rh=n%3A16225007011%2Cn%3A13896617011%2Cn%3A565108%2Cp_89%3AASUS%7CApple%2Cp_n_condition-type%3A2224371011%2Cp_n_feature_eleven_browse-bin%3A9521903011&dc&fst=as%3Aoff&qid=1553695341&rnid=9521902011&ref=sr_pg_1'
webpage <- read_html(url)

#Brand data
brand_data_html <- html_nodes(webpage,'.s-line-clamp-2')
brand_data <- html_text(brand_data_html)
brand_data = str_extract(brand_data, "ASUS") #There are only asus computers in the webpage
head(brand_data)
brand_data
#.a-price[data-a-size="l"] .a-offscreen

#Price data
#There were problems in price section so i manipulated the data
price_data_html <- html_nodes(webpage,'.a-spacing-top-small .a-price:nth-child(1) .a-price-fraction , .a-spacing-top-small .a-price:nth-child(1) .a-price-whole')
price_data <- html_text(price_data_html)
price_data
i = 1
j = 1
while(i < 32){   #this loop concatenate prices with fractions
  price_data[j] = paste(price_data[i], price_data[i+1], sep = "")
  i = i + 2
  j = j + 1
}
price_data = price_data[1:16]   #after concatination i remove unnecessary items from vector
price_data
price_data <- gsub(",","", price_data)  #remove comma separator 
price_data = as.numeric(price_data)

#Creating data frame
notebooks_df<-data.frame(Brand = brand_data, Price = price_data)
str(notebooks_df)


#comparison plotting
qplot(data = notebooks_df, Price, fill = Brand, bins = 50)
