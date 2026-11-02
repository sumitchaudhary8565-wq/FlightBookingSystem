# FlightBookingSystem

About the Project :
This is a simple Flight Booking System made using Java.

The program runs in the console. A user can register, log in, search for
flights, book a ticket, check their bookings and cancel a booking.

Features in this Project :
- User registration: Create an account with a username and
  password.
  
- User login: Log in using the registered username and password.
  
- Search flights: Search using source city, destination city and
  travel date.
  
- Book a flight: Enter passenger details and select a payment
  method.
  
- Ticket display: Show booking ID, passenger details, flight
  details and booking status.
  
- View bookings: Display all bookings made by the logged-in user.
  
- Cancel booking: Cancel an active booking using its booking ID.
  
- Seat update: The available seat count decreases after a
  successful booking.
  
Technologies Used :

- Java
- ArrayList for storing data dynamically flights, users and bookings.
- Scanner for taking input from the user.
- LocalDate for handling travel dates.
  
How to Run :

1. Keep FlightBookingSystem.java in a folder.
2. Open a terminal or command prompt in that folder.
3. Compile the program:
   javac FlightBookingSystem.java
4. Run the program:
   java FlightBookingSystem
How to Use :

1. Select Register from the main menu and write your username and
   password.
2. Select Login and enter your username and password as you written already.
3. After login,there will appear four options 1.Search Flights 2.View My Bookings 3.Cancel Booking 4.Logout.
4.  choose Search Flights.
5. Enter the source city, destination city and travel date in
   YYYY-MM-DD format.
6. Select a flight by entering its flight number.
7. Enter the passenger details and choose a payment method.
8. The program displays the ticket after a successful booking.
9. Use View My Bookings to see your bookings or Cancel Booking
   to cancel an active booking.
10. Select Logout when finished.

Sample Flight Data :
Some sample flights have been added which will have date according to when the program runs,
it is for demo run.

Limitations :
- This is a console-based academic project, not a real airline booking
  website.
- Flight and user information is stored in ArrayList objects, so the
  data is not saved permanently. It is lost when the program closes.
- The payment options are for showcasing only. No real payment is
  processed.
- The program starts with sample flight data; it does not connect to
  an airline or live flight service.

Conclusion
This project helped me understand how different Java classes can work
together to make a small application. It is a basic implementation of a
flight booking system and can be improved in the future .
