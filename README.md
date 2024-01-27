# Library Management System (Command-line Application)

## Overview
This is a simple command-line library management system implemented in Java. The system allows administrators and users to register, log in, and perform basic book management operations, such as viewing the book list, borrowing and returning books, adding new books, and deleting books.

## Features
1. User and Administrator Registration:
   * Users (User) and Administrators (Admin) can register with the system.
2. User and Administrator Login:
   * Registered users and administrators can log in to the system.
3. Book Management:
   * Users can view the list of books, borrow multiple books, and return these books.
   * Administrators can view the list of books, add new books, and delete books.
   * If a book is already in the system and the administrator tries to add it again, the system merges the inventory.
   * Administrators cannot delete books that are currently being borrowed by users.

## Command-line Input/Output Examples
* Register Admin: $ register admin Alice password1
* Register User: $ register user Bob password2
* Admin Login: $ login Alice password1
* Add Book: $ add "Clean Code" "Robert C. Martin" 5
* List Books: $ list
* User Login: $ login Bob password2
* Search Book: $ search "Clean Code" "Robert C. Martin"
* Borrow Book: $ borrow "Clean Code" "Robert C. Martin"
* Return Book: $ return "Clean Code" "Robert C. Martin"
* Admin Delete Book: $ delete "Clean Code" "Robert C. Martin"

## How to Run
1. Ensure you have Java11 installed on your machine.
2. Compile the source code
3. Run the application: java LibraryManagementSystem

## Notes
* This is a basic implementation, and you can enhance it based on specific requirements.
* Error handling and additional features can be added for a more robust system.

Feel free to customize and expand the functionality as needed for your library management system.