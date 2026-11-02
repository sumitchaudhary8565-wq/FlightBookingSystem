import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

class Booking {
    private static int nextBookingId = 1001;

    private int bookingId;
    private Flight flight;
    private Passenger passenger;
    private String paymentMethod;
    private String paymentStatus;
    private boolean active;

    public Booking(Flight flight, Passenger passenger, String paymentMethod) {
        this.bookingId = nextBookingId++;
        this.flight = flight;
        this.passenger = passenger;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "Successful (Demo)";
        this.active = true;
    }

    public int getBookingId() { return bookingId; }
    public boolean isActive() { return active; }
    public void cancel() { active = false; }

    public void displayTicket() {
        System.out.println("\n========== FLIGHT TICKET ==========");
        System.out.println("Booking ID    : " + bookingId);
        System.out.println("Passenger     : " + passenger.getName());
        System.out.println("Age / Gender  : " + passenger.getAge() + " / " + passenger.getGender());
        System.out.println("Phone         : " + passenger.getPhone());
        System.out.println("Airline       : " + flight.getAirline());
        System.out.println("Flight Number : " + flight.getFlightNumber());
        System.out.println("From          : " + flight.getSource());
        System.out.println("To            : " + flight.getDestination());
        System.out.println("Date          : " + flight.getDate());
        System.out.println("Departure     : " + flight.getDepartureTime());
        System.out.println("Amount        : Rs. " + flight.getPrice());
        System.out.println("Payment       : " + paymentMethod);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Booking Status: " + (active ? "CONFIRMED" : "CANCELLED"));
        System.out.println("===================================\n");
    }
}

class Flight {
    private int flightNumber;
    private String airline;
    private String source;
    private String destination;
    private LocalDate date;
    private String departureTime;
    private double price;
    private int availableSeats;

    public Flight(int flightNumber, String airline, String source, String destination,
                  LocalDate date, String departureTime, double price, int availableSeats) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.departureTime = departureTime;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public int getFlightNumber() { return flightNumber; }
    public String getAirline() { return airline; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public LocalDate getDate() { return date; }
    public String getDepartureTime() { return departureTime; }
    public double getPrice() { return price; }
    public int getAvailableSeats() { return availableSeats; }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void displayFlight() {
        System.out.println("----------------------------------------");
        System.out.println("Flight Number : " + flightNumber);
        System.out.println("Airline       : " + airline);
        System.out.println("Route         : " + source + " to " + destination);
        System.out.println("Date          : " + date);
        System.out.println("Departure     : " + departureTime);
        System.out.println("Price         : Rs. " + price);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("----------------------------------------");
    }
}

class Passenger {
    private String name;
    private int age;
    private String gender;
    private String phone;

    public Passenger(String name, int age, String gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getPhone() { return phone; }
}

 class User {
    private String username;
    private String password;
    private ArrayList<Booking> bookings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        bookings = new ArrayList<Booking>();
    }

    public String getUsername() { return username; }

    public boolean checkPassword(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }
}

public class FlightBookingSystem {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Flight> flights = new ArrayList<Flight>();
    private static ArrayList<User> users = new ArrayList<User>();
    private static User loggedInUser = null;

    public static void main(String[] args) {
        addSampleFlights();

        System.out.println("FLIGHT BOOKING SYSTEM");

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = readInt();

            if (choice == 1) {
                register();
            } else if (choice == 2) {
                if (login()) {
                    userMenu();
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using Flight Booking System!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    private static void addSampleFlights() {
        LocalDate day1 = LocalDate.now().plusDays(1);
        LocalDate day2 = LocalDate.now().plusDays(2);
        LocalDate day3 = LocalDate.now().plusDays(3);

        flights.add(new Flight(101, "IndiGo", "Delhi", "Mumbai", day1, "09:30 AM", 4500, 25));
        flights.add(new Flight(102, "Air India", "Delhi", "Bengaluru", day1, "01:15 PM", 6200, 18));
        flights.add(new Flight(103, "Vistara", "Mumbai", "Chennai", day2, "11:00 AM", 5100, 20));
        flights.add(new Flight(104, "IndiGo", "Delhi", "Mumbai", day3, "06:45 PM", 4700, 30));
        flights.add(new Flight(105, "Air India", "Bengaluru", "Delhi", day2, "08:00 AM", 5900, 15));
    }

    private static void register() {
        System.out.println("\n--- User Registration ---");
        System.out.print("Choose username: ");
        String username = sc.nextLine().trim();

        if (username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }

        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Username already exists.");
                return;
            }
        }

        System.out.print("Choose password: ");
        String password = sc.nextLine();

        if (password.isEmpty()) {
            System.out.println("Password cannot be empty.");
            return;
        }

        users.add(new User(username, password));
        System.out.println("Registration successful. You can now login.");
    }

    private static boolean login() {
        System.out.println("\n--- User Login ---");
        System.out.print("Username: ");
        String username = sc.nextLine().trim();
        System.out.print("Password: ");
        String password = sc.nextLine();

        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)
                    && user.checkPassword(password)) {
                loggedInUser = user;
                System.out.println("Login successful. Welcome, " + username + "!");
                return true;
            }
        }

