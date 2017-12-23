### Specifications:
Login
In this assignment you are to create a Login Servlet that allows Users who are registered on your website to login to your online store. The requirements are listed below:

```
Form

Your login form should consist of text, password, and checkbox form elements named email, password, and rememberMe, respectively.

Your form should submit a POST request back to the Login servlet. Your servlet should then validate the credentials by finding the User object in the users collection stored in the Servlet Context that matches the e-mail and password that were submitted.

If no User can be found with the specified credentials, you should re-display the form with a message that reads, "Invalid Username and/or Password".

If the submitted credentials match a User, your servlet should perform the following actions:

    If the rememberMe checkbox was checked, create a cookie named username and store the User's e-mail address.
    Create a Session attribute named CurrentUser, and store the User object that corresponds to the credentials that were submitted.
    Re-direct the User to the inventory page.
```

```
Cookies

When a User visits your page, you should pre-populate the e-mail field with the User's e-mail if the username cookie exists.
Logout

Add a link to your Inventory servlet that allows a User to logout from your site. This should invalidate the session that is associated with the current User.
```