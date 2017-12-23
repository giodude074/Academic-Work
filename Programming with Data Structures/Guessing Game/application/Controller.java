package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class Controller {
	@FXML
	private Text txtWord;
	@FXML
	private Text txtA, txtB, txtC, txtD, txtE, txtF, txtG, txtH, txtI, txtJ, txtK, txtL, txtM, txtN, txtO, txtP, txtQ,
	txtR, txtS, txtT, txtU, txtV, txtW, txtX, txtY, txtZ; //array use ascii code
//	@FXML
//	private AnchorPane alphabet;
	@FXML
	private ImageView pokeballs, pokemonImage;

	private int guesses;
	private String word, hiddenWord;
	private String[] words;
	ArrayList<String> guessedLetters;
	private boolean gameover;
	private Random rand;

	private void resetGame() {
		guessedLetters.clear();
		word = words[rand.nextInt(words.length)].toLowerCase();
		pokeballs.setImage(new Image("images/pokeball0.png"));
		initialize();
		gameover = false;
		guesses = 0;

		txtA.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtB.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtC.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtD.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtE.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtF.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtG.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtH.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtI.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtJ.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtK.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtL.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtM.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtN.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtO.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtP.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtQ.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtR.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtS.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtT.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtU.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtV.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtW.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtX.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtY.setStyle("-fx-fill: #000; -fx-font-weight: normal;");
		txtZ.setStyle("-fx-fill: #000; -fx-font-weight: normal;");

	}

	public Controller() {
		rand = new Random();
		//words = "ditto jigglypuff pikachu scyther gengar mankey hitmonchan kangaskhan aerodactyl snorlax kabutops growlithe".split(" ");
		words = "ditto cubone electrode gengar jigglypuff kabuto caterpie magikarp poliwag diglet pidgeotto".split(" ");
		//eevee is ditto, electrode is jigglypuff form above
		word = words[rand.nextInt(words.length)].toLowerCase();
		guesses = 0;
		guessedLetters = new ArrayList<>();
		gameover = false;
	}

	public void handleInput(KeyEvent event) {
		String letter = event.getText();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Press Enter to play again.");
		if (event.getCode() != KeyCode.ENTER && !gameover) { // If it is not entered
			char c = letter.charAt(0);
			changeTextColor(letter);
			if (letterInWord(word, c)) {
				ArrayList<Integer> charIndex = indexRecurrence(word, c);
				hiddenWord = revealLetters(hiddenWord, c, charIndex);
				txtWord.setText(hiddenWord);
				if (hiddenWord.toLowerCase().equals(word)){
					pokemonImage.setImage(new Image("images/"+word+"2.png"));
					alert.setTitle(":D");
					alert.setHeaderText("YOU WIN! You're a Pokemon Master :D");
					alert.showAndWait();
					//System.out.printf("You win!! You're a Pokemon Master :D Press Enter to play again.");
					gameover = true;
				}
			} else {
				if (!guessedLetters.contains(letter))
					guessedLetters.add(letter);

				if (++guesses <= 7) {
					pokeballs.setImage(new Image("images/pokeball" + guesses + ".png"));
					System.out.println(Math.abs(guesses - 7) + " tries left. ");

					if (guesses == 7) {
						pokemonImage.setImage(new Image("images/"+word+"3.png"));
						alert.setAlertType(AlertType.ERROR);
						alert.setTitle(":(");
						alert.setHeaderText("You fainted!");
						alert.setContentText("Press Enter to go to the Pokemon Center and try again.");
						alert.showAndWait();
						//System.out.println("You fainted! Press enter to go to the pokemon center and try again.");
						gameover = true;
					}
				}
			}
		} else if (gameover && event.getCode() == KeyCode.ENTER){
			resetGame();
		}
	}

	private static boolean letterInWord(String word, char c) {
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == c)
				return true;
		return false;
	}

	private static String revealLetters(String hiddenWord, char c, ArrayList<Integer> indexRecurrence) {
		char[] placeHolder = hiddenWord.toCharArray();
		for (Integer index : indexRecurrence)
			placeHolder[index] = c;
		return new String(placeHolder);
	}

	private static ArrayList<Integer> indexRecurrence(String word, char character) {
		ArrayList<Integer> indexRecurrence = new ArrayList<>();
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == character)
				indexRecurrence.add(i);
		return indexRecurrence;
	}

	public void initialize() {
		hiddenWord = makeHiddenWord(word);
		txtWord.setText(hiddenWord); // change asterisk
		pokemonImage.setImage(new Image("images/"+word+"1.png"));
	}

	private static String makeHiddenWord(String string) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < string.length(); i++)
			if (string.charAt(i) != ' ')
				sb.append('*');
		return sb.toString();
	}

//TODO - make code more efficient
	private void changeTextColor(String keyValue) {
		if (keyValue.equals("a"))txtA.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("b"))txtB.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("c"))txtC.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("d"))txtD.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("e"))txtE.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("f"))txtF.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("g"))txtG.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("h"))txtH.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("i"))txtI.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("j"))txtJ.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("k"))txtK.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("l"))txtL.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("m"))txtM.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("n"))txtN.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("o"))txtO.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("p"))txtP.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("q"))txtQ.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("r"))txtR.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("s"))txtS.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("t"))txtT.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("u"))txtU.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("v"))txtV.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("w"))txtW.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("x"))txtX.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("y"))txtY.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
		if (keyValue.equals("z"))txtZ.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");


	}

//	private void changeTextColor(String keyValue) {
//		for (Node node : alphabet.getChildren()) {
//			if (node instanceof Text)
//			Text letter = (Text) node;
//			if (letter.getText().equals(keyValue)) {
//				letter.setText("_");
//			}
//		}
//	}
}