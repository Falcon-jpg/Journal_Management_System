# Spring Boot Journal Application

This Spring Boot application uses MongoDB Atlas for its database, consisting of two collections: `Users` and `Journal Entries`. Each user has their own set of journal entries.

## Roles and Permissions

- **USER** (default): Can manage their own profile and journal entries.
- **ADMIN**: Can manage all users and create new admin users.

## Endpoints

The application provides four major endpoints:

1. **Public Endpoints**
   - **Signup / Login**: Allows users to sign up and log in. On successful login, a JWT token is provided.
   - **Authorization**: No authorization is required for these actions.

2. **User Endpoints**
   - **Profile Management**: Allows users to edit their username and password.
   - **Authorization**: Requires a valid JWT token.

3. **Admin Endpoints**
   - **User Management**: Admins can create new admin users and manage all users.
   - **Authorization**: Requires admin privileges.

4. **Journal Endpoints**
   - **Journal Entries Management**: Users can view, edit, and delete their own journal entries.
   - **Authorization**: Requires a valid JWT token.