        System.out.println("Incorrect username or password.");
        return false;
    }

    private static void userMenu() {
        while (loggedInUser != null) {
            System.out.println("\n========== USER MENU ==========");
            System.out.println("1. Search Flights");
            System.out.println("2. View My Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = readInt();

            if (choice == 1) {
                searchFlights();
            } else if (choice == 2) {
                viewBookings();
            } else if (choice == 3) {
                cancelBooking();
            } else if (choice == 4) {
                loggedInUser = null;
                System.out.println("You have been logged out.");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void searchFlights() {
        System.out.println("\n--- Search Flights ---");
        System.out.print("Enter source city: ");
        String source = sc.nextLine().trim();
        System.out.print("Enter destination city: ");
        String destination = sc.nextLine().trim();
        System.out.print("Enter travel date (YYYY-MM-DD): ");
        String dateText = sc.nextLine().trim();

        LocalDate date;
        try {
            date = LocalDate.parse(dateText);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date. Please use YYYY-MM-DD.");
            return;
        }

        ArrayList<Flight> foundFlights = new ArrayList<Flight>();

        for (Flight flight : flights) {
            if (flight.getSource().equalsIgnoreCase(source)
                    && flight.getDestination().equalsIgnoreCase(destination)
                    && flight.getDate().equals(date)
                    && flight.getAvailableSeats() > 0) {
                foundFlights.add(flight);
            }
        }

        if (foundFlights.size() == 0) {
            System.out.println("Sorry, no available flights found for this search.");
            return;
        }

        System.out.println("\nAvailable Flights:");
        for (Flight flight : foundFlights) {
            flight.displayFlight();
        }

        System.out.print("Enter flight number to book (or 0 to go back): ");
        int flightNumber = readInt();
        if (flightNumber == 0) return;

        Flight selectedFlight = null;
        for (Flight flight : foundFlights) {
            if (flight.getFlightNumber() == flightNumber) {
                selectedFlight = flight;
                break;
            }
        }

        if (selectedFlight == null) {
            System.out.println("Invalid flight number.");
        } else {
            bookFlight(selectedFlight);
        }
    }

    private static void bookFlight(Flight flight) {
        if (flight.getAvailableSeats() <= 0) {
            System.out.println("Sorry, no seats are available.");
            return;
        }

        System.out.println("\n--- Passenger Details ---");
        System.out.print("Passenger name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Age: ");
        int age = readInt();
        if (age <= 0 || age > 120) {
            System.out.println("Please enter a valid age.");
            return;
        }

        System.out.print("Gender: ");
        String gender = sc.nextLine().trim();
        System.out.print("Phone number: ");
        String phone = sc.nextLine().trim();

        if (gender.isEmpty() || phone.isEmpty()) {
            System.out.println("Gender and phone number are required.");
            return;
        }

        Passenger passenger = new Passenger(name, age, gender, phone);

        System.out.println("\n--- Demo Payment ---");
        System.out.println("1. UPI (Demo)");
        System.out.println("2. Card (Demo)");
        System.out.println("3. Cash at Counter (Demo)");
        System.out.print("Choose payment method: ");
        int paymentChoice = readInt();

        String paymentMethod;
        if (paymentChoice == 1) {
            paymentMethod = "UPI (Demo)";
        } else if (paymentChoice == 2) {
            paymentMethod = "Card (Demo)";
        } else if (paymentChoice == 3) {
            paymentMethod = "Cash at Counter (Demo)";
        } else {
            System.out.println("Invalid payment option. Booking not completed.");
            return;
        }

        Booking booking = new Booking(flight, passenger, paymentMethod);
        loggedInUser.getBookings().add(booking);
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);

        System.out.println("\nBooking successful!");
        booking.displayTicket();
    }

    private static void viewBookings() {
        ArrayList<Booking> bookings = loggedInUser.getBookings();

        if (bookings.size() == 0) {
            System.out.println("You have no bookings.");
            return;
        }

        System.out.println("\n--- My Bookings ---");
        for (Booking booking : bookings) {
            booking.displayTicket();
        }
    }

    private static void cancelBooking() {
        ArrayList<Booking> bookings = loggedInUser.getBookings();

        if (bookings.size() == 0) {
            System.out.println("You have no bookings to cancel.");
            return;
        }

        System.out.print("Enter booking ID to cancel: ");
        int id = readInt();

        for (Booking booking : bookings) {
            if (booking.getBookingId() == id && booking.isActive()) {
                booking.cancel();
                System.out.println("Booking cancelled successfully.");
                return;
            }
        }

        System.out.println("Active booking not found with this ID.");
    }

    private static int readInt() {
        try {
            int number = Integer.parseInt(sc.nextLine().trim());
            return number;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
