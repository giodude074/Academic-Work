<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="game" class="beans.BoardBean" scope="session"/> <!--game is an instance of class BoardBean-->
<jsp:setProperty property="*" name="game"/> <!-- any parameter you pass in the url has to be mapped with a setter-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tic Tac Toe</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<style type="text/css">
			.thumbnail {
				margin-bottom: 10px;
			}
			body {
				background-image: url('../images/city.jpg');
		
			}
			.col-lg-1, .col-lg-10, .col-lg-11, .col-lg-12, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-md-1, .col-md-10, .col-md-11, .col-md-12, .col-md-2, .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-sm-1, .col-sm-10, .col-sm-11, .col-sm-12, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9, .col-xs-1, .col-xs-10, .col-xs-11, .col-xs-12, .col-xs-2, .col-xs-3, .col-xs-4, .col-xs-5, .col-xs-6, .col-xs-7, .col-xs-8, .col-xs-9{
				padding-right: 5px;
				padding-left: 5px;
			}
	
			.message{
				color: #fffff;
			}
			#retroshadow{
				font-family: "Avant Garde", Avantgarde, "Century Gothic", CenturyGothic, "AppleGothic", sans-serif;
  				font-size: 50px;
 				padding-top: 50px; 
 				text-transform: uppercase;
  				text-rendering: optimizeLegibility;
  				
  				color: #2c2c2c;
   				letter-spacing: .05em;
   				text-shadow: 
      			4px 4px 0px #d5d5d5, 
     			7px 7px 0px rgba(0, 0, 0, 0.2);
			}
			
			h1 {
				padding-left: 50px;
				}
				
			#button {
			    top: 100px;
			    left: 200px;
			    display: inline-block;
			    margin: 0 auto;
    
			    -webkit-border-radius: 10px;
			    
			    -webkit-box-shadow: 
			        0px 3px rgba(128,128,128,1), /* gradient effects */
			        0px 4px rgba(118,118,118,1),
			        0px 5px rgba(108,108,108,1),
			        0px 6px rgba(98,98,98,1),
			        0px 7px rgba(88,88,88,1),
			        0px 8px rgba(78,78,78,1),
			        0px 14px 6px -1px rgba(128,128,128,1); /* shadow */
			    
			    -webkit-transition: -webkit-box-shadow .1s ease-in-out;
			} 

			#button span {

			    background-image: 
			        /* gloss gradient */
			        -webkit-gradient(
			            linear, 
			            left bottom, 
			            left top, 
			            color-stop(50%,rgba(255,255,255,0)), 
			            color-stop(50%,rgba(255,255,255,0.3)), 
			            color-stop(100%,rgba(255,255,255,0.2))),
			        
			        /* dark outside gradient */
			        -webkit-gradient(
			            linear, 
			            left top, 
			            right top, 
			            color-stop(0%,rgba(210,210,210,0.3)), 
			            color-stop(20%,rgba(210,210,210,0)), 
			            color-stop(80%,rgba(210,210,210,0)), 
			            color-stop(100%,rgba(210,210,210,0.3))),
			        
			        /* light inner gradient */
			        -webkit-gradient(
			            linear, 
			            left top, 
			            right top, 
			            color-stop(0%,rgba(255,255,255,0)), 
			            color-stop(20%,rgba(255,255,255,0.5)), 
			            color-stop(80%,rgba(255,255,255,0.5)), 
			            color-stop(100%,rgba(255,255,255,0))),        
			        
			        /* diagonal line pattern */
			        -webkit-gradient(
			            linear, 
			            0% 100%, 
			            100% 0%, 
			            color-stop(0%,rgba(255,255,255,0)), 
			            color-stop(40%,rgba(255,255,255,0)), 
			            color-stop(40%,#D2D2D1), 
			            color-stop(60%,#D2D2D1), 
			            color-stop(60%,rgba(255,255,255,0)), 
			            color-stop(100%,rgba(255,255,255,0)));
			    
			        -webkit-box-shadow:
			            0px -1px #fff, /* top highlight */
			            0px 1px 1px #FFFFFF; /* bottom edge */
			    
			    -webkit-background-size: 100%, 100%, 100%, 4px 4px;
			    
			    -webkit-border-radius: 10px;
			    -webkit-transition: -webkit-transform .1s ease-in-out;
			    
			    display: inline-block;
			    padding: 4px 12px 6px 20px;
			    
			    color: #3A474D;
			    text-transform: uppercase;
			    font-family: 'TradeGothicLTStd-BdCn20','PT Sans Narrow';
			    font-size: 20px;
			    
			    text-shadow: 0px 1px #fff, 0px -1px #262F33;
			}

        #button span:hover {
            color: #439386;
            text-shadow: 0px -1px #97A63A;
            cursor: pointer;
        }

        #button:active {
            -webkit-box-shadow: 
                0px 3px rgba(128,128,128,1),
                0px 4px rgba(118,118,118,1),
                0px 5px rgba(108,108,108,1),
                0px 6px rgba(98,98,98,1),
                0px 7px rgba(88,88,88,1),
                0px 8px rgba(78,78,78,1),
                0px 10px 2px 0px rgba(128,128,128,.6); /* shadow */
        }

        #button:active span{
            -webkit-transform: translate(0, 5px); /* depth of button press */
        }

	    #button span:after {
	        content: ">";
	   
	        width: 10px;
	        height: 10px;
	    
	        right: 14px;
	        top: 12px;    
	        
	        font-family: 'Cabin';
	        color: #439386;
	        text-shadow: 0px 1px #fff, 0px -1px #97A63A;
	        font-size: 26px;
	    }
	    
	    #bottom{
	        margin-bottom: 40px;
	    }
	    
	    .page-header {
    		margin: 40px 0 45px;
		}
		
	    
		</style>
	</head>
	<body>
		<div class="container">
			<div class="page-header">
				<div class="message" id="retroshadow">Tic Tac Toe</div> <h1 class="message"> ${game.message} </h1>
			</div>
			<div id ="board">
				<div class="row">
					<div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
						<a href='TicTacToe.jsp?location=0' class='thumbnail'><img src='http://placehold.it/150/ffffff?text=${game.board[0]}' alt='Open Space'></a>
					</div>
					<div class="col-sm-2 col-xs-4 text-center">
						<a href='TicTacToe.jsp?location=1' class='thumbnail'><img src='http://placehold.it/150/ffffff?text=${game.board[1]}' alt='Open Space'></a>
					</div>
					<div class="col-sm-2 col-xs-4 text-center">
						<a href='TicTacToe.jsp?location=2' class='thumbnail'><img src='http://placehold.it/150/ffffff?text=${game.board[2]}' alt='Open Space'></a>
					</div>
				</div> <!--  end row -->
				<div class="row">
					<div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
						<a href='TicTacToe.jsp?location=3' class='thumbnail'><img src='http://placehold.it/150/ffffff?text=${game.board[3]}' alt='Open Space'></a>
					</div>
					<div class="col-sm-2 col-xs-4 text-center">
						<a href='TicTacToe.jsp?location=4' class='thumbnail'><img src='http://placehold.it/150/ffffff?text=${game.board[4]}' alt='Open Space'></a>
					</div>
					<div class="col-sm-2 col-xs-4 text-center">
						<a href='TicTacToe.jsp?location=5' class='thumbnail'><img src='http://placehold.it/150/ffffff?text=${game.board[5]}' alt='Open Space'></a>
					</div>
				</div> <!--  end row -->
				<div class="row" id="bottom">
					<div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
						<a href='TicTacToe.jsp?location=6' class='thumbnail'><img src='http://placehold.it/150/ffffff?text=${game.board[6]}' alt='Open Space'></a>
					</div>
					<div class="col-sm-2 col-xs-4 text-center">
						<a href='TicTacToe.jsp?location=7' class='thumbnail'><img src='http://placehold.it/150/ffffff?text=${game.board[7]}' alt='Open Space'></a>
					</div>
					<div class="col-sm-2 col-xs-4 text-center">
						<a href='TicTacToe.jsp?location=8' class='thumbnail'><img src='http://placehold.it/150/ffffff?text=${game.board[8]}' alt='Open Space'></a>
					</div>
				</div> <!--  end row -->
			</div>
			
			<p class="text-center">
				<a href="TicTacToe.jsp?reset=false"  id="button"> <span> Play Again! </span></a>
			</p>
		</div> <!-- end container -->
	</body>
</html>