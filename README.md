Tests:

#1. MAIN PAGE

##1.1 Check number of hints after enter a letter in destination field
Steps:
* open main page https://www.booking.com/
* enter a letter in destination field

Expected result:
* five hints are shown

##1.2 Check sorting after specifying destination
Steps:
* open main page https://www.booking.com/
* enter letter by letter in destination field

Expected result:
* after each letter is added, the hints are updated and sorted by the entered letters

##1.3 Check search by city name, near dates, default number of people and rooms
Steps:
* open main page https://www.booking.com/
* fill the destination field with a name of a city, for example "Lisbon"
* fill Check in date that = T date + 10 days, current month
* fill Check out date that = T date + 15 days
* click search button

Expected result:
* a new page with search results is opened
* a title of the opened page = the name of the city you specifies




#SEARCH RESULT PAGE