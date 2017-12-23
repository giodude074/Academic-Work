<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! //static turn, loaded once. values will not change
char[] board = {'_','_','_','_','_','_','_','_','_'}; //default value, placeholder for each spot on board
int turn = 0; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tic Tac Toe</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	</head>
	<body>
		<%
		if (request.getParameter("reset") != null) {
			for (int i = 0; i < board.length; i++)
				board[i] = '_';
			turn = 0;
		}
			
		char player = turn%2 == 0? 'X': 'O'; // if turn # is even player marker is assigned to X, otherwise O.
		boolean win = false;
		boolean tie = false;
		String temp = request.getParameter("location"); //request get the location parameter, which on teh 1st turn is null
		if (temp != null) { //so we check if its not null
			int index = Integer.parseInt(temp); //we set it as the index, but parse it 1st cause its a string
			if (board[index] == '_') { //look at the board array index and check if its undescore, or a usable box.
				turn++;
				board[index] = player; // change the index to corresponding player marker

				//columns
				for (int i = 0; i < 3; i++)
					if (board[i] == player && board[i+3] == player && board[i+6] == player)
						win = true;
				//rows
				for (int i = 0; i < 9; i+=3)
					if (board[i] == player && board[i+1] == player && board[i+2] == player)
						win = true;
				//diagonals
				if (board[0] == player && board[4] == player && board[8] == player)
					win = true;
				
				if (board[2] == player && board[4] == player && board[6] == player)
					win = true;
				
				if (turn == 9 && !win)
					tie = true;
			}
		}
		%>
		<div class="container">
			<div class="page-header">
				<h1><%= tie? "Oh no! It's a tie.": win? "Player " + player + " won!": "Player " + player + "'s turn" %> <small>Tic Tac Toe</small></h1>
			</div>
			<div class="row">
				<div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
					<a href='TicTacToe.jsp?location=0' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=<%= board[0] %>' alt='Open Space'></a>
				</div>
				<div class="col-sm-2 col-xs-4 text-center">
					<a href='TicTacToe.jsp?location=1' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=<%= board[1] %>' alt='Open Space'></a>
				</div>
				<div class="col-sm-2 col-xs-4 text-center">
					<a href='TicTacToe.jsp?location=2' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=<%= board[2] %>' alt='Open Space'></a>
				</div>
			</div> <!--  end row -->
			<div class="row">
				<div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
					<a href='TicTacToe.jsp?location=3' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=<%= board[3] %>' alt='Open Space'></a>
				</div>
				<div class="col-sm-2 col-xs-4 text-center">
					<a href='TicTacToe.jsp?location=4' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=<%= board[4] %>' alt='Open Space'></a>
				</div>
				<div class="col-sm-2 col-xs-4 text-center">
					<a href='TicTacToe.jsp?location=5' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=<%= board[5] %>' alt='Open Space'></a>
				</div>
			</div> <!--  end row -->
			<div class="row">
				<div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
					<a href='TicTacToe.jsp?location=6' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=<%= board[6] %>' alt='Open Space'></a>
				</div>
				<div class="col-sm-2 col-xs-4 text-center">
					<a href='TicTacToe.jsp?location=7' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=<%= board[7] %>' alt='Open Space'></a>
				</div>
				<div class="col-sm-2 col-xs-4 text-center">
					<a href='TicTacToe.jsp?location=8' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=<%= board[8] %>' alt='Open Space'></a>
				</div>
			</div> <!--  end row -->
			
			<p class="text-center">
				<a href="TicTacToe.jsp?reset" class="btn btn-lg btn-primary">New Game</a>
			</p>
		</div> <!-- end container -->
	</body>
</html>