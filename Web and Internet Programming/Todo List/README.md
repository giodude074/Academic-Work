### Specifications:

In this assignment you are to create a Todo app. Your application must use a MySQL database for all data storage. Your implementation should follow a Model-View-Controller approach.

Todo.jsp

You must place thie file in your WEB-INF folder on CS3. A User should never be allowed to request this file directly.

Todo Controller (Servlet)

```
Todo - GET request

On a GET request, your Todo controller should query your database for all todos regardless of their state. These Todos should be stored in two different collections:


	todos collection

	
		You should store all done and notdone todos in a collection named todos.
	
	
	archived collection
	
		You should store all archived todos in a collection named archived.
	
	



The possible states are:


	done
	notdone
	archived


Note: These states are case-sensitive.


The Todo.jsp page will expect these collections to exist.
```

```
Todo - POST request

The form on the Todo.jsp page will submit the new Todo information back to the Todo controller using a POST request. The form submits a single parameter named description. This is the description of the new task to be created. By default, a task should be in the notdone state.


If the description parameter is null, or the empty string, you are to create an attribute named error in the REQUEST scope, and redisplay the JSP page.


Upon completion of the task, the controller will redirect the User back to the Todo Controller.

Update Controller (Servlet)

You must create an Update Servlet. This servlet will expect a GET Request containing the following parameters:


	id

	
		This is the id of the todo record that is being updated in the database
	
	
	state
	
		This is what the new state of the todo record will be in the database
	
	


This controller is simply used for modifying the state of a todo.


Note: The Update Controller can only toggle states between done and notdone. It can not be used to archive todos!


Upon completion of the task, the controller will redirect the User back to the Todo Controller.
```

```
Archive Controller (Servlet)

You must create an Archive Servlet. This controller does not expect any request parameters. However, on a GET request, this controller will change the state of all todos that are currently done to a new state, archived.

Upon completion of it;s task, the controller will redirect the User back to the Todo Controller.
```


```
Reset Controller (Servlet)

You must create a Reset Servlet.

This controller does not expect any request parameters. However, on a GET request, this controller will remove of all todos that are currently in your database.

Upon completion of it's task, the controller will redirect the User back to the Todo Controller.
```

