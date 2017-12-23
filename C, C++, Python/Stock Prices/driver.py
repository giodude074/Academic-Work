import sys
#from stockprice import Stockprice

def main():
	
	#s = StockPrice()
	my_file = open('stockprices.txt', 'w')		# open file for writing in text, not binary, mode
	text = input('Give a list of Stock prices separated by spaces: ')
	size = my_file.write(text + '\n')			# returns number of characters written, including the literal
	my_file.close()
	
	my_file = open('stockprices.txt', 'r')		# open file for reading in text, not binary, mode
	text = my_file.read()
	print(text)
	my_file.close()
	
	
	
if __name__ == "__main__":
    sys.exit(main())